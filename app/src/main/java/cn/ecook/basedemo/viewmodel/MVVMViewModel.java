package cn.ecook.basedemo.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import cn.ecook.base.base.BaseViewModel;
import cn.ecook.basedemo.databinding.ActivityMvvmBinding;

/**
 * @author ciba
 * @date 2018/4/3
 * @description MVVM业务逻辑可在此实现类中进行，BaseViewModel继承BasePresenter已经包含了Activity的一些主要的生命周期方法，需要的话重写即可
 */

public class MVVMViewModel extends BaseViewModel {
    public final ObservableField<String> helloWorld = new ObservableField<>();
    private ActivityMvvmBinding binding;
    public MVVMViewModel(@NonNull Context context) {
        super(context);
    }

    @Override
    public void initListener() {
        // 初始化监听（EventBus等）
    }

    @Override
    public void initData() {
        // 初始化非业务数据
        binding = getBinding();
        binding.setMvvm(this);
    }

    @Override
    public void initBizData() {
        // 初始化业务数据，诸如调用接口之类的
        helloWorld.set("HELLO WORLD!!!");
    }
}
