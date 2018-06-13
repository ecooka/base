package cn.ecook.base.util;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;

import java.io.File;
import java.util.List;
import java.util.UUID;

import cn.ecook.base.base.BaseConfig;
import cn.ecook.base.manager.AppManager;
import cn.ecook.base.permissions.PermissionUtil;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author ciba
 * @date 2018/4/3
 * @description 照相机和相册工具类
 */
public class CameraPhotoUtil {
    public static final int REQUEST_CAMERA = 10001;
    public static final int REQUEST_GALLERY = 10002;
    private static final int VERSION24 = 24;
    private static String takePhotoPath;

    /**
     * 打开系统相机拍照
     * @param activity
     */
    public static void openCamera(final Activity activity) {

        if (AppManager.getAppManager().activityIsFinish(activity)) {
            // 如果Activity为空或者Activity已经销毁
            return;
        }
        // 申请所需的权限
        PermissionUtil.requestPermissions(activity, new PermissionUtil.PermissionsListener() {
            @Override
            public void finish(List<String> refusePermissions, List<String> refuseNoAskingPermissions) {
                if (!refusePermissions.isEmpty() || !refuseNoAskingPermissions.isEmpty()){
                    // 如果有权限没有申请成功则给予提示
                    String permission = null;
                    if (!refuseNoAskingPermissions.isEmpty()){
                        permission = refuseNoAskingPermissions.get(0);
                    } else if (!refusePermissions.isEmpty()){
                        permission = refusePermissions.get(0);
                    }
                    PermissionUtil.showSettingDialog(activity, permission);
                    return;
                }
                File takePhotoFile = new File(FileUtil.getSDRoot(), UUID.randomUUID() + ".jpg");
                takePhotoPath = takePhotoFile.getAbsolutePath();
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                Uri uri;
                if (Build.VERSION.SDK_INT >= VERSION24) {
                    uri = FileProvider.getUriForFile(activity, BaseConfig.FILE_PROVIDER, takePhotoFile);
                } else {
                    uri = Uri.fromFile(takePhotoFile);
                }
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                activity.startActivityForResult(intent, REQUEST_CAMERA);
            }
        }, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA});
    }

    /**
     * @return ：获取拍照的图片文件
     */
    public static File getCameraImage() {
        return new File(takePhotoPath);
    }

    /**
     * 打开系统相册选取图片
     * @param activity
     */
    public static void openGallery(Activity activity) {
        if (AppManager.getAppManager().activityIsFinish(activity)) {
            return;
        }
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        activity.startActivityForResult(intent, REQUEST_GALLERY);
    }

    /**
     * 获取相册中选取的图片地址
     * @param context
     * @param uri
     * @param callBack
     */
    public static void getGalleryImage(final Context context, final Uri uri, final GalleryImageCallBack callBack) {
        if (context == null || uri == null || callBack == null){
            return;
        }
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                Cursor cursor = context.getContentResolver().query(uri, filePathColumn, null, null, null);
                cursor.moveToFirst();
                String picturePath = cursor.getString(cursor.getColumnIndex(filePathColumn[0]));
                cursor.close();
                emitter.onNext(picturePath == null ? "" : picturePath);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String picturePath) throws Exception {
                        if (callBack != null){
                            callBack.getPhotoPath(picturePath);
                        }
                    }
                });
    }

    public interface GalleryImageCallBack {
        /**
         * 通过Uri从本地查询到的图片地址
         * @param path
         */
        void getPhotoPath(String path);
    }
}
