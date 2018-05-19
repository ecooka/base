package cn.ecook.basedemo.presenter;

import android.content.Context;
import android.support.annotation.NonNull;

import cn.ecook.base.base.BasePresenter;
import cn.ecook.base.base.IBaseView;
import cn.ecook.basedemo.entity.Football;
import cn.ecook.basedemo.view.MVPView;
import cn.ecook.http.HttpCallBack;
import cn.ecook.http.HttpUtil;

/**
 * @author ciba
 * @date 2018/4/3
 * @description MVP业务逻辑可在此实现类中进行，BasePresenter已经包含了Activity的一些主要的生命周期方法，需要的话重写即可
 *              可通过baseView来进行UI交互
 */

public class MVPStatusPresent extends BasePresenter {
    private MVPView mvpView;
    public MVPStatusPresent(@NonNull Context context, IBaseView baseView) {
        super(context, baseView);
    }

    @Override
    public void initListener() {
        // 初始化监听（EventBus等）
    }

    @Override
    public void initData() {
        // 初始化非业务数据
        mvpView = getBaseView();
    }

    @Override
    public void initBizData() {
        getIStatusUi().showLoading();
        // 初始化业务数据，诸如调用接口之类的
        // 泛型传入String直接返回原json数据
        HttpUtil.obGet("http://op.juhe.cn/onebox/football/league?key=bbdf40a269d0f08936ddb07b076be559&league=%E6%B3%95%E7%94%B2"
                , null, new HttpCallBack<Football>(context) {
                    @Override
                    public void onSuccess(Football football) {
                        getIStatusUi().dismissLoading();
                        mvpView.loadFinish(football.getReason());
                    }

                    @Override
                    public void onError(int code, String msg) {
                        getIStatusUi().dismissLoading(true, code);
                    }
                });
    }
}
