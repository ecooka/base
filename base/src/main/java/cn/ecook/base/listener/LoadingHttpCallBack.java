package cn.ecook.base.listener;

import android.app.Activity;
import java.lang.ref.WeakReference;

import cn.ecook.base.widget.dialog.EcookLoadingDialog;
import cn.ecook.http.HttpCallBack;

/**
 * 无需关心网络访问UI变化的回调（自带loading状态）
 * on 2018/4/18.
 * @author ciba
 */

public abstract class LoadingHttpCallBack<T> extends HttpCallBack<T> {
    private final boolean cancelable;
    private WeakReference<Activity> activityWeakReference;
    private final int loadingLayoutRes;
    private EcookLoadingDialog loadingDialog;

    /**
     * 访问网络回调
     *
     * @param context : 上下文(最后不要上传Application级别的上下文)，用于获取hashCode，addDisposable和clearDisposable使用
     */

    public LoadingHttpCallBack(Activity context) {
        this(context, 0,false);
    }

    public LoadingHttpCallBack(Activity context, int loadingLayoutRes, boolean cancelable) {
        super(context);
        this.loadingLayoutRes = loadingLayoutRes;
        this.cancelable = cancelable;
        if (context != null) {
            activityWeakReference = new WeakReference<>(context);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        showLoading(cancelable);
    }

    @Override
    public void onSuccess(T t) {
        dismissLoading();
        success(t);
    }

    @Override
    public void onError(int code, String msg) {
        dismissLoading();
        error(code, msg);
    }

    /**
     * 展示loading
     * @param cancelable
     */
    private void showLoading(boolean cancelable) {
        if (activityWeakReference == null || activityWeakReference.get() == null) {
            return;
        }
        dismissLoading();
        loadingDialog = new EcookLoadingDialog(activityWeakReference.get(), loadingLayoutRes);
        loadingDialog.setCancelable(cancelable);
        loadingDialog.show();
    }

    /**
     * 隐藏loading
     */
    private void dismissLoading() {
        if (loadingDialog != null) {
            loadingDialog.dismiss();
            loadingDialog = null;
            return;
        }
    }

    /**
     * 网络访问成功
     *
     * @param t
     */
    public abstract void success(T t);

    /**
     * 网络访问失败
     *
     * @param code
     * @param msg
     */
    public abstract void error(int code, String msg);

}
