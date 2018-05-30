package cn.ecook.basedemo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cn.ecook.base.base.BasePresenter;
import cn.ecook.base.base.ui.BaseActivity;
import cn.ecook.basedemo.R;
import cn.ecook.basedemo.fragment.TabFragment;

/**
 * @author : ciba
 * @date : 2018/5/28
 * @description : replace your description
 */

public class AppBarLayoutActivity extends BaseActivity {
    private static final String[] TITLES = {"TAB1", "TAB2", "TAB3"};
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public static void jumpHere(Context context) {
        context.startActivity(new Intent(context, AppBarLayoutActivity.class));
    }

    @Override
    public int contentView() {
        return R.layout.activity_appbar;
    }

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
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
        final List<Fragment> fragmentList = new ArrayList<>();
        for (int i = 0; i < TITLES.length; i++) {
            TabFragment tabFragment = new TabFragment();
            fragmentList.add(tabFragment);
        }
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return TITLES[position];
            }
        });
        tabLayout.setupWithViewPager(viewPager);
    }
}
