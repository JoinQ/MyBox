package com.box.widget;

import android.content.Context;
import android.view.ViewGroup;

import com.box.mode.CurrentThing;

import java.text.ParseException;

public class CourierCurrentRecyclerAdapter extends BaseRecyclerAdapter<CurrentThing> {
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
    public void OnBindViewHolder(BaseViewHolder holder, int position) throws ParseException {
        holder.itemView.setId(position);
        holder.itemView.setTag("cao");
        holder.setFirstData(getItem(position), false);
    }

}
