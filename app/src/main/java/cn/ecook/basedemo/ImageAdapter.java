package cn.ecook.basedemo;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.ecook.base.util.GlideUtil;

/**
 * Created by mcjs001 on 2018/4/19.
 */

public class ImageAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    private final Activity activity;

    public ImageAdapter(@Nullable List<String> data, Activity activity) {
        super(R.layout.item_image,data);
        this.activity = activity;
    }

    @Override
    protected void convert(BaseViewHolder holder, String item) {
        ImageView ivImage = holder.getView(R.id.ivImage);
        GlideUtil.display(ivImage.getContext(), item, ivImage);
    }
}
