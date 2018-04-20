package cn.ecook.base.base.ui;

import cn.ecook.base.listener.SingleClickListener;
import cn.ecook.base.widget.TitleBar;

/**
 * {@link TitleBar}操作接口
 * @author ciba
 * @date 2018/4/3
 */

public interface ITitleBarUi {
    /**
     * 是否展示{@link TitleBar}
     * @param visible : 是否展示
     */
    void setBaseTitleVisible(boolean visible);

    /**
     * 设置TitleBar标题
     * @param title ：标题
     */
    void setBaseTitle(String title);

    /**
     * 设置左边返回按钮点击事件（默认是返回上一页）
     * @param listener ：点击监听
     */
    void setLeftListener(SingleClickListener listener);

    /**
     * 设置左边图标是否显示
     * @param visible ：是否显示左边图标
     */
    void setLeftVisible(boolean visible);

    /**
     * 添加右边拓展按钮
     * @param actionList ：右边拓展按钮
     */
    void addRightActions(TitleBar.ActionList actionList);
}
