package cn.ecook.basedemo;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import cn.ecook.base.base.BasePresenter;
import cn.ecook.base.base.ui.BaseStatusActivity;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by mcjs001 on 2018/4/19.
 */

public class TestActivity extends BaseStatusActivity {
    @Override
    public int contentView() {
        return R.layout.activity_test;
    }

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {

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
        showLoading();
        getLocalImages();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void getLocalImages() {
        Observable.create(new ObservableOnSubscribe<List<String>>() {
            @Override
            public void subscribe(ObservableEmitter<List<String>> emitter) throws Exception {
                List<String> images = new ArrayList<>();
                Cursor cursor = getContentResolver().query(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
                while (cursor.moveToNext()){
                    String data = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
                    images.add(data);
                }
                emitter.onNext(images);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<String>>() {
                    @Override
                    public void accept(List<String> strings) throws Exception {
                        dismissLoading();
                        RecyclerView recyclerView = findViewById(R.id.recyclerView);
                        recyclerView.setLayoutManager(new LinearLayoutManager(TestActivity.this));
                        recyclerView.setAdapter(new ImageAdapter(strings, TestActivity.this));
                    }
                });
    }
}
