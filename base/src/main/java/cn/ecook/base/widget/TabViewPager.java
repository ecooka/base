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
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.socks.library.KLog;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Random;

import cn.ecook.base.R;
import cn.ecook.base.util.DisplayUtil;

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
    private boolean lineFixContent;
    private boolean fixMode;

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
            fixMode = array.getBoolean(R.styleable.TabViewPager_fix, true);
            tabLayout.setTabMode(fixMode ? TabLayout.MODE_FIXED : TabLayout.MODE_SCROLLABLE);
            tabLayout.setSelectedTabIndicatorColor(array.getColor(R.styleable.TabViewPager_tabIndicatorColor, DEFAULT_SELECTED_COLOR));
            tabLayout.setTabTextColors(array.getColor(R.styleable.TabViewPager_tabTextColor, DEFAULT_NORMAL_COLOR), array.getColor(R.styleable.TabViewPager_tabSelectedTextColor, DEFAULT_SELECTED_COLOR));
            tabLayout.setSelectedTabIndicatorHeight((int) array.getDimension(R.styleable.TabViewPager_tabIndicatorHeight, DisplayUtil.dp2px(getContext(), 4)));

            tabUp = array.getBoolean(R.styleable.TabViewPager_tabUp, true);
            int tabViewPagerSpace = (int) array.getDimension(R.styleable.TabViewPager_tabViewPagerSpace, 0);

            lineFixContent = array.getBoolean(R.styleable.TabViewPager_lineFixContent, false);

            int tabHeight = (int) array.getDimension(R.styleable.TabViewPager_tabHeight, DisplayUtil.dp2px(getContext(), 48));
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
        if (lineFixContent && fixMode){
            lineFixContent();
        }
    }

    /**
     * 下划线和内容保持同一长度
     * 只有在lineFixContent和fixMode同时满足的情况下会执行
     */
    private void lineFixContent() {
        try {
            int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
            int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
            tabLayout.measure(w,h);
            int tabLayoutWidth = tabLayout.getMeasuredWidth();

            Class<?> cls = tabLayout.getClass();
            Field tabStrip = cls.getDeclaredField("mTabStrip");
            tabStrip.setAccessible(true);
            LinearLayout llTab = (LinearLayout) tabStrip.get(tabLayout);
            for (int i = 0; i < llTab.getChildCount(); i++) {
                TabLayout.Tab tabAt = tabLayout.getTabAt(i);
                View child = llTab.getChildAt(i);
                if (tabAt == null || tabAt.getText() == null || child == null || !(child instanceof ViewGroup)) {
                    continue;
                }
                String text = tabAt.getText().toString();
                ViewGroup childGroup = (ViewGroup) child;
                int width = 0;
                for (int j = 0; j < childGroup.getChildCount(); j++) {
                    View childAt = childGroup.getChildAt(j);
                    if (childAt instanceof TextView){
                        TextView textView = (TextView) childAt;
                        if (text.equals(textView.getText().toString())){
                            width = (int) textView.getPaint().measureText(text);
                        }
                    }
                }

                LinearLayout.LayoutParams params = (LayoutParams) child.getLayoutParams();
                if (width == 0 || params == null){
                    return;
                }

                KLog.e("TAG", tabLayout.getWidth());

                child.setPadding(0, 0, 0, 0);
                params.rightMargin = (tabLayoutWidth - width) / 2;
                params.leftMargin = (tabLayoutWidth - width) / 2;
                child.setLayoutParams(params);
                child.invalidate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
