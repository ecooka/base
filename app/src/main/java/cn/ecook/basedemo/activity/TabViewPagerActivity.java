package cn.ecook.basedemo.activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.os.Bundle;
import com.socks.library.KLog;

import java.util.ArrayList;
import java.util.List;

import cn.ecook.base.base.BasePresenter;
import cn.ecook.base.base.ui.BaseStatusActivity;
import cn.ecook.base.widget.TabViewPager;
import cn.ecook.basedemo.R;
import cn.ecook.basedemo.fragment.ImageFragment;


/**
 * @author ciba
 * @date 2018/4/3
 * @description TabViewPager使用
 */
public class TabViewPagerActivity extends BaseStatusActivity {
    private static final String TAG = "TabViewPagerActivity";
    private TabViewPager tabViewPager;

    public static void jumpHere(@NonNull Context context){
        context.startActivity(new Intent(context, TabViewPagerActivity.class));
    }

    @Override
    public int contentView() {
        return R.layout.activity_tab_view_pager;
    }

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        tabViewPager = (TabViewPager) findViewById(R.id.tabViewPager);
    }

    @Override
    public void initListener() {
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
        setBaseTitle("TabViewPager使用");
        List<TabViewPager.Tab> tabList = new ArrayList<>();
        tabList.add(new TabViewPager.Tab("First", ImageFragment.instance("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=565285572,2311431934&fm=27&gp=0.jpg")));
        tabList.add(new TabViewPager.Tab("Second", ImageFragment.instance("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1637535468,2612371482&fm=27&gp=0.jpg")));
//        tabList.add(new TabViewPager.Tab("Third", ImageFragment.instance("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3104697540,4084345733&fm=27&gp=0.jpg")));
//        tabList.add(new TabViewPager.Tab("Fourth", ImageFragment.instance("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3104697540,4084345733&fm=27&gp=0.jpg")));
//        tabList.add(new TabViewPager.Tab("Fifth", ImageFragment.instance("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3104697540,4084345733&fm=27&gp=0.jpg")));
//        tabList.add(new TabViewPager.Tab("Sixth", ImageFragment.instance("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3104697540,4084345733&fm=27&gp=0.jpg")));

        tabViewPager.setOffscreenPageLimit(tabList.size());
        tabViewPager.setAdapter(new TabViewPager.TabAdapter(getSupportFragmentManager(), tabList));
    }

}
