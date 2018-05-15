package cn.ecook.base.base.ui;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.jude.swipbackhelper.SwipeBackHelper;
import com.jude.swipbackhelper.SwipeBackPage;
import com.socks.library.KLog;

import java.lang.ref.WeakReference;
import java.util.List;

import cn.ecook.base.base.BasePresenter;
import cn.ecook.base.base.BaseViewModel;
import cn.ecook.base.listener.SingleClickListener;
import cn.ecook.base.manager.AppManager;
import cn.ecook.base.helper.BaseTitleBarHelper;
import cn.ecook.base.util.ToastUtil;
import cn.ecook.base.widget.TitleBar;

/**
 * Activity基类
 *
 * @author ciba
 * @date 2018/4/2
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements IBaseUi<T>, ITitleBarUi {
    private static final String TAG = "BaseActivity";
    private WeakReference<Activity> activityWeakReference;
    protected T basePresenter;
    private boolean fullScreen;
    private View contentView;
    private BaseTitleBarHelper titleBarHelper;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        KLog.e(TAG, "This activity is ... " + getClass().getSimpleName());
        // 软引用Activity上下文
        activityWeakReference = new WeakReference<Activity>(this);
        // 添加到App管理中
        AppManager.getAppManager().addActivity(activityWeakReference);

        // 设置是否全屏
        fullScreen();
        // 初始化布局
        contentView = LayoutInflater.from(this).inflate(contentView(), null);
        if (titleAndStatus()) {
            // 是否是多状态类型
            View view = initStatusView(contentView);
            // TitleBar帮助类
            titleBarHelper = new BaseTitleBarHelper(this, view);
        } else {
            setContentView(contentView);
            // TitleBar帮助类
            titleBarHelper = new BaseTitleBarHelper(this, contentView);
        }

        // 初始化View
        initView(savedInstanceState);
        // 初始化事件监听
        initListener();
        // 初始化数据?
        initData();
        // 初始化业务基类
        basePresenter = initBasePresenter();
        // 初始化多状态操作(在BaseStatusActivity中重写了)
        initIStatusUi();

        if (basePresenter != null) {
            if (basePresenter instanceof BaseViewModel) {
                // 如果是DataBinding类型
                ViewDataBinding binding = DataBindingUtil.bind(contentView);
                ((BaseViewModel) basePresenter).setBinding(binding);
            }
            // 设置TitleBar操作
            basePresenter.setITitleBarUi(this);
            // 业务初始化监听(EventBus之类的)
            basePresenter.initListener();
            // 业务初始化数据(与业务无关的数据)
            basePresenter.initData();
            // 业务初始化
            basePresenter.initBizData();
        }
        // 初始化手势返回
        initSwipeBack();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        SwipeBackHelper.onPostCreate(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (basePresenter != null) {
            basePresenter.onResume();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (basePresenter != null) {
            basePresenter.onStart();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (basePresenter != null) {
            basePresenter.onPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (basePresenter != null) {
            basePresenter.onStop();
        }
    }

    @Override
    public void finish() {
        if (fullScreen) {
            // 去除全屏状态
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        super.finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SwipeBackHelper.onDestroy(this);
        // 从App管理中移除
        AppManager.getAppManager().removeActivity(activityWeakReference);
        if (basePresenter != null) {
            basePresenter.onDestroy();
            basePresenter = null;
        }
        if (titleBarHelper != null){
            FrameLayout decorFrameLayout = titleBarHelper.getDecorFrameLayout();
            if (decorFrameLayout != null){
                decorFrameLayout.removeAllViews();
            }
            titleBarHelper = null;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        FragmentManager manager = getSupportFragmentManager();
        if (manager != null && manager.getFragments() != null) {
            List<Fragment> fragments = manager.getFragments();
            for (Fragment fragment : fragments) {
                fragment.onActivityResult(requestCode, resultCode, data);
            }
        }
        if (basePresenter != null) {
            basePresenter.onActivityResult(requestCode, resultCode, data);
        }
    }

    /**
     * 在这里初始化多状态的接口{@link BaseStatusActivity}
     */
    @Override
    public void initIStatusUi() {
    }

    /**
     * 重新加载数据(一般用于网络)
     */
    @Override
    public void reloadData() {
        if (basePresenter == null) {
            initData();
        } else {
            basePresenter.initBizData();
        }
    }

    @Override
    public void toast(@NonNull String toast) {
        ToastUtil.toast(this, toast);
    }

    @Override
    public View findViewById(int id) {
        return contentView == null ? null : contentView.findViewById(id);
    }

    @Override
    public void setBaseTitleVisible(boolean visible) {
        titleBarHelper.setTitleVisible(visible);
    }

    @Override
    public void setBaseTitle(String title) {
        titleBarHelper.setTitle(title);
    }

    @Override
    public void setLeftListener(SingleClickListener listener) {
        titleBarHelper.setLeftListener(listener);
    }

    @Override
    public void setLeftVisible(boolean visible) {
        titleBarHelper.setLeftVisible(visible);
    }

    @Override
    public void setLeftIcon(int icon) {
        titleBarHelper.setLeftIcon(icon);
    }

    @Override
    public void addRightActions(TitleBar.ActionList actionList) {
        titleBarHelper.addRightActions(actionList);
    }

    public boolean titleAndStatus() {
        return false;
    }

    protected View initStatusView(View contentView) {
        return null;
    }

    /**
     * @return ：获取当前Activity软引用
     */
    public WeakReference<Activity> getActivityWeakReference() {
        return activityWeakReference;
    }

    /**
     * @return ：获取业务基类
     */
    public BasePresenter getBasePresenter() {
        return basePresenter;
    }

    /**
     * 设置当前界面是否全屏
     */
    public boolean setFullScreen() {
        return false;
    }

    /**
     * 设置当前界面是否全屏
     */
    private void fullScreen() {
        this.fullScreen = setFullScreen();
        if (fullScreen) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }

    /**
     * 初始化右滑退出Activity
     */
    private void initSwipeBack() {
        // 右滑退出界面创建
        SwipeBackHelper.onCreate(this);
        SwipeBackPage page = SwipeBackHelper.getCurrentPage(this);
        // 设置是否支持手势退出Activity
        page.setSwipeBackEnable(canSwipeBack())
                // 设置滑动触发区域为屏幕的百分比
                .setSwipeEdgePercent(0.035f)
                // 设置触发滑动的灵敏度
                .setSwipeSensitivity(0.5f)
                // 设置滑动到某个百分比退出Activity
                .setClosePercent(0.55f)
                // 设置是否与上一个Activity联动
                .setSwipeRelateEnable(false);
    }

    /**
     * @return ：是否支持右滑退出,主界面（MainActivity）请重写并返回false
     */
    public boolean canSwipeBack() {
        return true;
    }

    /**
     * @return ：获取TitleBar 没有调用setTitle() titleBar为空
     */
    public TitleBar getBaseTitleBar() {
        return titleBarHelper.getTitleBar();
    }
}
