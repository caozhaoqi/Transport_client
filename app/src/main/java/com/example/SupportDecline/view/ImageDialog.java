package com.example.SupportDecline.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.SupportDecline.R;


/**
 * @see android.app.Dialog
 */
public class ImageDialog extends Dialog {

    private Bitmap bmp;

    private String title;

    /**
     * @param context
     */
    public ImageDialog(@NonNull Context context) {
        super(context);
    }

    public ImageDialog addBitmap(Bitmap bmp) {
        if (bmp != null) {
            this.bmp = bmp;
        }
        return this;
    }

    public ImageDialog addTitle(String title) {
        if (title != null) {
            this.title = title;
        }
        return this;
    }

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_dialog);

        ImageView imageView = findViewById(R.id.image_dialog_imageView);
        TextView textView = findViewById(R.id.image_dialog_textView);

        if (bmp != null) {
            imageView.setImageBitmap(bmp);
        }

        if (title != null) {
            textView.setText(this.title);
        }
    }

    /**
     *
     */
    @Override
    public void dismiss() {
        assert bmp != null;
//v  v  v  v        bmp.recycle();cv
        bmp = null;
        System.gc();
        super.dismiss();
    }
}