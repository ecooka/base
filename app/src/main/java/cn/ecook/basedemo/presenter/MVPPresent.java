package cn.ecook.basedemo.presenter;

import android.content.Context;
import android.support.annotation.NonNull;

import cn.ecook.base.base.BasePresenter;
import cn.ecook.base.base.IBaseView;

/**
 * @author ciba
 * @date 2018/4/3
 * @description
 */

public class MVPPresent extends BasePresenter {
    public MVPPresent(@NonNull Context context, IBaseView baseView) {
        super(context, baseView);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initBizData() {

    }
}
