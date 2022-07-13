package in.mobiux.android.commonlibs.utils;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class App extends Application {

    private static final String TAG = "App";

    private List<Activity> activities = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
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

    @Override
    public void onTerminate() {
        super.onTerminate();
        finishAll();
    }
}
