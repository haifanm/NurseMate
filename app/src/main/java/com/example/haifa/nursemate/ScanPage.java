package com.example.haifa.nursemate;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ScanPage extends AppCompatActivity {

    private static final String cameraPerm = Manifest.permission.CAMERA;

    // UI
    private TextView text;

    // QREader
    private SurfaceView mySurfaceView;
    private QREader qrEader;

    boolean hasCameraPermission = false;
    Context ctx=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_page);
        System.out.println("hasCameraPermission1"+hasCameraPermission);
        hasCameraPermission = RuntimePermissionUtil.checkPermissonGranted(this, cameraPerm);
//        hasCameraPermission=true;
        System.out.println("hasCameraPermission2"+hasCameraPermission);

        text = findViewById(R.id.code_info);
        String sessionId = getIntent().getStringExtra("state");
        if(sessionId=="false"){
            qrEader.start();
        }

       /* final Button stateBtn = findViewById(R.id.btn_start_stop);
        // change of reader state in dynamic
        stateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (qrEader.isCameraRunning()) {
                    stateBtn.setText("Start QREader");
                    qrEader.stop();
                } else {
                    stateBtn.setText("Stop QREader");
                    qrEader.start();
                }
            }
        });

        stateBtn.setVisibility(View.VISIBLE);*/

        /*Button restartbtn = findViewById(R.id.btn_restart_activity);
        restartbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restartActivity();
            }
        });*/

        // Setup SurfaceView
        // -----------------
        mySurfaceView = findViewById(R.id.camera_view);

        if (hasCameraPermission) {
            // Setup QREader
            setupQREader();

        } else {
            RuntimePermissionUtil.requestPermission((Activity) ctx, cameraPerm, 100);
        }

        if (!(qrEader.isCameraRunning())){
            if (hasCameraPermission) {
                // Setup QREader
                setupQREader();

            } else {
                RuntimePermissionUtil.requestPermission((Activity) ctx, cameraPerm, 100);
            }

        }




    }

    void restartActivity() {
        startActivity(new Intent(ctx,ScanPage.class));
        finish();
    }

    void setupQREader() {
        // Init QREader
        // ------------
        qrEader = new QREader.Builder(this, mySurfaceView, new QRDataListener() {
            @Override
            public void onDetected(final String data) {
                Log.d("QREader", "Value : " + data);


                text.post(new Runnable() {
                    @Override
                    public void run() {

                        //text.setText(data);
                        //Toast.makeText(getApplicationContext(),data, Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(ctx,HomePage.class);
//                        intent.putExtra("data",data);
                        startActivity(intent);

                    }
                });
            }
        }).facing(QREader.BACK_CAM)
                .enableAutofocus(true)
                .height(mySurfaceView.getHeight())
                .width(mySurfaceView.getWidth())
                .build();



    }

    @Override
    protected void onPause() {
        super.onPause();

        if (hasCameraPermission) {

            // Cleanup in onPause()
            // --------------------
            qrEader.releaseAndCleanup();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (hasCameraPermission) {

            // Init and Start with SurfaceView
            // -------------------------------
            qrEader.initAndStart(mySurfaceView);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull final String[] permissions,
                                           @NonNull final int[] grantResults) {
        if (requestCode == 100) {
            RuntimePermissionUtil.onRequestPermissionsResult(grantResults, new RPResultListener() {
                @Override
                public void onPermissionGranted() {
                    if ( RuntimePermissionUtil.checkPermissonGranted(ctx, cameraPerm)) {
                        restartActivity();
                    }
                }

                @Override
                public void onPermissionDenied() {
                    // do nothing
                }
            });
        }
    }
}
