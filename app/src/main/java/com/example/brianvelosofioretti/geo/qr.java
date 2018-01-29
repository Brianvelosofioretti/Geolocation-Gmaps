package com.example.brianvelosofioretti.geo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class qr extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private TextView texto;
    private ZXingScannerView mScannerView;
    // para identificar logs
    static final String TAG = "escaneoQR";

    private static final int MY_PERMISSIONS = 1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Programmatically initialize the scanner view
        mScannerView = new ZXingScannerView(this);
        texto=(TextView) findViewById(R.id.textoqr);
        // Set the scanner view as the content view
        setContentView(mScannerView);
        Log.v(TAG, "Inicializado scan");

        // Pido permiso para usar la CAMARA
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CAMERA)) {
                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA},
                        MY_PERMISSIONS);
                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    // Cuando la cámara identifica el QR lanza este método
    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here
        Log.v(TAG, rawResult.getText()); // Prints scan results
        Log.v(TAG, rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode, pdf417 etc.)

        AlertDialog.Builder build=new AlertDialog.Builder(this);

        build.setTitle("!!!Banana!!!");

        build.setMessage(rawResult.getText());

        AlertDialog alert=build.create();
        alert.show();



 mScannerView.resumeCameraPreview(this);

        switch (rawResult.getText()){

            case "banana_kiosco": MapsActivity.marker.setVisible(false);
            MapsActivity.circle.setVisible(false);
            MapsActivity.circle2.setVisible(false);
            MapsActivity.circle3.setVisible(false);
            break;

            case "banana_pizza":MapsActivity.marker2.setVisible(false);
                MapsActivity.circle.setVisible(false);
                MapsActivity.circle2.setVisible(false);
                MapsActivity.circle3.setVisible(false);

            break;

            case "banana_callejon":MapsActivity.marker3.setVisible(false);
                MapsActivity.circle.setVisible(false);
                MapsActivity.circle2.setVisible(false);
                MapsActivity.circle3.setVisible(false);

            break;

            case "banana_fuente":MapsActivity.marker4.setVisible(false);
                MapsActivity.circle.setVisible(false);
                MapsActivity.circle2.setVisible(false);
                MapsActivity.circle3.setVisible(false);

            break;

        }

    }
}

