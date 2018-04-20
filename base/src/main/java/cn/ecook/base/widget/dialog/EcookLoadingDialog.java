package cn.ecook.base.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import cn.ecook.base.R;

/**
 * 网上厨房loading弹框
 *
 * @author ciba
 * @date 2017/12/4
 */

public class EcookLoadingDialog extends Dialog {

    public EcookLoadingDialog(@NonNull Context context) {
        this(context, 0);
    }

    public EcookLoadingDialog(@NonNull Context context, int layoutRes) {
        super(context, R.style.common_dialog);
        View view = View.inflate(context, layoutRes == 0 ? R.layout.status_default_loading : layoutRes, null);
        setContentView(view);
        setDialog();
    }

    private void setDialog() {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);
        Window w = getWindow();
        w.setDimAmount(0);
        w.setGravity(Gravity.CENTER);
        ViewGroup.LayoutParams lay = getWindow().getAttributes();
        lay.width = dm.widthPixels;
        lay.height = dm.heightPixels;
    }
}
