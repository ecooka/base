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
import android.text.TextUtils;

import java.io.File;
import java.util.List;
import java.util.UUID;

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
 * @description
 */
public class CameraPhotoUtil {
    public static final int REQUEST_TAKE_PHOTO = 10001;
    public static final int REQUEST_CHOOSE_PHOTO = 10002;
    private static final int VERSION24 = 24;
    private static String takePhotoPath;

    public static void takePhoto(final Activity activity, final String authority) {
        if (activity == null || activity.isDestroyed()) {
            return;
        }
        PermissionUtil.requestPermissions(activity, new PermissionUtil.PermissionsListener() {
            @Override
            public void finish(List<String> refusePermissions, List<String> refuseNoAskingPermissions) {
                File takePhotoFile = new File(FileUtil.getSDRoot(), UUID.randomUUID() + ".jpg");
                takePhotoPath = takePhotoFile.getAbsolutePath();
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                Uri uri;
                if (Build.VERSION.SDK_INT >= VERSION24) {
                    uri = FileProvider.getUriForFile(activity, authority, takePhotoFile);
                } else {
                    uri = Uri.fromFile(takePhotoFile);
                }
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                activity.startActivityForResult(intent, REQUEST_TAKE_PHOTO);
            }
        }, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA});
    }

    public static void openGallery(Activity activity) {
        if (activity == null || activity.isDestroyed()) {
            return;
        }
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        activity.startActivityForResult(intent, REQUEST_CHOOSE_PHOTO);
    }

    public static File getTakePhotoFile() {
        if (TextUtils.isEmpty(takePhotoPath)) {
            return null;
        }
        return new File(takePhotoPath);
    }

    public static void getPhotoFile(final Context context, final Uri uri, final PhotoFileCallBack callBack) {
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

    public interface PhotoFileCallBack{
        /**
         * 通过Uri从本地查询到的图片地址
         * @param path
         */
        void getPhotoPath(String path);
    }
}
