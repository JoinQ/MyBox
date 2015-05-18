package com.box.widget;

import android.content.Context;
import android.view.ViewGroup;

import com.box.mode.HistoryThing;

public class CourierHistoryRecyclerAdapter extends BaseRecyclerAdapter<HistoryThing> {

    private BaseViewHolder myViewHolder;

    public CourierHistoryRecyclerAdapter(HistoryThing[] things, Context context) {
        super(things, context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        myViewHolder = new CourierHistoryViewHolder(parent);
        return myViewHolder;
    }

    @Override
    public void OnBindViewHolder(BaseViewHolder holder, int position) {
        holder.itemView.setId(position);
        holder.itemView.setTag("cao");
        holder.setFirstData(getItem(position), false);
    }

}
