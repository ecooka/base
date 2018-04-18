package cn.ecook.basedemo;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.ecook.base.base.BasePresenter;
import cn.ecook.base.base.ui.BaseStatusActivity;
import cn.ecook.base.http.HttpUtil;
import cn.ecook.base.http.LoadingHttpCallBack;

public class MainActivity extends BaseStatusActivity {

    @Override
    public int contentView() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void initListener() {

    }

    @Override
    public BasePresenter initBasePresenter() {
        return null;
    }

    @Override
    public void initData() {
//        showLoading();
        HttpUtil.obGet("http://op.juhe.cn/onebox/football/league?key=bbdf40a269d0f08936ddb07b076be559&league=%E6%B3%95%E7%94%B2" , null, new LoadingHttpCallBack<String>(this) {
            @Override
            public void success(String s) {

            }

            @Override
            public void error(int code, String msg) {

            }
        });
    }
}
