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

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import cn.ecook.base.base.BasePresenter;
import cn.ecook.base.base.ui.BaseActivity;
import cn.ecook.basedemo.R;
import cn.ecook.basedemo.adapter.ImageAdapter;
import cn.ecook.base.widget.MySmartRefreshLayout;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author mcjs001
 * @date 2018/4/19
 */

public class ImagesActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private MySmartRefreshLayout refreshLayout;
    private Disposable subscribe;
    private ImageAdapter imageAdapter;

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
        refreshLayout = (MySmartRefreshLayout) findViewById(R.id.refreshLayout);
    }

    @Override
    public void initListener() {
        refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                getLocalImages(MySmartRefreshLayout.TYPE_LOAD_MORE);
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                getLocalImages(MySmartRefreshLayout.TYPE_FRESH);
            }
        });
    }

    @Override
    public BasePresenter initBasePresenter() {
        return null;
    }

    @Override
    public void initData() {
        setBaseTitle("IMAGES");

        recyclerView.setLayoutManager(new GridLayoutManager(ImagesActivity.this, 2));
        imageAdapter = new ImageAdapter(ImagesActivity.this);
        recyclerView.setAdapter(imageAdapter);

        refreshLayout.autoRefresh();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (subscribe != null) {
            subscribe.dispose();
            subscribe = null;
        }
    }

    private void getLocalImages(final int type) {
        subscribe = Observable.create(new ObservableOnSubscribe<List<String>>() {
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
                        refreshLayout.finish(type, true, true);
                        imageAdapter.addData(strings);
                    }
                });
    }
}
