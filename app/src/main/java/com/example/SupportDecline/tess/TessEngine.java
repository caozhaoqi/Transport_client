package com.example.SupportDecline.tess;

import android.graphics.Bitmap;
import android.util.Log;

import com.example.SupportDecline.APPData;
import com.example.SupportDecline.utils.Tools;
import com.googlecode.tesseract.android.TessBaseAPI;


/**
 * Created by Fadi on 6/11/2014.
 */
public class TessEngine {

    static final String TAG = "DBG_" + TessEngine.class.getName();

    /**
     * Do not instantiate TessEngine.
     */
    private TessEngine() {
    }

    public static TessEngine Generate() {
        return new TessEngine();
    }

    public String detectText(Bitmap bitmap) {
        Log.d(TAG, "Initialization of TessBaseApi");
        TessDataManager.initTessTrainedData(APPData.sAppContext);
        TessBaseAPI tessBaseAPI = new TessBaseAPI();
        String path = TessDataManager.getTesseractFolder();
        Log.d(TAG, "Tess folder: " + path);
        tessBaseAPI.setDebug(true);
        tessBaseAPI.init(path, "eng");
        // 白名单
        tessBaseAPI.setVariable(TessBaseAPI.VAR_CHAR_WHITELIST, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789");
        // 黑名单
        tessBaseAPI.setVariable(TessBaseAPI.VAR_CHAR_BLACKLIST, "!@#$%^&*()_+=-[]}{;:'\"\\|~`,./<>?");
        tessBaseAPI.setPageSegMode(TessBaseAPI.PageSegMode.PSM_AUTO_OSD);
        Log.d(TAG, "Ended initialization of TessEngine");
        Log.d(TAG, "Running inspection on bitmap");
        tessBaseAPI.setImage(bitmap);
        String inspection = tessBaseAPI.getHOCRText(0);

        Log.d(TAG, "Confidence values: " + tessBaseAPI.meanConfidence());
        tessBaseAPI.end();
        System.gc();
        return Tools.getTelNum(inspection);
    }

}
