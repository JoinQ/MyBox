package com.box.widget;


import android.content.Context;
import android.view.ViewGroup;

import com.box.mode.MarketThing;

import java.util.List;

public class MarketRecyclerAdapter extends BaseRecyclerAdapter<MarketThing> {
    private BaseViewHolder myViewHolder;

    public MarketRecyclerAdapter(MarketThing[] arry, Context context) {
        super(arry, context);
    }

    public MarketRecyclerAdapter(List<MarketThing> list, Context context) {
        super(list, context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        myViewHolder = new MarketViewHolder(parent);
        return myViewHolder;
    }

    @Override
    public void OnBindViewHolder(BaseViewHolder holder, int position) {
        holder.itemView.setId(position);
        holder.itemView.setTag("cao");
        holder.setFirstData(getItem(position), false);
    }
}
