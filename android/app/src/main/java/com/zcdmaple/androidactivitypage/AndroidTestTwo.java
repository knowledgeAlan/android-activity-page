package com.zcdmaple.androidactivitypage;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.react.ReactActivity;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;
import com.zcdmaple.androidactivitypage.newarchitecture.modules.CaptureAct;
import com.zcdmaple.androidactivitypage.newarchitecture.modules.RNActivity;

public class AndroidTestTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_test_two);

        Button nativeButton =findViewById(R.id.buttonCall);
        Button scanButton =findViewById(R.id.scan_btn);

        nativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                MainApplication.GetFirstPackage().firstModule.sendMsgToRN("hello world====");
//                startActivity(new Intent(AndroidTestTwo.this, RNActivity.class));
            }
        });

        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scanCode();
            }
        });



    }


    private void scanCode(){
        ScanOptions scanOptions = new ScanOptions();
        scanOptions.setPrompt("Scan Qrcode ");
        scanOptions.setBeepEnabled(true);
        scanOptions.setOrientationLocked(true);
        scanOptions.setCaptureActivity(CaptureAct.class);
        barLauncher.launch(scanOptions);
    }

    ActivityResultLauncher<ScanOptions> barLauncher = registerForActivityResult(new ScanContract(),res->{

        if(res != null){
            MainApplication.GetFirstPackage().firstModule.sendMsgToRN(res.getContents());
            startActivity(new Intent(AndroidTestTwo.this, RNActivity.class));
//            AlertDialog.Builder builder = new AlertDialog.Builder(AndroidTestTwo.this);
//            builder.setTitle("Result");
//            builder.setMessage(res.getContents());
//            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    dialogInterface.dismiss();
//                }
//            }).show();
        }
    });
}