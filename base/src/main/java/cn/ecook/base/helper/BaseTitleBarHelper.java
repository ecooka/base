package cn.ecook.base.helper;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;

import cn.ecook.base.R;
import cn.ecook.base.base.BaseConfig;
import cn.ecook.base.listener.SingleClickListener;
import cn.ecook.base.util.DisplayUtil;
import cn.ecook.base.widget.TitleBar;

/**
 * @author ciba
 * @date 2018/4/4
 * @description 基类的TitleBar帮助类
 */

public class BaseTitleBarHelper {

    private final Activity activity;
    private final int dp48;
    private final View contentView;
    private TitleBar titleBar;

    public BaseTitleBarHelper(@NonNull Activity activity, View contentView) {
        this.activity = activity;
        this.contentView = contentView;
        contentView.setBackgroundColor(0xffffffff);
        // TitleBar 默认为48dp
        dp48 = DisplayUtil.dp2px(activity, 48);
    }

    /**
     * 设置TitleBar是否可见
     *
     * @param visible ：是否可见
     */
    public void setTitleVisible(boolean visible) {
        if (titleBar != null) {
            titleBar.setVisibility(visible ? View.VISIBLE : View.GONE);
        }
        changedContentMargin();
    }

    /**
     * 设置标题，调用此方法会默认创建TitleBar - initTitleBar（）
     *
     * @param title ：标题
     */
    public void setTitle(String title) {
        initTitleBar();
        if (titleBar != null) {
            titleBar.setTitle(title);
        }
    }

    /**
     * 设置左边返回按钮点击监听
     *
     * @param listener ：单击监听
     */
    public void setLeftListener(SingleClickListener listener) {
        if (titleBar != null) {
            titleBar.setLeftClickListener(listener);
        }
    }

    /**
     * 设置左边返回按钮是否可见
     *
     * @param visible ：是否可见
     */
    public void setLeftVisible(boolean visible) {
        if (titleBar != null) {
            titleBar.setLeftVisible(visible);
        }
    }

    /**
     * 设置左边返回按钮的图标
     */
    public void setLeftIcon(@DrawableRes int icon) {
        if (titleBar != null) {
            titleBar.setLeftImageResource(icon);
        }
    }

    /**
     * 添加右边拓展的其他Action按钮
     *
     * @param actionList
     */
    public void addRightActions(TitleBar.ActionList actionList) {
        if (titleBar != null) {
            titleBar.addActions(actionList);
        }
    }

    /**
     * 获取TitleBar，可能为空
     */
    public TitleBar getTitleBar() {
        return titleBar;
    }

    public View getContentView(){
        return contentView;
    }

    /**
     * 初始化TitleBar
     */
    private void initTitleBar() {
        if (titleBar != null) {
            return;
        }
        FrameLayout decorFrameLayout = getDecorFrameLayout();
        FrameLayout contentLayout = null;
        if (decorFrameLayout != null){
            contentLayout = decorFrameLayout.findViewById(Window.ID_ANDROID_CONTENT);
        }
        if (contentLayout != null) {
            titleBar = (TitleBar) LayoutInflater.from(activity).inflate(R.layout.layout_base_title_bar, null, false);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                titleBar.setElevation(BaseConfig.TITLE_BAR_ELEVATION);
            }
            setLeftIcon(0 == BaseConfig.DEFAULT_GO_BACK ? R.drawable.titlebar_return_icon_black : BaseConfig.DEFAULT_GO_BACK);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp48);
            titleBar.setLayoutParams(layoutParams);
            contentLayout.addView(titleBar);
            changedContentMargin();
        }
    }

    /**
     * 更加TitleBar的显示与否，改变内容布局的位置
     */
    private void changedContentMargin() {
        if (contentView != null && titleBar != null && activity != null) {
            ViewGroup.LayoutParams layoutParams = contentView.getLayoutParams();
            if (layoutParams != null && layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) layoutParams;
                params.topMargin = View.GONE == titleBar.getVisibility() ? 0 : dp48;
            }
        }
    }

    /**
     * 获取getDecorView
     */
    public FrameLayout getDecorFrameLayout() {
        if (activity == null){
            return null;
        }
        Window window = activity.getWindow();
        if (window == null) {
            return null;
        }
        View decorView = window.getDecorView();
        if (decorView == null) {
            return null;
        }
        if (decorView instanceof FrameLayout) {
            return (FrameLayout) decorView;
        }
        return null;
    }
}
