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
 * 权限申请失败弹框
 *
 * @author ciba
 * @date 2017/12/4
 */

public class PermissionDialog extends Dialog {
    private final TextView tvTitle;
    private final TextView tvContent;
    private final TextView tvCancel;
    private final TextView tvDefinite;

    public PermissionDialog(@NonNull Context context) {
        super(context, R.style.common_dialog);
        View view = View.inflate(context, R.layout.dialog_default_permission, null);
        tvTitle = view.findViewById(R.id.tvTitle);
        tvContent = view.findViewById(R.id.tvContent);
        tvCancel = view.findViewById(R.id.tvCancel);
        tvDefinite = view.findViewById(R.id.tvDefinite);
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        setContentView(view);
        setDialog();
    }

    public void setTitle(String title) {
        tvTitle.setText(title);
    }

    public void setTitleSize(float size) {
        tvTitle.setTextSize(size);
    }

    public void setTitleColor(@ColorInt int color) {
        tvTitle.setTextColor(color);
    }

    public void setDefinite(String Definite) {
        tvDefinite.setText(Definite);
    }

    public void setDefiniteSize(float size) {
        tvDefinite.setTextSize(size);
    }

    public void setDefiniteColor(@ColorInt int color) {
        tvDefinite.setTextColor(color);
    }

    public void setDefiniteClick(View.OnClickListener listener) {
        tvDefinite.setOnClickListener(listener);
    }

    public void setContent(String content) {
        tvContent.setText(content);
    }

    public void setContentSize(float size) {
        tvContent.setTextSize(size);
    }

    public void setContentColor(@ColorInt int color) {
        tvContent.setTextColor(color);
    }

    public void setCancel(String cancel) {
        tvCancel.setText(cancel);
    }

    public void setCancelSize(float size) {
        tvCancel.setTextSize(size);
    }

    public void setCancelColor(@ColorInt int color) {
        tvCancel.setTextColor(color);
    }

    public void setCancelClick(View.OnClickListener listener) {
        tvCancel.setOnClickListener(listener);
    }

    private void setDialog() {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);
        Window w = getWindow();
        w.setGravity(Gravity.CENTER);
        ViewGroup.LayoutParams lay = getWindow().getAttributes();
        lay.width = dm.widthPixels * 4 / 5;
    }
}
