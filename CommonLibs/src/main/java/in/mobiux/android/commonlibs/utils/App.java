package in.mobiux.android.commonlibs.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

//Application class of any app must extends this class to use this library, otherwise it will through exception "cannot be cast to ....App"
public class App extends Application {

    private static final String TAG = "App";

    private List<Activity> activities = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        initLibrary(this);
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public void finishAll() {
        for (Activity activity : activities) {
            activity.finish();
        }
    }

    public static void initLibrary(Context context) {
        FileUtils.init(context);
        SessionManager.init(context);
        LanguageUtils.getInstance(context);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        finishAll();
    }
}
