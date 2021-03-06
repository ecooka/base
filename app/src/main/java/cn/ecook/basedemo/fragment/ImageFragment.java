package cn.ecook.basedemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import cn.ecook.base.base.BasePresenter;
import cn.ecook.base.base.ui.BaseFragment;
import cn.ecook.base.util.GlideUtil;
import cn.ecook.basedemo.R;

/**
 *
 * @author mcjs001
 * @date 2018/4/19
 */

public class ImageFragment extends BaseFragment {
    private static final String IMAGE_URL = "IMAGE_URL";
    private ImageView ivImage;

    public static ImageFragment instance(String imageUrl) {
        ImageFragment fragment = new ImageFragment();
        Bundle bundle = new Bundle();
        bundle.putString(IMAGE_URL, imageUrl);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int contentView() {
        return R.layout.fragment_image;
    }

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        ivImage = (ImageView) findViewById(R.id.ivImage);
    }

    @Override
    public void initListener() {
    }

    @Override
    public BasePresenter initBasePresenter() {
        return null;
    }

    @Override
    public void initData() {
        GlideUtil.display(activity, getArguments().getString(IMAGE_URL), ivImage);
    }
}
