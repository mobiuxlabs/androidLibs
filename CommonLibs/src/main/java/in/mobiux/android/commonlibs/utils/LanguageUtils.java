package in.mobiux.android.commonlibs.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.util.Locale;

import in.mobiux.android.commonlibs.activity.AppActivity;

public class LanguageUtils {

    private static final String TAG = "LanguageUtils";

    private Context context;
    private AppLogger logger;
    private SessionManager session;
    private static LanguageUtils languageUtils;

    public enum Language {

        ENGLISH("en"),
        GERMAN("de"),
        FRENCH("fr"),
        DUTCH("nl");

        private String language;

        Language(String language) {
            this.language = language;
        }

        public String getLanguage() {
            return language == null ? "en" : language;
        }
    }

    private LanguageUtils(Context context) {
        this.context = context;
        logger = AppLogger.getInstance();
        session = SessionManager.getInstance(context);
    }

    public static LanguageUtils getInstance(Context context) {
        if (languageUtils == null) {
            languageUtils = new LanguageUtils(context);
        }
        return languageUtils;
    }

    //    call this method onCreate in every activity
    public void setAppLanguage(Activity activity) {

        Language language = Language.valueOf(session.getStringValue("app_language"));
        Resources resources = context.getApplicationContext().getResources();
        Configuration config = resources.getConfiguration();
        DisplayMetrics dm = resources.getDisplayMetrics();
        if (language.equals(Language.ENGLISH)) {
            config.locale = Locale.ENGLISH;
        } else if (language.equals(Language.GERMAN)) {
            config.locale = Locale.GERMAN;
        } else if (language.equals(Language.FRENCH)) {
            config.locale = Locale.FRENCH;
        } else if (language.equals(Language.DUTCH)) {
            config.locale = new Locale("nl");
        } else {
            config.locale = Locale.ENGLISH;
        }

        resources.updateConfiguration(config, dm);
        activity.onConfigurationChanged(config);
    }

    public void switchLanguage(Activity activity, Language language) {
        session.setStringValue("app_language", language.getLanguage());
        setAppLanguage(activity);
    }
}
