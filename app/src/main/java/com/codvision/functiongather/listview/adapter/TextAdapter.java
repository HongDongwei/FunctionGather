package com.codvision.functiongather.listview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.codvision.functiongather.R;
import com.codvision.functiongather.listview.bean.TextBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hdw on 2019/5/27 19:11
 * todo
 */
public class TextAdapter extends ArrayAdapter<TextBean> {
    private Context mContext;
    private List<TextBean> lists = new ArrayList<>();
    private int resourceId;

    public TextAdapter(Context context, int resource, List<TextBean> objects) {
        super(context, resource, objects);
        mContext = context;
        lists = objects;
        resourceId = resource;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        TextBean model = (TextBean) lists.get(position);
        View view;
        ViewHolder holder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            holder = new ViewHolder();
            holder.itemTextNum = view.findViewById(R.id.item_text_num);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        holder.itemTextNum.setText(model.getNum() + "");

        return view;
    }

    static class ViewHolder {
        TextView itemTextNum;

    }
}
