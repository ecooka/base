package cn.ecook.base.util;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import cn.ecook.base.R;

/**
 * @author 63062
 * @date 2017/10/21
 */

public class GlideUtil {
    private static final Map<String, String> fragmentImageList = new ConcurrentHashMap<>();
    private static final int[] RES = {R.drawable.default_dark_green, R.drawable.default_gray
            , R.drawable.default_light_green, R.drawable.default_pink};

    public static void display(Context context, Object uri, ImageView imageView) {
        display(context, uri, imageView, false);
    }

    /**
     * 加载图片(一般用于网络图片)
     *
     * @param context       ：上下文
     * @param uri           ：图片地址
     * @param imageView     ：加载控件
     * @param skipDiskCache ：是否需要缓存在本地
     */
    public static void display(Context context, Object uri, ImageView imageView, boolean skipDiskCache) {
        display(context, uri, imageView, createOption(skipDiskCache), true);
    }

    /**
     * 加载图片
     *
     * @param context        ：上下文
     * @param uri            ：图片地址
     * @param imageView      ：加载控件
     * @param requestOptions ：请求配置
     */
    public static void display(Context context, Object uri, ImageView imageView, RequestOptions requestOptions, boolean transition) {
        if (canDisplay(context, imageView)) {
            Glide.with(context)
                    .load(uri)
                    .apply(requestOptions == null ? createOption(false) : requestOptions)
                    .transition(transition ? new DrawableTransitionOptions().crossFade() : new DrawableTransitionOptions().dontTransition())
                    .into(imageView);
        }
    }

    /**
     * @return ：随机获取图片
     */
    public static int getRandomRes() {
        return RES[new Random().nextInt(RES.length)];
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
        if (context instanceof Activity && ((Activity) context).isDestroyed()) {
            return false;
        }
        return true;
    }

    /**
     * 创建默认的配置信息
     * @param skipDiskCache ：是否跳过sd卡缓存
     * @return
     */
    public static RequestOptions createOption(boolean skipDiskCache) {
        int randomRes = getRandomRes();
        RequestOptions options = new RequestOptions()
                .dontAnimate()
                .priority(Priority.NORMAL)
                .skipMemoryCache(true)
                .placeholder(randomRes)
                .error(randomRes)
                .diskCacheStrategy(skipDiskCache ? DiskCacheStrategy.NONE : DiskCacheStrategy.RESOURCE);
        return options;
    }
}
