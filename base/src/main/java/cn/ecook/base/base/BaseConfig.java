package cn.ecook.base.base;

import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;

/**
 * @author ciba
 * @date 2018/4/4
 * @description 全局数据配置
 */
public class BaseConfig {
    public static boolean DEBUG = true;
    public static int DEFAULT_GO_BACK = 0;
    public static int DEFAULT_LOADING_STATUS_RES = 0;
    public static int DEFAULT_EMPTY_STATUS_RES = 0;
    public static int DEFAULT_NETWORK_ERROR_STATUS_RES = 0;

    private BaseConfig() {

    }

    /**
     * 初始化debug状态
     * @param debug ：是否是debug
     */
    public static void init(boolean debug) {
        DEBUG = debug;
    }

    /**
     * 初始化统一返回按钮drawable 资源
     * @param defaultGoBack ：返回按钮drawable资源
     */
    public static void initGoBackDrawable(@DrawableRes int defaultGoBack) {
        DEFAULT_GO_BACK = defaultGoBack;
    }

    /**
     * 初始化多状态默认Layout资源
     * @param defaultLoadingStatusRes ：默认loading layout 资源
     * @param defaultEmptyStatusRes ：默认空布局 layout 资源
     * @param defaultNetworkErrorStatusRes ：默认网络异常 layout 资源
     */
    public static void initStatusRes(@LayoutRes int defaultLoadingStatusRes, @LayoutRes int defaultEmptyStatusRes, @LayoutRes int defaultNetworkErrorStatusRes) {
        DEFAULT_LOADING_STATUS_RES = defaultLoadingStatusRes;
        DEFAULT_EMPTY_STATUS_RES = defaultEmptyStatusRes;
        DEFAULT_NETWORK_ERROR_STATUS_RES = defaultNetworkErrorStatusRes;
    }
}
