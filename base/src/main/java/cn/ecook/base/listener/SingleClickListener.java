package cn.ecook.base.listener;

import android.view.View;

/**
 * 禁止一秒内的连续点击
 *
 * @author 63062
 * @date 2018/3/1
 */

public abstract class SingleClickListener implements View.OnClickListener {

    private static final long DUR_TIME = 1000;
    private long preTime = 0;

    @Override
    public final void onClick(View view) {
        long millis = System.currentTimeMillis();
        if (millis - preTime > DUR_TIME) {
            preTime = millis;
            onSingleClick(view);
        }
    }

    /**
     * 单击事件
     * @param view ：监听的控件
     */
    public abstract void onSingleClick(View view);
}
