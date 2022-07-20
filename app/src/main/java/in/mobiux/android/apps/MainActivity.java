package in.mobiux.android.apps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;

import in.mobiux.android.commonlibs.activity.AppActivity;
import in.mobiux.android.commonlibs.utils.AppLogger;

public class MainActivity extends AppActivity {

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
        });

        Context context = getApplicationContext();
    }
}