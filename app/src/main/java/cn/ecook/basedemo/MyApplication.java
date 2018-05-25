package cn.ecook.basedemo;

import com.socks.library.KLog;

import cn.ecook.base.base.BaseApplication;
import cn.ecook.base.base.BaseConfig;

/**
 * @author ciba
 * @date 2018/4/3
 * @description
 */

public class MyApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        KLog.e("TAG", "MyApplication");
        // 设置debug状态
        BaseConfig.init(true);
        // 设置全局的多状态样式，不设置使用默认样式
        BaseConfig.initStatusRes(R.layout.status_default_loading, R.layout.status_default_empty, R.layout.status_default_no_network);
        // 设置全局默认返回按钮icon
        BaseConfig.initGoBackDrawable(R.drawable.titlebar_return_icon_black);
    }
}
