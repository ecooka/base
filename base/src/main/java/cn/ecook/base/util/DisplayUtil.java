package cn.ecook.base.util;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * @author ciba
 * @date 2018/4/3
 * @description ：显示工具类，获取屏幕宽高，dp px转换
 */

public class DisplayUtil {
    /**
     * 获取屏幕宽度
     */
    public static int getScreenWidth(Context context) {
        DisplayMetrics metrics = getDisplayMetrics(context);
        return metrics == null ? 0 : metrics.widthPixels;
    }

    /**
     * 获取屏幕高度
     */
    public static int getScreenHeight(Context context) {
        DisplayMetrics metrics = getDisplayMetrics(context);
        return metrics == null ? 0 : metrics.heightPixels;
    }

    /**
     * dip转px
     */
    public static int dp2px(Context context, int dp) {
        DisplayMetrics metrics = getDisplayMetrics(context);
        return metrics == null ? 0 : (int) (metrics.density * dp + 0.5f);
    }

    private static DisplayMetrics getDisplayMetrics(Context context) {
        if (context == null) {
            return null;
        }
        return context.getResources().getDisplayMetrics();
    }
}
