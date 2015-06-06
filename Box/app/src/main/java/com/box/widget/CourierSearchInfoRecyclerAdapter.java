package com.box.widget;

import android.content.Context;
import android.view.ViewGroup;

import com.box.mode.OrderInfoThing;
import com.box.mode.SearchInfoThing;

import java.text.ParseException;

public class CourierSearchInfoRecyclerAdapter extends BaseRecyclerAdapter<SearchInfoThing> {
    private BaseViewHolder myViewHolder;

    public CourierSearchInfoRecyclerAdapter(SearchInfoThing[] things, Context context) {
        super(things, context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        myViewHolder = new CourierSearchInfoViewHolder(parent);
        return myViewHolder;
    }

    @Override
    public void OnBindViewHolder(BaseViewHolder holder, int position) throws ParseException {
        holder.itemView.setId(position);
        holder.itemView.setTag("cao");
        holder.setFirstData(getItem(position), false);
    }

}
