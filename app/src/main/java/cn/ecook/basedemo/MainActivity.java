package cn.ecook.basedemo;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import cn.ecook.base.base.BasePresenter;
import cn.ecook.base.base.ui.BaseStatusActivity;
import cn.ecook.base.http.HttpUtil;
import cn.ecook.base.http.LoadingHttpCallBack;
import cn.ecook.base.listener.SingleClickListener;
import cn.ecook.base.util.GlideUtil;

public class MainActivity extends BaseStatusActivity {
    private ViewPager viewPager;
    private ImageView ivImage;

    @Override
    public int contentView() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        viewPager = findViewById(R.id.viewPager);
        ivImage = findViewById(R.id.ivImage);
    }

    @Override
    public void initListener() {
        ivImage.setOnClickListener(new SingleClickListener() {
            @Override
            public void onSingleClick(View view) {
                startActivity(new Intent(MainActivity.this, TestActivity.class));
            }
        });
    }

    @Override
    public BasePresenter initBasePresenter() {
        return null;
    }

    @Override
    public void initData() {
        GlideUtil.display(this, "http://mmbiz.qpic.cn/mmbiz_jpg/y5HvXaQmpqnJDza8ZxvcYnuAA2FEic8OyjJQ693xQcYlBZLAib4h2yApoQQJ1frbrq9AicqtrZcpYicOCLiaexlWoEw/640?wx_fmt=jpeg&tp=webp&wxfrom=5&wx_lazy=1",ivImage);
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(ImageFragment.instace("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=565285572,2311431934&fm=27&gp=0.jpg"));
        fragmentList.add(ImageFragment.instace("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1637535468,2612371482&fm=27&gp=0.jpg"));
        fragmentList.add(ImageFragment.instace("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3104697540,4084345733&fm=27&gp=0.jpg"));

        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), fragmentList));
        viewPager.setOffscreenPageLimit(fragmentList.size() - 1);
    }

    private static class FragmentAdapter extends FragmentPagerAdapter {

        private final List<Fragment> fragmentList;

        public FragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
            super(fm);
            this.fragmentList = fragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList == null ? 0 : fragmentList.size();
        }
    }
}
