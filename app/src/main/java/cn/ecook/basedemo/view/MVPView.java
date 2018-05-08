package cn.ecook.basedemo.view;

import cn.ecook.base.base.IBaseView;

/**
 * @author ciba
 * @date 2018/4/3
 * @description
 */

public interface MVPView extends IBaseView {
    /**
     * 加载结束
     * @param result
     */
    void loadFinish(String result);
}
