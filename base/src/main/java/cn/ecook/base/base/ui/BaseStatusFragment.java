package cn.ecook.base.base.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.classic.common.MultipleStatusView;

import cn.ecook.base.R;
import cn.ecook.base.base.BasePresenter;
import cn.ecook.base.listener.SingleClickListener;
import cn.ecook.base.widget.TitleBar;
import cn.ecook.base.util.StatusUtil;
import cn.ecook.base.util.TitleBarUtil;

/**
 * @author 63062
 * @date 2018/4/4
 */

public abstract class BaseStatusFragment<T extends BasePresenter> extends BaseFragment<T> implements ITitleBarUi, IStatusUi {
    protected TitleBar tbBaseTitle;
    protected MultipleStatusView msvBaseStatusView;
    private int loadingLayoutRes = 0;
    private int emptyLayoutRes = 0;
    private int networkErrorLayoutRes = 0;

    @Override
    public final boolean titleAndStatus() {
        return true;
    }

    @Override
    public View initStatusView(View contentView) {
        View statusView = LayoutInflater.from(activity).inflate(R.layout.fragment_base_status, null);
        tbBaseTitle = statusView.findViewById(R.id.tbBaseTitle);
        msvBaseStatusView = statusView.findViewById(R.id.msvBaseStatusView);
        msvBaseStatusView.setOnRetryClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reloadData();
            }
        });
        FrameLayout flBaseContent = statusView.findViewById(R.id.flBaseContent);
        flBaseContent.addView(contentView);
        return statusView;
    }

    @Override
    public void initStatusInterface() {
        if (basePresenter != null) {
            basePresenter.setTitleAndStatusInt(this, this);
        }
    }

    @Override
    public void setBaseTitleVisible(boolean visible) {
        TitleBarUtil.setTitleVisible(tbBaseTitle, visible);
    }

    @Override
    public void setBaseTitle(String title) {
        TitleBarUtil.setTitle(tbBaseTitle, title);
    }

    @Override
    public void setLeftListener(SingleClickListener listener) {
        TitleBarUtil.setLeftListener(tbBaseTitle, listener);
    }

    @Override
    public void setLeftVisible(boolean visible) {
        TitleBarUtil.setLeftVisible(tbBaseTitle, visible);
    }

    @Override
    public void addRightActions(TitleBar.ActionList actionList) {
        TitleBarUtil.addRightActions(tbBaseTitle, actionList);
    }

    @Override
    public void showLoading() {
        StatusUtil.showLoading(msvBaseStatusView, getLoadingLayoutRes());
    }

    @Override
    public void dismissLoading() {
        StatusUtil.dismissLoading(msvBaseStatusView);
    }

    @Override
    public void dismissLoading(boolean showEmpty, int httpCode) {
        StatusUtil.dismissLoading(msvBaseStatusView, showEmpty, httpCode, getEmptyLayoutRes(), getNetworkErrorLayoutRes());
    }

    @Override
    public void showEmpty() {
        StatusUtil.showEmpty(msvBaseStatusView, getEmptyLayoutRes());
    }

    @Override
    public void showNetworkError() {
        StatusUtil.showNoNetwork(msvBaseStatusView, getNetworkErrorLayoutRes());
    }

    /**
     * 初始化多状态布局
     *
     * @param loadingLayoutRes      ：loading 状态布局
     * @param emptyLayoutRes        ：empty 状态布局
     * @param networkErrorLayoutRes ：网络异常状态布局
     */
    public void initStatusDefaultLayoutRes(int loadingLayoutRes, int emptyLayoutRes, int networkErrorLayoutRes) {
        this.loadingLayoutRes = loadingLayoutRes;
        this.emptyLayoutRes = emptyLayoutRes;
        this.networkErrorLayoutRes = networkErrorLayoutRes;
    }

    public int getLoadingLayoutRes() {
        return loadingLayoutRes;
    }

    public int getEmptyLayoutRes() {
        return emptyLayoutRes;
    }

    public int getNetworkErrorLayoutRes() {
        return networkErrorLayoutRes;
    }
}
