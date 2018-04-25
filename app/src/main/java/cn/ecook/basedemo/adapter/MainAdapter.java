package cn.ecook.basedemo.adapter;

import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.ecook.basedemo.R;

/**
 * @author ciba
 * @date 2018/4/3
 * @description
 */

public class MainAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public MainAdapter(@Nullable List<String> data) {
        super(R.layout.item_main, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, String item) {
        TextView tvContent = holder.getView(R.id.tvContent);
        tvContent.setText(item);
    }
}
