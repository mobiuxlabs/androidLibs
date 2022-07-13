package in.mobiux.android.apps.activity;

import android.os.Bundle;

import in.mobiux.android.commonlibs.activity.AppActivity;
import in.mobiux.android.commonlibs.utils.AppLogger;

public class BaseActivity extends AppActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppLogger.getInstance();
    }
}
