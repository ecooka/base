package cn.ecook.basedemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import cn.ecook.base.base.BasePresenter;
import cn.ecook.base.base.IBaseView;
import cn.ecook.base.base.ui.BaseActivity;
import cn.ecook.basedemo.presenter.MVPPresent;

/**
 * @author ciba
 * @date 2018/4/3
 * @description 和MVC用法基本类似，指定BasePresenter
 */

public class MVPActivity extends BaseActivity<BasePresenter> implements IBaseView {
    @Override
    public int contentView() {
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
        // MVP返回BasePresenter的实现类并指定View层接口(第二个参数，IBaseView的实现类)
        // 在BasePresenter的实现类中进行业务操作
        return new MVPPresent(this, this);
    }

    @Override
    public void initData() {

    }
}
