package com.box.widget;

import android.content.Context;
import android.view.ViewGroup;

import com.box.mode.OrderInfoThing;
import java.text.ParseException;

public class CourierOrderInfoRecyclerAdapter extends BaseRecyclerAdapter<OrderInfoThing> {
    private BaseViewHolder myViewHolder;

    public CourierOrderInfoRecyclerAdapter(OrderInfoThing[] things, Context context) {
        super(things, context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        myViewHolder = new CourierOrderInfoViewHolder(parent);
        return myViewHolder;
    }

    @Override
    public void OnBindViewHolder(BaseViewHolder holder, int position) throws ParseException {
        holder.itemView.setId(position);
        holder.itemView.setTag("cao");
        holder.setFirstData(getItem(position), false);
    }

}
