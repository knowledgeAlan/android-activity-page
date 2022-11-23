package com.zcdmaple.androidactivitypage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.react.ReactActivity;
import com.zcdmaple.androidactivitypage.newarchitecture.modules.RNActivity;

public class AndroidTestTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_test_two);

        Button nativeButton =findViewById(R.id.buttonCall);

        nativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AndroidTestTwo.this, RNActivity.class));
            }
        });
    }
}