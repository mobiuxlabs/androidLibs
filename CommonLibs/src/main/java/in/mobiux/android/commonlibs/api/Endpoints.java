package in.mobiux.android.commonlibs.api;

import in.mobiux.android.commonlibs.BuildConfig;

public class Endpoints {

    //    public static final String BASE_URL_AUTH = "https://ikprotostage.hito.solutions/api/v1/";
    //    endpoint pointing to staging server
    private static final String BASE_URL_STAGING = "https://ikprotostage.hito.solutions/api/v1/";
//    public static final String BASE_URL_STAGING = "https://6b30-106-51-78-204.ngrok.io/api/v1/";
    //    endpoint for item inventory
    private static final String BASE_URL_PRODUCTION = "https://ikproto.hito.solutions/api/v1/";

    public static String getBaseUrl() {
//       return BuildConfig.BASE_URL;
        return BASE_URL_PRODUCTION;
    }

    public static final String LOGS = "tracking/device-log/";
}
