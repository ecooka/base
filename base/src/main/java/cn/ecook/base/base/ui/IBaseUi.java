package cn.ecook.base.base.ui;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import cn.ecook.base.base.BasePresenter;

/**
 *
 * @author ciba
 * @date 2017/12/1
 */

public interface IBaseUi<T extends BasePresenter> {

    /**
     * 设置内容布局
     * @return ：layoutId
     */
    @LayoutRes
    int contentView();

    /**
     * 初始化控件
     * @param savedInstanceState ：保存数据
     */
    void initView(@Nullable Bundle savedInstanceState);

    /**
     * 初始化事件监听
     */
    void initListener();

    /**
     * MVP，MVVM 设计模式初始化P层和VM层
     * MVC 可以直接返回null
     * @return ：业务层
     */
    T initBasePresenter();

    /**
     * 初始化多状态接口
     */
    void initIStatusUi();

    /**
     * MVP，MVVM初始化非业务数据
     * MVC可在此初始化所有数据
     */
    void initData();

    /**
     * 重新加载数据
     */
    void reloadData();

    /**
     * toast
     * @param toast ：toast 内容
     */
    void toast(String toast);
}
