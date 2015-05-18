package com.box.widget;


import android.content.Context;
import android.view.ViewGroup;

import com.box.mode.SettingThing;

import java.util.List;

public class SettingRecyclerAdapter extends BaseRecyclerAdapter<SettingThing> {
    private BaseViewHolder myViewHolder;

    public SettingRecyclerAdapter(SettingThing[] arry, Context context) {
        super(arry, context);
    }

    public SettingRecyclerAdapter(List<SettingThing> list, Context context) {
        super(list, context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        myViewHolder = new SettingViewHolder(parent);
        return myViewHolder;
    }

    @Override
    public void OnBindViewHolder(BaseViewHolder holder, int position) {
        holder.itemView.setId(position);
        holder.itemView.setTag("cao");
        holder.setFirstData(getItem(position), false);
    }
}
