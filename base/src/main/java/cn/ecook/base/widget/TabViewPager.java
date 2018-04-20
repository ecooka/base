package cn.ecook.base.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;
import java.util.Random;

import cn.ecook.base.R;

/**
 * @author ciba
 * @date 2018/4/3
 * @description : TabLayout + ViewPager
 */

public class TabViewPager extends LinearLayout {
    private static final int DEFAULT_NORMAL_COLOR = 0xff333333;
    private static final int DEFAULT_SELECTED_COLOR = 0xffffc000;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public TabViewPager(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TabViewPager(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        setOrientation(VERTICAL);
        tabLayout = new TabLayout(getContext());
        tabLayout.setId(new Random().nextInt(Integer.MAX_VALUE));

        viewPager = new ViewPager(getContext());
        viewPager.setId(new Random().nextInt(Integer.MAX_VALUE));
        boolean tabUp = true;

        if (attrs != null) {
            TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.TabViewPager);
            tabLayout.setTabMode(array.getBoolean(R.styleable.TabViewPager_fix, true) ? TabLayout.MODE_FIXED : TabLayout.MODE_SCROLLABLE);
            tabLayout.setSelectedTabIndicatorColor(array.getColor(R.styleable.TabViewPager_tabIndicatorColor, DEFAULT_SELECTED_COLOR));
            tabLayout.setTabTextColors(array.getColor(R.styleable.TabViewPager_tabTextColor, DEFAULT_NORMAL_COLOR), array.getColor(R.styleable.TabViewPager_tabSelectedTextColor, DEFAULT_SELECTED_COLOR));
            tabLayout.setSelectedTabIndicatorHeight((int) array.getDimension(R.styleable.TabViewPager_tabIndicatorHeight, dp2px(4)));

            tabUp = array.getBoolean(R.styleable.TabViewPager_tabUp, true);
            int tabViewPagerSpace = (int) array.getDimension(R.styleable.TabViewPager_tabViewPagerSpace, 0);

            int tabHeight = (int) array.getDimension(R.styleable.TabViewPager_tabHeight, dp2px(48));
            LayoutParams tabParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, tabHeight);
            tabLayout.setLayoutParams(tabParams);

            LayoutParams vpParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            vpParams.setMargins(0, tabUp ? tabViewPagerSpace : 0, 0, tabUp ? 0 : tabViewPagerSpace);
            vpParams.weight = 1;
            viewPager.setLayoutParams(vpParams);
            array.recycle();
        }
        addView(viewPager);
        addView(tabLayout, tabUp ? 0 : 1);
    }

    public void setAdapter(TabAdapter adapter) {
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    /**
     * 更新指定tab的文案
     *
     * @param tabIndex ：tab下标
     * @param title    ：标题
     */
    public void refreshTitle(int tabIndex, String title) {
        if (tabIndex < 0 || tabIndex >= tabLayout.getTabCount()) {
            return;
        }
        tabLayout.getTabAt(tabIndex).setText(title);
    }

    /**
     * 设置简易的界面改变监听
     *
     * @param listener ：简易Pager变化监听
     */
    public void setSimplePagerChangedListener(SimplePagerChangedListener listener) {
        viewPager.addOnPageChangeListener(listener);
    }

    public void setOffscreenPageLimit(int limit) {
        viewPager.setOffscreenPageLimit(limit);
    }

    public TabLayout getTabLayout() {
        return tabLayout;
    }

    public ViewPager getViewPager() {
        return viewPager;
    }

    private float dp2px(int dp) {
        return getContext().getResources().getDisplayMetrics().density * dp;
    }

    public static class TabAdapter extends FragmentPagerAdapter {

        private final List<Tab> tabList;

        public TabAdapter(FragmentManager fm, List<Tab> tabList) {
            super(fm);
            this.tabList = tabList;
        }

        @Override
        public Fragment getItem(int position) {
            return tabList.get(position).fragment;
        }

        @Override
        public int getCount() {
            return tabList == null ? 0 : tabList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabList.get(position).title;
        }
    }

    public static class Tab {
        public String title;
        public Fragment fragment;

        public Tab(String title, Fragment fragment) {
            this.title = title;
            this.fragment = fragment;
        }
    }

    public static abstract class SimplePagerChangedListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
