package in.mobiux.android.commonlibs.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import in.mobiux.android.commonlibs.utils.App;
import in.mobiux.android.commonlibs.utils.AppLogger;
import in.mobiux.android.commonlibs.utils.SessionManager;

public class AppActivity extends AppCompatActivity {


    private static final String TAG = "AppActivity";
    private App app;
    private SessionManager sessionManager;
    private AppLogger logger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        app = (App) getApplicationContext();
        sessionManager = SessionManager.getInstance(this);
        logger = AppLogger.getInstance();
        app.addActivity(this);
//        LanguageUtils.getInstance(this).setAppLanguage(AppActivity.this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        app.removeActivity(this);
    }

    protected void launchActivity(Class<?> cls){
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

    protected SessionManager getSessionManager() {
        return sessionManager;
    }
}