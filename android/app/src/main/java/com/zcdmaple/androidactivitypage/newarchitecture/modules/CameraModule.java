package com.zcdmaple.androidactivitypage.newarchitecture.modules;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.google.zxing.client.android.Intents;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class CameraModule  extends ReactContextBaseJavaModule {

    private static final int IMAGE_PICKER_REQUEST = 1;
    private static final String E_ACTIVITY_DOES_NOT_EXIST = "E_ACTIVITY_DOES_NOT_EXIST";
    private static final String E_PICKER_CANCELLED = "E_PICKER_CANCELLED";
    private static final String E_FAILED_TO_SHOW_PICKER = "E_FAILED_TO_SHOW_PICKER";
    private static final String E_NO_IMAGE_DATA_FOUND = "E_NO_IMAGE_DATA_FOUND";

    private Promise mPickerPromise;
    private Callback testCallback;
    private final ActivityEventListener mActivityEventListener = new BaseActivityEventListener() {

        @Override
        public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent intent) {
            if (requestCode == IMAGE_PICKER_REQUEST) {
                String dataString = intent.getDataString();
                if(dataString != null){
                    Log.d("dataString==","not null");
                    testCallback.invoke(dataString);
                    Log.d("dataString==","not null success");
                }else {
                    Log.d("test--","empty===");
                }

            }
        }
    };
    public CameraModule(@Nullable ReactApplicationContext reactContext) {
        super(reactContext);
        // Add the listener for `onActivityResult`
        reactContext.addActivityEventListener(mActivityEventListener);
    }

    @NonNull
    @Override
    public String getName() {
        return "CustomCameraModule";
    }
    @ReactMethod
    public void pickImage(Callback callback) {
        Activity currentActivity = getCurrentActivity();


        this.testCallback = callback;
        try {
            ScanOptions scanOptions = new ScanOptions();
            scanOptions.setPrompt("Scan Qrcode ");
            scanOptions.setBeepEnabled(true);
            scanOptions.setOrientationLocked(true);
            scanOptions.setCaptureActivity(CaptureAct.class);
//            barLauncher.launch(scanOptions);
//            new ScanContract();
            final Intent galleryIntent = new Intent(Intents.Scan.ACTION);

//            galleryIntent.setType("image/*");
//
//            final Intent chooserIntent = Intent.createChooser(galleryIntent, "Pick an image");

            currentActivity.startActivityForResult(galleryIntent, IMAGE_PICKER_REQUEST);
        } catch (Exception e) {
         e.printStackTrace();
        }
    }
}
