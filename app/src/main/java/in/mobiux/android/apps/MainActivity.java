package in.mobiux.android.apps;


import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.zebra.sdl.BarcodeReaderBaseActivity;

import in.mobiux.android.commonlibs.utils.AppLogger;

public class MainActivity extends BarcodeReaderBaseActivity {

    private static final String TAG = "MainActivity";

    private Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOK = findViewById(R.id.btnOK);

        AppLogger appLogger = AppLogger.getInstance();
        appLogger.i(TAG, "onCreate Called...!");

        btnOK.setOnClickListener(view -> {
            appLogger.i(TAG, "Button is clicked...!");
            openCamera();
        });

        boolean cameraStatus = checkCameraHardware(getApplicationContext());
        Log.i(TAG, "onCreate: " + cameraStatus);
    }

    @Override
    public void onBarcodeScan(String barcode) {
//        super.onBarcodeScan(barcode);
        Toast.makeText(this, "" + barcode, Toast.LENGTH_SHORT).show();
    }

    private void openCamera() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);
    }

    /**
     * Check if this device has a camera
     */
    private boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            // this device has a camera

//            android.graphics.Camera camera = getCameraInstance();


            return true;
        } else {
            // no camera on this device
            return false;
        }
    }

    /** A safe way to get an instance of the Camera object. */
    public static Camera getCameraInstance(){
        Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
        }
        return c; // returns null if camera is unavailable
    }
}