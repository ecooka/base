package cn.ecook.base.adapter;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.github.chrisbanes.photoview.PhotoView;

import java.lang.ref.WeakReference;
import java.util.List;

import cn.ecook.base.R;
import cn.ecook.base.util.GlideUtil;

/**
 * @author ciba
 * @date 2018/4/3
 * @description : 图片适配器
 */

public class GalleryPagerAdapter extends PagerAdapter {

    private final List<String> imageUrl;
    private final RequestOptions options;
    private View.OnClickListener onClickListener;

    public GalleryPagerAdapter(List<String> imageUrl) {
        this.imageUrl = imageUrl;
        options = new RequestOptions()
                .dontAnimate()
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
    }

    @Override
    public int getCount() {
        return imageUrl == null ? 0 : imageUrl.size();
    }

    @Override
    public View instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_base_gallery, null, false);

        PhotoView photoView = view.findViewById(R.id.photoView);
        photoView.setZoomable(true);
        View loading = view.findViewById(R.id.loading);

        GlideUtil.display(photoView.getContext(), imageUrl.get(position), photoView, options, true, new ImageLoadListener(loading));
        photoView.setOnClickListener(onClickListener);
        // Now just add PhotoView to ViewPager and return it
        container.addView(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public static class ImageLoadListener implements RequestListener<Drawable> {
        private final WeakReference<View> loading;

        public ImageLoadListener(View loading) {
            this.loading = new WeakReference<>(loading);
        }

        @Override
        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
            if (loading != null && loading.get() != null) {
                // 图片加载失败取消loading
                loading.get().setVisibility(View.GONE);
            }
            return false;
        }

        @Override
        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
            if (loading != null && loading.get() != null) {
                // 图片加载成功取消loading
                loading.get().setVisibility(View.GONE);
            }
            return false;
        }
    }

}
