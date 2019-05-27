package com.codvision.functiongather.citychoice.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.codvision.functiongather.R;
import com.codvision.functiongather.citychoice.bean.AddressBean;

import java.util.List;

/**
 * Created by hdw on 2019/5/27 9:34
 * todo
 */
public class AreaAdapter extends BaseQuickAdapter<AddressBean.CityBean.AreaBean, BaseViewHolder> {
    public AreaAdapter(int layoutResId, @Nullable List<AddressBean.CityBean.AreaBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AddressBean.CityBean.AreaBean item) {
        helper.setText(R.id.textview, item.getLabel());
        helper.setTextColor(R.id.textview, item.isStatus() ? Color.parseColor("#65C15C") : Color.parseColor("#444444"));
    }
}
