package cn.ecook.base.binding;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import cn.ecook.base.util.GlideUtil;

/**
 *
 * @author ciba
 */
public final class ImageViewBindingAdapter {

    @BindingAdapter(value = {"imageUrl"}, requireAll = false)
    public static void setImageUri(ImageView imageView, String imageUrl) {
        loadImage(imageView, imageUrl, false);
    }

    @BindingAdapter(value = {"imageRes"}, requireAll = false)
    public static void setImageRes(ImageView imageView, int imageRes) {
        loadImage(imageView, imageRes, true);
    }

    private static void loadImage(ImageView imageView, Object object, boolean res) {
        if (imageView == null){
            return;
        }
        if (res){
            GlideUtil.displayNoPlaceErrorCache(imageView.getContext(), object, imageView);
        } else {
            GlideUtil.display(imageView.getContext(), object, imageView);
        }
    }
}

