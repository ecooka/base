package cn.ecook.basedemo.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.ecook.base.activity.GalleryActivity;
import cn.ecook.base.listener.SingleClickListener;
import cn.ecook.base.util.GlideUtil;
import cn.ecook.basedemo.R;

/**
 *
 * @author mcjs001
 * @date 2018/4/19
 */

public class ImageAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    private final Activity activity;

    public ImageAdapter(Activity activity) {
        super(R.layout.item_image);
        this.activity = activity;
    }

    @Override
    protected void convert(final BaseViewHolder holder, final String item) {
        ImageView ivImage = holder.getView(R.id.ivImage);
        GlideUtil.display(mContext, item, ivImage);
        ivImage.setOnClickListener(new SingleClickListener() {
            @Override
            public void onSingleClick(View view) {
                GalleryActivity.jumpHere(mContext, holder.getAdapterPosition(), true, getData());
            }
        });
    }
}
