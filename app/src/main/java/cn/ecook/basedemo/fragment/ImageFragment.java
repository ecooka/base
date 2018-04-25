package cn.ecook.basedemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import cn.ecook.base.base.BasePresenter;
import cn.ecook.base.base.ui.BaseFragment;
import cn.ecook.base.http.HttpUtil;
import cn.ecook.base.http.LoadingHttpCallBack;
import cn.ecook.base.listener.SingleClickListener;
import cn.ecook.base.util.GlideUtil;
import cn.ecook.base.widget.dialog.CameraPhotoDialog;
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
        ivImage.setOnClickListener(new SingleClickListener() {
            @Override
            public void onSingleClick(View view) {
                CameraPhotoDialog dialog = new CameraPhotoDialog(activity, "");
                dialog.show();
            }
        });
    }

    @Override
    public BasePresenter initBasePresenter() {
        return null;
    }

    @Override
    public void initData() {
        GlideUtil.display(activity, getArguments().getString(IMAGE_URL), ivImage);
        // 模拟获取数据
        HttpUtil.obGet("http://op.juhe.cn/onebox/football/league?key=bbdf40a269d0f08936ddb07b076be559&league=%E6%B3%95%E7%94%B2"
                , null, new LoadingHttpCallBack<String>(activity) {
                    @Override
                    public void success(String s) {
                        toast("success");
                    }

                    @Override
                    public void error(int code, String msg) {
                        toast("error");
                    }
                });
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (rootView == null){
            return;
        }
        rootView.setVisibility(isVisibleToUser ? View.VISIBLE : View.GONE);
    }
}
