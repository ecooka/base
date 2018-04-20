package cn.ecook.basedemo;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.socks.library.KLog;

import java.util.ArrayList;
import java.util.List;

import cn.ecook.base.base.BasePresenter;
import cn.ecook.base.base.ui.BaseStatusActivity;
import cn.ecook.base.listener.SingleClickListener;
import cn.ecook.base.util.GlideUtil;
import cn.ecook.base.widget.TabViewPager;

/**
 * @author mcjs001
 */
public class MainActivity extends BaseStatusActivity {
    private static final String TAG = "MainActivity";
    private ImageView ivImage;
    private TabViewPager tabViewPager;

    @Override
    public int contentView() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        tabViewPager = findViewById(R.id.tabViewPager);
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

        tabViewPager.setSimplePagerChangedListener(new TabViewPager.SimplePagerChangedListener() {
            @Override
            public void onPageSelected(int position) {
                KLog.e(TAG,"position is ... " + position);
                tabViewPager.refreshTitle(position, position + " - " + position);
            }
        });
    }

    @Override
    public BasePresenter initBasePresenter() {
        return null;
    }

    @Override
    public void initData() {
        GlideUtil.display(this, "http://mmbiz.qpic.cn/mmbiz_jpg/y5HvXaQmpqnJDza8ZxvcYnuAA2FEic8OyjJQ693xQcYlBZLAib4h2yApoQQJ1frbrq9AicqtrZcpYicOCLiaexlWoEw/640?wx_fmt=jpeg&tp=webp&wxfrom=5&wx_lazy=1", ivImage);
        List<TabViewPager.Tab> tabList = new ArrayList<>();
        tabList.add(new TabViewPager.Tab("First", ImageFragment.instance("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=565285572,2311431934&fm=27&gp=0.jpg")));
        tabList.add(new TabViewPager.Tab("Second", ImageFragment.instance("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1637535468,2612371482&fm=27&gp=0.jpg")));
        tabList.add(new TabViewPager.Tab("Third", ImageFragment.instance("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3104697540,4084345733&fm=27&gp=0.jpg")));
        tabList.add(new TabViewPager.Tab("Fourth", ImageFragment.instance("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3104697540,4084345733&fm=27&gp=0.jpg")));
        tabList.add(new TabViewPager.Tab("Fifth", ImageFragment.instance("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3104697540,4084345733&fm=27&gp=0.jpg")));
        tabList.add(new TabViewPager.Tab("Sixth", ImageFragment.instance("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3104697540,4084345733&fm=27&gp=0.jpg")));

        tabViewPager.setOffscreenPageLimit(tabList.size());
        tabViewPager.setAdapter(new TabViewPager.TabAdapter(getSupportFragmentManager(), tabList));
    }

}
