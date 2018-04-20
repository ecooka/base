package cn.ecook.base.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import cn.ecook.base.util.GlideUtil;

/**
 * 结合Glide加载图片优化RecyclerView
 * @author ciba
 * @date 2018/4/20
 */

public class ImagesRecyclerView extends RecyclerView {
    public ImagesRecyclerView(Context context) {
        super(context);
    }

    public ImagesRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ImagesRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onScrollStateChanged(int state) {
        super.onScrollStateChanged(state);
        if (SCROLL_STATE_IDLE == state) {
            // 空闲状态恢复图片加载
            GlideUtil.resumeOrPauseRequest(getContext(), true);
        } else if (SCROLL_STATE_DRAGGING == state) {
            // 非空闲状态暂停图片加载
            GlideUtil.resumeOrPauseRequest(getContext(), false);
        }
    }
}
