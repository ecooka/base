package cn.ecook.base.util;


import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/**
 *
 * @author 63062
 * @date 2017/12/18
 */

public class ToastUtil {
    private static final long DUR_TIME = 2000;
    private static long preTime;

    private ToastUtil() {
    }

    public static void toast(Context context, String msg) {
        if (TextUtils.isEmpty(msg)) {
            return;
        }
        long millis = System.currentTimeMillis();
        if (millis - preTime >= DUR_TIME) {
            preTime = millis;
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        }
    }
}
