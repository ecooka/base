package cn.ecook.base.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import cn.ecook.base.R;
import cn.ecook.base.manager.AppManager;

/**
 * @author ciba
 * @date 2017/10/21
 */

public class GlideUtil {
    private static final Map<String, String> fragmentImageList = new ConcurrentHashMap<>();
    private static final int[] RES = {R.color.default_green, R.color.default_pink
            , R.color.default_purple, R.color.default_red};
    private static final Random random = new Random();

    private static final RequestOptions noPlaceErrorCacheOptions = new RequestOptions()
            .dontAnimate()
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE);

    public static void display(Context context, Object uri, ImageView imageView) {
        int randomRes = getRandomRes();
        RequestOptions requestOptions = new RequestOptions()
                .dontAnimate()
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .placeholder(randomRes)
                .error(randomRes);
        display(context, uri, imageView, requestOptions);
    }

    public static void displayNoPlaceErrorCache(Context context, Object uri, ImageView imageView) {
        display(context, uri, imageView, noPlaceErrorCacheOptions, null);
    }

    public static void display(Context context, Object uri, ImageView imageView, RequestOptions requestOptions) {
        display(context, uri, imageView, requestOptions, null);
    }

    /**
     * 加载图片
     *
     * @param context        ：上下文
     * @param uri            ：图片地址
     * @param imageView      ：加载控件
     * @param requestOptions ：请求配置
     */
    public static void display(Context context, Object uri, ImageView imageView, RequestOptions requestOptions, RequestListener<Drawable> listener) {
        if (canDisplay(context, imageView)) {
            Glide.with(context)
                    .load(uri)
                    .apply(requestOptions == null ? new RequestOptions()
                            .dontAnimate()
                            .diskCacheStrategy(DiskCacheStrategy.RESOURCE) : requestOptions)
                    .listener(listener)
                    .into(imageView);
        }
    }

    /**
     * @return ：随机获取图片
     */
    public static int getRandomRes() {
        return RES[random.nextInt(RES.length)];
    }

    /**
     * @param context   ：上下文
     * @param imageView ：图片控件
     * @return ：是否满足加载图片的条件
     */
    private static boolean canDisplay(Context context, ImageView imageView) {
        if (imageView == null || context == null) {
            return false;
        }
        if (context instanceof Activity && AppManager.getAppManager().activityIsFinish((Activity) context)) {
            return false;
        }
        return true;
    }

    /**
     * 暂停或开始图片加载
     *
     * @param context
     * @param resume
     */
    public static void resumeOrPauseRequest(Context context, boolean resume) {
        if (context != null) {
            return;
        }
        if (resume) {
            Glide.with(context).resumeRequests();
        } else {
            Glide.with(context).pauseRequests();
        }
    }
}
