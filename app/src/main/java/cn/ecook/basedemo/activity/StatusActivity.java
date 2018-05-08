package cn.ecook.basedemo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import cn.ecook.base.base.BasePresenter;
import cn.ecook.base.base.IBaseView;
import cn.ecook.base.base.ui.BaseStatusActivity;
import cn.ecook.basedemo.R;
import cn.ecook.basedemo.presenter.MVPPresent;
import cn.ecook.basedemo.presenter.MVPStatusPresent;
import cn.ecook.basedemo.view.MVPView;

/**
 * @author ciba
 * @date 2018/4/3
 * @description MVP模式下多状态Activity的使用，和BaseActivity基本一致
 */

public class StatusActivity extends BaseStatusActivity<BasePresenter> implements MVPView {
    private TextView tvContent;

    public static void jumpHere(Context context) {
        context.startActivity(new Intent(context, StatusActivity.class));
    }

    @Override
    public int contentView() {
        // 定制化不同状态展示的内容(loading，empty，noNetwork)
        initStatusDefaultLayoutRes(R.layout.status_default_loading, R.layout.status_default_empty, R.layout.status_default_no_network);
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
        return new MVPStatusPresent(this,this);
    }

    @Override
    public void initData() {
        setBaseTitle("多状态Activity");
    }

    @Override
    public void loadFinish(String result) {
        tvContent.setText(result);
    }
}
