package cn.ecook.base.base.ui;

/**
 *
 * @author 63062
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
     * 如果httpCode为{@link cn.ecook.base.http.HttpCode} EXCEPTION_TIME_OUT 或者 EXCEPTION_NO_CONNECT
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
}
