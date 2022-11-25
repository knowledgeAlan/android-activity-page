package com.zcdmaple.androidactivitypage.newarchitecture.modules;

import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.modules.core.RCTNativeAppEventEmitter;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;
import com.zcdmaple.androidactivitypage.AndroidTestTwo;

public class FirstModule extends ReactContextBaseJavaModule {
    private ReactApplicationContext mContext;

    public FirstModule(@Nullable ReactApplicationContext reactContext) {
        super(reactContext);
        this.mContext = reactContext;
    }

    @NonNull
    @Override
    public String getName() {
        return "FirstModule";
    }

    @ReactMethod
    public void testNative() {
        Log.d("==getConstants======","rrrr");
        Intent intent = new Intent(getCurrentActivity(),AndroidTestTwo.class);

        getCurrentActivity().startActivity(intent);


    }

    /**
     * 向RN发送消息
     * @param msg
     */
    public void sendMsgToRN(String msg) {
        Log.e("---","sendMsgToRN");
        mContext.getJSModule(RCTNativeAppEventEmitter.class)

                .emit("EventAlipayCamera", msg);
    }

}
