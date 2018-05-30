package cn.ecook.basedemo.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.ecook.basedemo.R;

/**
 * @author : ciba
 * @date : 2018/5/28
 * @description : replace your description
 */

public class TabAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public TabAdapter(@Nullable List<String> data) {
        super(R.layout.item_tab, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        TextView tvTab = helper.getView(R.id.tvTab);
        tvTab.setText(item);
    }
}
