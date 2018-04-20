package cn.ecook.base.base;

/**
 * @author ciba
 */
public class BaseConfig {
    public static boolean DEBUG = true;
    public static int DEFAULT_LOADING_STATUS_RES = 0;
    public static int DEFAULT_EMPTY_STATUS_RES = 0;
    public static int DEFAULT_NETWORK_ERROR_STATUS_RES = 0;

    private BaseConfig() {

    }

    public static void init(boolean debug) {
        DEBUG = debug;
    }

    public static void initStatusRes(int defaultLoadingStausRes, int defaultEmptyStatusRes, int defaultNetworkErrorStatusRes) {
        DEFAULT_LOADING_STATUS_RES = defaultLoadingStausRes;
        DEFAULT_EMPTY_STATUS_RES = defaultEmptyStatusRes;
        DEFAULT_NETWORK_ERROR_STATUS_RES = defaultNetworkErrorStatusRes;
    }
}
