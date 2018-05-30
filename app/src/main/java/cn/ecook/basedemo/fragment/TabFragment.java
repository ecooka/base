package cn.ecook.basedemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cn.ecook.base.base.BasePresenter;
import cn.ecook.base.base.ui.BaseFragment;
import cn.ecook.basedemo.R;
import cn.ecook.basedemo.adapter.TabAdapter;

/**
 * @author : ciba
 * @date : 2018/5/28
 * @description : replace your description
 */

public class TabFragment extends BaseFragment {
    private RecyclerView recyclerView;

    @Override
    public int contentView() {
        return R.layout.fragment_tab;
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
        List<String> stringList = new ArrayList<>();
        for (int i = 0 ; i < 100; i++){
            stringList.add("position : " + i);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setAdapter(new TabAdapter(stringList));
    }
}
