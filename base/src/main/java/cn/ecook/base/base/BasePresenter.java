package cn.ecook.base.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import java.lang.ref.WeakReference;

import cn.ecook.base.base.ui.BaseActivity;
import cn.ecook.base.base.ui.IStatusUi;
import cn.ecook.base.base.ui.ITitleBarUi;
import cn.ecook.base.util.ToastUtil;
import cn.ecook.http.HttpUtil;

/**
 * 业务基类
 *
 * @author ciba
 * @date 2018/4/2
 */

public abstract class BasePresenter {
    private final IBaseView baseView;
    private ITitleBarUi iTitleBarUi;
    private IStatusUi iStatusUi;
    protected final Context context;

    public BasePresenter(@NonNull Context context, IBaseView baseView) {
        this.context = context;
        this.baseView = baseView;
    }

    public void toast(String msg){
        ToastUtil.toast(context, msg);
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
     * 设置状态布局操作接口
     * @param iStatusUi
     */
    public void setIStatusUi(IStatusUi iStatusUi) {
        this.iStatusUi = iStatusUi;
    }

    /**
     * 设置TitleBar操作接口
     * @param iTitleBarUi
     */
    public void setITitleBarUi(ITitleBarUi iTitleBarUi){
        this.iTitleBarUi = this.iTitleBarUi;
    }

    /**
     * 获取TitleBar操作接口，BaseActivity的子类均不为空
     * @return
     */
    public ITitleBarUi getITitleBarUi() {
        return iTitleBarUi;
    }

    /**
     * 获取多状态操作接口，BaseStatusActivity的子类或BaseStatusFragment的子类不为空
     * @return
     */
    public IStatusUi getIStatusUi() {
        return iStatusUi;
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

    public void onResume() { }

    public void onStart() { }

    public void onPause() { }

    public void onStop() { }

    public void onActivityResult(int requestCode, int resultCode, Intent data) { }

    public void onDestroy() {
        HttpUtil.clearDisposable(context);
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
