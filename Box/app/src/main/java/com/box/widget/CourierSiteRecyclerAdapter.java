package com.box.widget;

import android.content.Context;
import android.view.ViewGroup;

import com.box.mode.SiteThing;

import java.text.ParseException;

public class CourierSiteRecyclerAdapter extends BaseRecyclerAdapter<SiteThing> {
    private BaseViewHolder myViewHolder;

    public CourierSiteRecyclerAdapter(SiteThing[] things, Context context) {
        super(things, context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        myViewHolder = new CourierSiteViewHolder(parent);
        return myViewHolder;
    }

    @Override
    public void OnBindViewHolder(BaseViewHolder holder, int position) throws ParseException {
        holder.itemView.setId(position);
        holder.itemView.setTag("cao");
        holder.setFirstData(getItem(position), false);
    }

}
