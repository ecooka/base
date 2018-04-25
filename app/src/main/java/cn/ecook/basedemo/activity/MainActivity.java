package cn.ecook.basedemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.Arrays;

import cn.ecook.base.base.BasePresenter;
import cn.ecook.base.base.ui.BaseActivity;
import cn.ecook.basedemo.R;
import cn.ecook.basedemo.adapter.MainAdapter;

/**
 * @author ciba
 * @date 2018/4/3
 * @description
 */

public class MainActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {
    private static final String[] ITEMS = {"TabViewPager", "Permission", "CameraPhoto", "IMAGES"};
    private RecyclerView recyclerView;

    @Override
    public int contentView() {
        return R.layout.activity_main;
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
        MainAdapter mainAdapter = new MainAdapter(Arrays.asList(ITEMS));
        mainAdapter.setOnItemClickListener(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mainAdapter);
    }

    @Override
    public boolean canSwipeBack() {
        return false;
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        switch (position) {
            case 0:
                TabViewPagerActivity.jumpHere(this);
                break;
            case 1:
                PermissionActivity.jumpHere(this);
                break;
            case 2:
                CameraPhotoActivity.jumpHere(this);
                break;
            case 3:
                ImagesActivity.jumpHere(this);
                break;
            default:
                break;
        }
    }
}
