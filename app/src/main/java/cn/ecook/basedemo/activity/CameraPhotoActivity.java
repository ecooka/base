package cn.ecook.basedemo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

import cn.ecook.base.base.BasePresenter;
import cn.ecook.base.base.ui.BaseStatusActivity;
import cn.ecook.base.listener.SingleClickListener;
import cn.ecook.base.util.CameraPhotoUtil;
import cn.ecook.base.util.GlideUtil;
import cn.ecook.base.widget.dialog.CameraPhotoDialog;
import cn.ecook.basedemo.R;

/**
 * @author ciba
 * @date 2018/4/3
 * @description
 */

public class CameraPhotoActivity extends BaseStatusActivity {
    /**
     * 需替换成自己应用的fileprovider
     */
    private ImageView ivImage;
    private SingleClickListener clickListener = new SingleClickListener() {
        @Override
        public void onSingleClick(View view) {
            switch (view.getId()) {
                case R.id.btnCameraPhoto:
                    showCameraPhotoDialog();
                    break;
                case R.id.btnCamera:
                    openCamera();
                    break;
                case R.id.btnPhoto:
                    openGallery();
                    break;
                default:
                    break;
            }
        }
    };

    public static void jumpHere(@NonNull Context context) {
        context.startActivity(new Intent(context, CameraPhotoActivity.class));
    }

    @Override
    public int contentView() {
        return R.layout.activity_camera_photo;
    }

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        ivImage = (ImageView) findViewById(R.id.ivImage);
    }

    @Override
    public void initListener() {
        findViewById(R.id.btnCameraPhoto).setOnClickListener(clickListener);
        findViewById(R.id.btnCamera).setOnClickListener(clickListener);
        findViewById(R.id.btnPhoto).setOnClickListener(clickListener);
    }

    @Override
    public BasePresenter initBasePresenter() {
        return null;
    }

    @Override
    public void initData() {
        setBaseTitle("CameraPhoto");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (CameraPhotoUtil.REQUEST_CAMERA == requestCode) {
            // 获取拍照地址
            File image = CameraPhotoUtil.getCameraImage();
            if (image.exists()){
                GlideUtil.display(this, image.getAbsolutePath(), ivImage);
            }
        } else if (CameraPhotoUtil.REQUEST_GALLERY == requestCode && data != null){
            // 获取图库选择地址
            CameraPhotoUtil.getGalleryImage(this, data.getData(), new CameraPhotoUtil.GalleryImageCallBack() {
                @Override
                public void getPhotoPath(String path) {
                    GlideUtil.display(CameraPhotoActivity.this, path, ivImage);
                }
            });
        }
    }

    private void showCameraPhotoDialog() {
        new CameraPhotoDialog(this).show();
    }

    private void openCamera() {
        CameraPhotoUtil.openCamera(this);
    }

    private void openGallery() {
        CameraPhotoUtil.openGallery(this);
    }
}
