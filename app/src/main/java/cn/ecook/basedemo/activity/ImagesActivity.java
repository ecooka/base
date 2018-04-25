package cn.ecook.basedemo.activity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cn.ecook.base.base.BasePresenter;
import cn.ecook.base.base.ui.BaseStatusActivity;
import cn.ecook.basedemo.R;
import cn.ecook.basedemo.adapter.ImageAdapter;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 *
 * @author mcjs001
 * @date 2018/4/19
 */

public class ImagesActivity extends BaseStatusActivity {
    private RecyclerView recyclerView;

    public static void jumpHere(@NonNull Context context) {
        context.startActivity(new Intent(context, ImagesActivity.class));
    }
    @Override
    public int contentView() {
        return R.layout.activity_test;
    }

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }

    @Override
    public void initListener() {

    }

    @Override
    public BasePresenter initBasePresenter() {
        return null;
    }

    @Override
    public void initData() {
        setBaseTitle("IMAGES");
        getLocalImages();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void getLocalImages() {
        showLoading();
        Disposable subscribe = Observable.create(new ObservableOnSubscribe<List<String>>() {
            @Override
            public void subscribe(ObservableEmitter<List<String>> emitter) throws Exception {
                List<String> images = new ArrayList<>();
                Cursor cursor = getContentResolver().query(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
                while (cursor.moveToNext()) {
                    String data = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
                    images.add(data);
                }
                SystemClock.sleep(2000);
                emitter.onNext(images);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<String>>() {
                    @Override
                    public void accept(List<String> strings) throws Exception {
                        dismissLoading();
                        strings.add(0, "https://cdn2.jianshu.io/assets/web/web-note-ad-1-10f08e404d3887d2d45a4bc8f1831403.png");
                        strings.add(0, "https://upload-images.jianshu.io/upload_images/10794365-66db6c5ebacead39.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/700");
                        recyclerView.setLayoutManager(new GridLayoutManager(ImagesActivity.this, 2));
                        recyclerView.setAdapter(new ImageAdapter(strings, ImagesActivity.this));
                    }
                });
    }
}
