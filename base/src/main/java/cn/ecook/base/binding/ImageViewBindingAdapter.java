package cn.ecook.base.binding;

import android.databinding.BindingAdapter;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import cn.ecook.base.util.GlideUtil;

/**
 *
 * @author ciba
 */
public final class ImageViewBindingAdapter {

    @BindingAdapter(value = {"imageUrl"}, requireAll = false)
    public static void setImageUri(ImageView imageView, String imageUrl) {
        loadImage(imageView, imageUrl);
    }

    @BindingAdapter(value = {"imageRes"}, requireAll = false)
    public static void setImageRes(ImageView imageView, int imageRes) {
        loadImage(imageView, imageRes);
    }

    private static void loadImage(ImageView imageView, Object object) {
        if (imageView == null){
            return;
        }
        GlideUtil.display(imageView.getContext(), object, imageView);
    }
}

