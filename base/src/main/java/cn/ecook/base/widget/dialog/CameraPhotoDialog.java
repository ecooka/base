package cn.ecook.base.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import cn.ecook.base.R;
import cn.ecook.base.listener.SingleClickListener;
import cn.ecook.base.util.CameraPhotoUtil;

/**
 * @author ciba
 * @date 2018/4/3
 * @description 通用的相册选择和打开本地照相机弹框，无需申请权限
 */

public class CameraPhotoDialog extends Dialog {
    private final Activity activity;
    private final String authority;
    private TextView tvGallery;
    private TextView tvCamera;
    private TextView tvCancel;
    private SingleClickListener clickListener = new SingleClickListener() {
        @Override
        public void onSingleClick(View view) {
            dismiss();

            int id = view.getId();
            if (R.id.tvGallery == id) {
                choosePhoto();
            } else if (R.id.tvCamera == id) {
                camera();
            }
        }
    };

    /**
     * @param context
     * @param authority ：
     */
    public CameraPhotoDialog(@NonNull Activity context, String authority) {
        super(context, R.style.common_dialog);
        this.activity = context;
        this.authority = authority;
        setContentView(R.layout.dialog_default_photo_camera);
        tvGallery = findViewById(R.id.tvGallery);
        tvCamera = findViewById(R.id.tvCamera);
        tvCancel = findViewById(R.id.tvCancel);

        tvGallery.setOnClickListener(clickListener);
        tvCamera.setOnClickListener(clickListener);
        tvCancel.setOnClickListener(clickListener);

        setDialog();
    }

    public void setCameraClick(SingleClickListener clickListener) {
        tvCamera.setOnClickListener(clickListener);
    }

    public void setGalleryClick(SingleClickListener clickListener) {
        tvGallery.setOnClickListener(clickListener);
    }

    private void camera() {
        CameraPhotoUtil.openCamera(activity, authority);
    }

    private void choosePhoto() {
        CameraPhotoUtil.openGallery(activity);
    }

    private void setDialog() {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);
        Window w = getWindow();
        w.setDimAmount(0);
        w.setWindowAnimations(R.style.fromBottomToTopAnimStyle);
        w.setGravity(Gravity.BOTTOM);
        ViewGroup.LayoutParams lay = getWindow().getAttributes();
        lay.width = dm.widthPixels;
    }
}
