package cn.ecook.base.util;

import android.support.annotation.LayoutRes;
import cn.ecook.base.widget.MultipleStatusView;
import cn.ecook.http.HttpCode;

/**
 *
 * @author ciba
 * @date 2018/4/3
 */

public class StatusUtil {
    /**
     * 切换为loading状态
     */
    public static void showLoading(MultipleStatusView multipleStatusView, int loadingLayoutRes) {
        try {
            if (multipleStatusView != null){
                if (loadingLayoutRes == 0 ){
                    multipleStatusView.showLoading();
                } else {
                    multipleStatusView.showLoading(loadingLayoutRes, multipleStatusView.DEFAULT_LAYOUT_PARAMS);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 隐藏loading状态，并展示内容布局
     */
    public static void dismissLoading(MultipleStatusView multipleStatusView) {
        showContent(multipleStatusView);
    }

    public static void dismissLoading(MultipleStatusView multipleStatusView, boolean showEmpty, int code, int emptyLayoutRes, int networkErrorLayoutRes) {
        if (HttpCode.EXCEPTION_NO_CONNECT == code || HttpCode.EXCEPTION_TIME_OUT == code){
            showNoNetwork(multipleStatusView, networkErrorLayoutRes);
        } else if (showEmpty) {
            showEmpty(multipleStatusView, emptyLayoutRes);
        } else {
            showContent(multipleStatusView);
        }
    }

    /**
     * 展示内容布局
     */
    private static void showContent(MultipleStatusView multipleStatusView) {
        try {
            if (multipleStatusView != null){
                multipleStatusView.showContent();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 展示空数据布局
     */
    public static void showEmpty(MultipleStatusView multipleStatusView, int emptyLayoutRes) {
        try {
            if (multipleStatusView != null){
                if (emptyLayoutRes == 0){
                    multipleStatusView.showEmpty();
                } else {
                    multipleStatusView.showEmpty(emptyLayoutRes, multipleStatusView.DEFAULT_LAYOUT_PARAMS);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 展示网络异常布局
     */
    public static void showNoNetwork(MultipleStatusView multipleStatusView, @LayoutRes int networkErrorLayoutRes) {
        try {
            if (multipleStatusView != null) {
                if (networkErrorLayoutRes == 0) {
                    multipleStatusView.showNoNetwork();
                } else {
                    multipleStatusView.showNoNetwork(networkErrorLayoutRes, multipleStatusView.DEFAULT_LAYOUT_PARAMS);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
