package com.zcdmaple.androidactivitypage.newarchitecture.modules;

import androidx.annotation.Nullable;

import com.facebook.react.ReactActivity;

public class RNActivity extends ReactActivity {
    @Nullable
    @Override
    protected String getMainComponentName() {
        return "application";
    }
}
