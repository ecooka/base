package cn.ecook.basedemo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import cn.ecook.base.base.BasePresenter;
import cn.ecook.base.base.IBaseView;
import cn.ecook.base.base.ui.BaseActivity;
import cn.ecook.basedemo.R;
import cn.ecook.basedemo.presenter.MVPPresent;
import cn.ecook.basedemo.view.MVPView;

/**
 * @author ciba
 * @date 2018/4/3
 * @description 和MVC用法基本类似，指定BasePresenter
 */

public class MVPActivity extends BaseActivity<BasePresenter> implements MVPView {
    private TextView tvContent;

    public static void jumpHere(Context context) {
        context.startActivity(new Intent(context, MVPActivity.class));
    }

    @Override
    public int contentView() {
        return R.layout.activity_mvp;
    }

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        tvContent = (TextView) findViewById(R.id.tvContent);
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
        setBaseTitle("MVP模式使用");
    }

    @Override
    public void loadFinish(String result) {
        tvContent.setText(result);
    }
}
