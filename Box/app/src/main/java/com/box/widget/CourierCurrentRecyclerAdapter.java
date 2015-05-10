package com.box.widget;

import android.content.Context;
import android.view.ViewGroup;

import com.box.mode.CurrentThing;

public class CourierCurrentRecyclerAdapter extends MyRecyclerAdapter<CurrentThing> {
    private BaseViewHolder myViewHolder;

    public CourierCurrentRecyclerAdapter(CurrentThing[] things, Context context) {
        super(things, context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        myViewHolder = new CourierCurrentViewHolder(parent);
        return myViewHolder;
    }

    @Override
    public void OnBindViewHolder(BaseViewHolder holder, int position) {
        holder.itemView.setId(position);
        holder.itemView.setTag("cao");
        holder.setFirstData(getItem(position), false);
    }

}
