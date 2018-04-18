package cn.ecook.base.base;

import android.app.Application;

import com.socks.library.KLog;

/**
 *
 * @author 63062
 * @date 2018/4/3
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        initKLog();
    }

    private void initKLog() {
        KLog.init(BaseConfig.DEBUG);
    }

}
