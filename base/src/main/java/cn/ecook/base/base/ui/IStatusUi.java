package cn.ecook.base.base.ui;

/**
 * 多状态切换接口
 * @author ciba
 * @date 2018/4/3
 */

public interface IStatusUi {

    /**
     * 切换为loading状态
     */
    void showLoading();

    /**
     * 切换为内容状态
     */
    void dismissLoading();

    /**
     * 如果httpCode为{@link cn.ecook.http.HttpCode} EXCEPTION_TIME_OUT 或者 EXCEPTION_NO_CONNECT
     * 切换为网络错误状态
     * 否则如果showEmpty为true切换为空视图状态
     * @param showEmpty ：是否展示空视图
     * @param httpCode ：网络请求状态
     */
    void dismissLoading(boolean showEmpty, int httpCode);

    /**
     * 直接切换为空视图状态
     */
    void showEmpty();

    /**
     * 直接切换为网络异常状态
     */
    void showNetworkError();
}
