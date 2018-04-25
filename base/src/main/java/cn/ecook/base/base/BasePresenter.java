package cn.ecook.base.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import java.lang.ref.WeakReference;

import cn.ecook.base.base.ui.BaseActivity;
import cn.ecook.base.base.ui.IStatusUi;
import cn.ecook.base.base.ui.ITitleBarUi;
import cn.ecook.base.http.HttpUtil;
import cn.ecook.base.util.ToastUtil;

/**
 * 业务基类
 *
 * @author ciba
 * @date 2018/4/2
 */

public abstract class BasePresenter {
    private final IBaseView baseView;
    protected final Context context;
    protected ITitleBarUi iTitleBar;
    protected IStatusUi iStatus;

    public BasePresenter(@NonNull Context context, IBaseView baseView) {
        this.context = context;
        this.baseView = baseView;
    }

    public <T extends Context> T getContext() {
        return (T) context;
    }

    /**
     * 可以转换成具体实现IBaseView的子类
     * @param <T>
     * @return
     */
    public <T extends IBaseView> T getBaseView() {
        return baseView == null ? null : (T) baseView;
    }

    /**
     * 设置titleBar 和 状态布局
     * @param iTitleBar
     * @param iStatus
     */
    public void setTitleAndStatusInt(ITitleBarUi iTitleBar, IStatusUi iStatus) {
        this.iTitleBar = iTitleBar;
        this.iStatus = iStatus;
    }

    public void onResume() { }

    public void onStart() { }

    public void onPause() { }

    public void onStop() { }

    public void onActivityResult(int requestCode, int resultCode, Intent data) { }

    public void onDestroy() {
        HttpUtil.clearDisposable(context);
    }

    /**
     * 获取当前对应的Activity的弱引用
     *
     * @return
     */
    public WeakReference<Activity> getActivityWeakReference() {
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getActivityWeakReference();
        }
        return null;
    }

    public void toast(String msg){
        ToastUtil.toast(context, msg);
    }

    /**
     * 初始化事件
     */
    public abstract void initListener();

    /**
     * 初始化数据
     */
    public abstract void initData();


    /**
     * 初始化业务数据
     */
    public abstract void initBizData();

}
