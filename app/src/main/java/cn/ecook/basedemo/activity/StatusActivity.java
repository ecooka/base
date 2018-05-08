package cn.ecook.basedemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import cn.ecook.base.base.BasePresenter;
import cn.ecook.base.base.IBaseView;
import cn.ecook.base.base.ui.BaseStatusActivity;
import cn.ecook.basedemo.R;
import cn.ecook.basedemo.presenter.MVPPresent;

/**
 * @author ciba
 * @date 2018/4/3
 * @description MVP模式下多状态Activity的使用，和BaseActivity基本一致
 */

public class StatusActivity extends BaseStatusActivity<BasePresenter> implements IBaseView {
    @Override
    public int contentView() {
        // 定制化不同状态展示的内容(loading，empty，noNetwork)
        initStatusDefaultLayoutRes(R.layout.status_default_loading, R.layout.status_default_empty, R.layout.status_default_no_network);
        return 0;
    }

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void initListener() {

    }

    @Override
    public BasePresenter initBasePresenter() {
        return new MVPPresent(this,this);
    }

    @Override
    public void initData() {

    }
}
