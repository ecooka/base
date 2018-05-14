package cn.ecook.base.base.ui;

import android.view.LayoutInflater;
import android.view.View;

import cn.ecook.base.R;
import cn.ecook.base.base.BaseConfig;
import cn.ecook.base.base.BasePresenter;
import cn.ecook.base.widget.MultipleStatusView;
import cn.ecook.base.util.StatusUtil;

/**
 * @author ciba
 * @date 2018/4/4
 */

public abstract class BaseStatusFragment<T extends BasePresenter> extends BaseFragment<T> implements IStatusUi {
    protected MultipleStatusView msvBaseStatusView;
    private int loadingLayoutRes = BaseConfig.DEFAULT_LOADING_STATUS_RES;
    private int emptyLayoutRes = BaseConfig.DEFAULT_EMPTY_STATUS_RES;
    private int networkErrorLayoutRes = BaseConfig.DEFAULT_NETWORK_ERROR_STATUS_RES;

    @Override
    public final boolean titleAndStatus() {
        return true;
    }

    @Override
    public View initStatusView(View contentView) {
        msvBaseStatusView = (MultipleStatusView) LayoutInflater.from(activity).inflate(R.layout.fragment_base_status, null, false);
        msvBaseStatusView.setOnRetryClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reloadData();
            }
        });
        msvBaseStatusView.addView(contentView, 0, msvBaseStatusView.DEFAULT_LAYOUT_PARAMS);
        return msvBaseStatusView;
    }

    @Override
    public void initIStatusUi() {
        if (basePresenter != null) {
            basePresenter.setIStatusUi(this);
        }
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
