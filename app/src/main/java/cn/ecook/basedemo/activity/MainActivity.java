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
 * @description MainActivity是MVC
 */
public class MainActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {
    private static final String[] ITEMS = {"TabViewPager", "Permission", "CameraPhoto", "IMAGES", "MVP", "MVVM", "STATUS", "AppBarLayout"};
    private RecyclerView recyclerView;

    @Override
    public int contentView() {
        // 布局
        return R.layout.activity_main;
    }

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        // 初始化控件
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }

    @Override
    public void initListener() {
        // 初始化事件监听
    }

    @Override
    public BasePresenter initBasePresenter() {
        // MVC无需关心此返回值，只要返回null即可
        return null;
    }

    @Override
    public void initData() {
        // 初始化数据
        MainAdapter mainAdapter = new MainAdapter(Arrays.asList(ITEMS));
        mainAdapter.setOnItemClickListener(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mainAdapter);
    }

    @Override
    public boolean canSwipeBack() {
        // 返回是否可以右滑退出Activity
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
            case 4:
                MVPActivity.jumpHere(this);
                break;
            case 5:
                MVVMActivity.jumpHere(this);
                break;
            case 6:
                StatusActivity.jumpHere(this);
                break;
            case 7:
                AppBarLayoutActivity.jumpHere(this);
                break;
            default:
                break;
        }
    }
}
