package com.example.SupportDecline;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.SupportDecline.camera.CameraManager;
import com.example.SupportDecline.decode.CaptureActivityHandler;
import com.example.SupportDecline.decode.DecodeManager;
import com.example.SupportDecline.decode.InactivityTimer;
import com.example.SupportDecline.tess.TesseractCallback;
import com.example.SupportDecline.tess.TesseractThread;
import com.example.SupportDecline.utils.Tools;
import com.example.SupportDecline.view.ImageDialog;
import com.example.SupportDecline.view.ScannerFinderView;
import com.google.zxing.Result;

import java.io.IOException;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;

/**
 * 二维码扫描类。
 */
public class ScannerActivity extends AppCompatActivity implements Callback, Camera.PictureCallback, Camera.ShutterCallback {

    Bitmap bmp;
    private CaptureActivityHandler mCaptureActivityHandler;
    private boolean mHasSurface;
    private InactivityTimer mInactivityTimer;
    private ScannerFinderView mQrCodeFinderView;
    private SurfaceView mSurfaceView;
    private ViewStub mSurfaceViewStub;
    private DecodeManager mDecodeManager = new DecodeManager();
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private Switch switch1;
    private Button bt;
    private ProgressDialog progressDialog;
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            bt.setEnabled(true);
            cancelProgressDialog();
            switch (msg.what) {
                case 0:
                    phoneSucceed((String) msg.obj, bmp);
                    break;
                case 1:
                    Toast.makeText(ScannerActivity.this, "无法识别", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    };

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        if (ContextCompat.checkSelfPermission(this, CAMERA) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{CAMERA, READ_EXTERNAL_STORAGE}, 100);
        } else {
            initView();
            initData();
        }
    }

    /**
     * @param requestCode  请求码
     * @param grantResults 结果
     * @param permissions  权限
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100) {
            boolean permissionGranted = true;
            for (int i : grantResults) {
                if (i != PackageManager.PERMISSION_GRANTED) {
                    permissionGranted = false;
                }
            }
            if (permissionGranted) {
                initView();
                initData();
            } else {
                // 无权限退出
                finish();
            }
        }
    }

    private void initView() {
        mQrCodeFinderView = findViewById(R.id.qr_code_view_finder);
        mSurfaceViewStub = findViewById(R.id.qr_code_view_stub);
        switch1 = findViewById(R.id.switch1);
        mHasSurface = false;

        bt = findViewById(R.id.bt);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt.setEnabled(false);
                buildProgressDialog();
                CameraManager.get().takeShot(ScannerActivity.this, ScannerActivity.this, ScannerActivity.this);
            }
        });

        @SuppressLint("UseSwitchCompatOrMaterialCode")
        Switch switch2 = findViewById(R.id.switch2);
        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CameraManager.get().setFlashLight(isChecked);
            }
        });
    }

    /**
     * Getter for property 'cropRect'.
     *
     * @return Value for property 'cropRect'.
     */
    public Rect getCropRect() {
        return mQrCodeFinderView.getRect();
    }

    /**
     * Getter for property 'QRCode'.
     *
     * @return Value for property 'QRCode'.
     */
    public boolean isQRCode() {
        return switch1.isChecked();
    }

    private void initData() {
        mInactivityTimer = new InactivityTimer(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onResume() {
        super.onResume();
        if (mInactivityTimer != null) {
            CameraManager.init();
            initCamera();
        }
    }

    private void initCamera() {
        if (null == mSurfaceView) {
            mSurfaceViewStub.setLayoutResource(R.layout.layout_surface_view);
            mSurfaceView = (SurfaceView) mSurfaceViewStub.inflate();
        }
        SurfaceHolder surfaceHolder = mSurfaceView.getHolder();
        if (mHasSurface) {
            initCamera(surfaceHolder);
        } else {
            surfaceHolder.addCallback(this);
            // 防止sdk8的设备初始化预览异常(可去除，本项目最小16)
            surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        }
    }

    /** {@inheritDoc} */
    @Override
    protected void onPause() {
        if (mCaptureActivityHandler != null) {
            try {
                mCaptureActivityHandler.quitSynchronously();
                mCaptureActivityHandler = null;
                if (null != mSurfaceView && !mHasSurface) {
                    mSurfaceView.getHolder().removeCallback(this);
                }
                CameraManager.get().closeDriver();
            } catch (Exception e) {
                // 关闭摄像头失败的情况下,最好退出该Activity,否则下次初始化的时候会显示摄像头已占用.
                finish();
            }
        }
        super.onPause();
    }

    /** {@inheritDoc} */
    @Override
    protected void onDestroy() {
        if (null != mInactivityTimer) {
            mInactivityTimer.shutdown();
        }
        super.onDestroy();
    }

    /**
     * Handler scan result
     *
     * @param result
     */
    public void handleDecode(Result result) {
        mInactivityTimer.onActivity();
        if (null == result) {
            mDecodeManager.showCouldNotReadQrCodeFromScanner(this, new DecodeManager.OnRefreshCameraListener() {
                @Override
                public void refresh() {
                    restartPreview();
                }
            });
        } else {
            handleResult(result);
        }
    }

    /**
     * @param surfaceHolder 上级视图
     */
    private void initCamera(SurfaceHolder surfaceHolder) {
        try {
            if (!CameraManager.get().openDriver(surfaceHolder)) {
                return;
            }
        } catch (IOException e) {
            // 基本不会出现相机不存在的情况
            Toast.makeText(this, getString(R.string.camera_not_found), Toast.LENGTH_SHORT).show();
            finish();
            return;
        } catch (RuntimeException re) {
            re.printStackTrace();
            return;
        }
        mQrCodeFinderView.setVisibility(View.VISIBLE);
        findViewById(R.id.qr_code_view_background).setVisibility(View.GONE);
        if (mCaptureActivityHandler == null) {
            mCaptureActivityHandler = new CaptureActivityHandler(this);
        }
    }

    public void restartPreview() {
        if (null != mCaptureActivityHandler) {
            try {
                mCaptureActivityHandler.restartPreviewAndDecode();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param format 格式
     * @param height 高度
     * @param holder 上级视图
     * @param width  宽度
     */
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    /**
     * @param holder 上级视图
     */
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if (!mHasSurface) {
            mHasSurface = true;
            initCamera(holder);
        }
    }

    /**
     * @param holder 上级视图
     */
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mHasSurface = false;
    }

    /**
     * Getter for property 'captureActivityHandler'.
     *
     * @return Value for property 'captureActivityHandler'.
     */
    public Handler getCaptureActivityHandler() {
        return mCaptureActivityHandler;
    }

    /**
     * @param result 返回结果
     */
    private void handleResult(Result result) {
        if (TextUtils.isEmpty(result.getText())) {
            mDecodeManager.showCouldNotReadQrCodeFromScanner(this, new DecodeManager.OnRefreshCameraListener() {
                @Override
                public void refresh() {
                    restartPreview();
                }
            });
        } else {
            Vibrator vibrator = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(200L);
            if (switch1.isChecked()) {
                qrSucceed(result.getText());
            } else {
                phoneSucceed(result.getText(), result.getBitmap());
            }
        }
    }

    /**
     * @param data   得到数据
     * @param camera 摄像机对象
     */
    @Override
    public void onPictureTaken(@NonNull byte[] data, @NonNull Camera camera) {

        if (data == null) {
            return;
        }
        mCaptureActivityHandler.onPause();
        bmp = null;
        try {
            bmp = Tools.getFocusedBitmap(this, camera, data, getCropRect());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            TesseractThread mTesseractThread = new TesseractThread(bmp, new TesseractCallback() {

                @Override
                public void succeed(String result) {
                    Message message = Message.obtain();
                    message.what = 0;
                    message.obj = result;
                    mHandler.sendMessage(message);
                }

                @Override
                public void fail() {
                    Message message = Message.obtain();
                    message.what = 1;
                    mHandler.sendMessage(message);
                }
            });

            Thread thread = new Thread(mTesseractThread);
            thread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** {@inheritDoc} */
    @Override
    public void onShutter() {
    }

    /**
     * @param result 返回结果
     */
    private void qrSucceed(String result) {
        AlertDialog dialog = new AlertDialog.Builder(this).setTitle(R.string.notification)
                .setMessage(result)
                .setPositiveButton(R.string.positive_button_confirm, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        restartPreview();
                    }
                })
                .show();
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                restartPreview();
            }
        });
    }

    /**
     * @param result 返回结果
     * @param bitmap 拍照所得图片对象
     */
    void phoneSucceed(String result, Bitmap bitmap) {
        ImageDialog dialog = new ImageDialog(this);
        // dialog.addBitmap(bitmap);
        dialog.addTitle(TextUtils.isEmpty(result) ? "未识别到手机号码" : result);
        dialog.addTitle(result.equals("") ? "未识别到手机号码" : result);
        dialog.setTitle(result);
        dialog.show();
        Toast.makeText(ScannerActivity.this, result, Toast.LENGTH_LONG).show();
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {

                restartPreview();

            }
        });

        @SuppressLint("ResourceType")
//        View androidContentFirstChild = ((ViewGroup)findViewById(R.layout.view_amount));
//        EditText editText = androidContentFirstChild.findViewById(R.id.stepper);
                APPData appData = (APPData) getApplicationContext();
        int i = appData.i;
        appData.phoneNumber_scan[i] = result;
        appData.qhm[i] = appData.amount + appData.i;
        startActivity(new Intent(ScannerActivity.this, ScanActivity.class));
        i++;
        appData.i += 1;
        appData.jumpFlag = false;

    }

    public void buildProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        }
        progressDialog.setMessage("识别中...");
        progressDialog.setCancelable(true);
        progressDialog.show();
    }

    public void cancelProgressDialog() {
        if (progressDialog != null) {
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }
    }
}