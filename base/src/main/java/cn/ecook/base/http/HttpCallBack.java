package cn.ecook.base.http;

import android.content.Context;

import io.reactivex.annotations.NonNull;

/**
 * 访问网络回调
 *
 * @author 63062
 * @date 2017/9/25
 */

public abstract class HttpCallBack<T> {
    private String hashTag = null;
    public Class cls = null;

    /**
     * 访问网络回调
     * @param context : 上下文(最后不要上传Application级别的上下文)，用于获取hashCode，addDisposable和clearDisposable使用
     * @param <T> ： 目标实例对象
     */
    public <T> HttpCallBack(Context context){
        if (context != null){
            hashTag = context.hashCode() + "";
        }
        try {
            this.cls = GenericsUtils.getSuperClassGenricType(getClass());
        }catch (Exception e){
            e.printStackTrace();
            this.cls = String.class;
        }
    }

    public String getHashTag() {
        return hashTag;
    }

    /**
     * 网络访问成功回调
     * @param t ：实体类对象
     */
    public abstract void onSuccess(@NonNull T t);

    /**
     * 网络访问失败
     * @param code ：失败错误码 {@link HttpCode}
     * @param msg : 错误信息
     */
    public abstract void onError(int code, @NonNull String msg);
}
