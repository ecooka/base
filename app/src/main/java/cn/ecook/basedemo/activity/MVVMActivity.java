package cn.ecook.basedemo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import cn.ecook.base.base.BaseViewModel;
import cn.ecook.base.base.ui.BaseActivity;
import cn.ecook.basedemo.R;
import cn.ecook.basedemo.viewmodel.MVVMViewModel;

/**
 * @author ciba
 * @date 2018/4/3
 * @description 使用和MV基本一致，指定泛型为BaseViewModel
 */

public class MVVMActivity extends BaseActivity<BaseViewModel> {
    public static void jumpHere(Context context) {
        context.startActivity(new Intent(context, MVVMActivity.class));
    }

    @Override
    public int contentView() {
        return R.layout.activity_mvvm;
    }

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void initListener() {

    }

    @Override
    public BaseViewModel initBasePresenter() {
        // MVVM返回BaseViewModel的实现类
        // 在BaseViewModel的实现类中进行业务操作
        return new MVVMViewModel(this);
    }

    @Override
    public void initData() {

    }
}
