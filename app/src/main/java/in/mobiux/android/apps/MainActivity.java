package in.mobiux.android.apps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import in.mobiux.android.commonlibs.utils.AppLogger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppLogger.getInstance();
    }
}