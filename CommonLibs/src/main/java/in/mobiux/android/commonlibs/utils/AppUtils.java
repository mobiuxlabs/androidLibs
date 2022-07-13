package in.mobiux.android.commonlibs.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;


/**
 * Created by SUJEET KUMAR on 10-Mar-21.
 */
public class AppUtils {

    private static final String TAG = "AppUtils";

    //    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS'Z'", Locale.getDefault());
    static SimpleDateFormat simpleDateFormat = (SimpleDateFormat) DateFormat.getTimeInstance();

    static String format;

    public static String getFormattedTimestamp() {

        try {
            format = simpleDateFormat.format(new Date());
        } catch (Exception e) {
            return "" + format;
        }
        return format;
    }

    public static String getFormattedTimestampUpToSeconds() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = null;
        try {
            format = simpleDateFormat.format(new Date());
        } catch (Exception e) {
            return "" + format;
        }
        return format;
    }


    public static List<ActivityManager.RunningTaskInfo> getRunningApps(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> recentTasks = Objects.requireNonNull(activityManager).getRunningTasks(Integer.MAX_VALUE);

        for (ActivityManager.RunningTaskInfo taskInfo : recentTasks) {
            Log.i(TAG, "getRunningApps: " + taskInfo.baseActivity.getPackageName());
        }
        return recentTasks;
    }
}
