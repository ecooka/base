package cn.ecook.basedemo.presenter;

import android.content.Context;
import android.support.annotation.NonNull;

import cn.ecook.base.base.BasePresenter;
import cn.ecook.base.base.IBaseView;

/**
 * @author ciba
 * @date 2018/4/3
 * @description MVP业务逻辑可在此实现类中进行，BasePresenter已经包含了Activity的一些主要的生命周期方法，需要的话重写即可
 *              可通过baseView来进行UI交互
 */

public class MVPPresent extends BasePresenter {
    public MVPPresent(@NonNull Context context, IBaseView baseView) {
        super(context, baseView);
    }

    @Override
    public void initListener() {
        // 初始化监听（EventBus等）
    }

    @Override
    public void initData() {
        // 初始化非业务数据
    }

    @Override
    public void initBizData() {
        // 初始化业务数据，诸如调用接口之类的
    }
}
