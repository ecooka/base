package cn.ecook.base.util;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;

import cn.ecook.base.base.BaseConfig;

/**
 * @author ciba
 * @date 2018/4/3
 * @description ：显示工具类，获取屏幕宽高，dp px转换
 */

public class DisplayUtil {
    private static float nonCompatDensity;
    private static float nonCompatScaledDensity;

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

    /**
     * 设置自定义density
     * 适配各个分辨率
     * todo need to check this is usable
     * @param activity
     */
    public static void setCustomDensity(Activity activity) {
        if (activity == null || activity.getApplication() == null){
            return;
        }
        final Application application = activity.getApplication();
        DisplayMetrics appDisplayMetrics = application.getResources().getDisplayMetrics();

        if (nonCompatDensity == 0){
            nonCompatDensity = appDisplayMetrics.density;
            nonCompatScaledDensity = appDisplayMetrics.scaledDensity;
            application.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(Configuration newConfig) {
                    if (newConfig != null && newConfig.fontScale > 0){
                        nonCompatScaledDensity = application.getResources().getDisplayMetrics().scaledDensity;
                    }
                }
                @Override
                public void onLowMemory() {

                }
            });
        }

        final float targetDensity = appDisplayMetrics.widthPixels / BaseConfig.DESIGN_WIDTH;
        final float targetScaleDensity = targetDensity * (nonCompatScaledDensity / nonCompatDensity);
        final int targetDensityDpi = (int) (160 * targetDensity);

        appDisplayMetrics.density = targetDensity;
        appDisplayMetrics.scaledDensity = targetScaleDensity;
        appDisplayMetrics.densityDpi = targetDensityDpi;

        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        displayMetrics.density = targetDensity;
        displayMetrics.scaledDensity = targetScaleDensity;
        displayMetrics.densityDpi = targetDensityDpi;
    }
}
