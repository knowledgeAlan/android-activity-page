package com.zcdmaple.androidactivitypage.newarchitecture.modules;

import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.zcdmaple.androidactivitypage.AndroidTestTwo;

public class FirstModule extends ReactContextBaseJavaModule {
    public FirstModule(@Nullable ReactApplicationContext reactContext) {
        super(reactContext);
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
}
