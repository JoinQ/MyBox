package com.box.widget;


import android.content.Context;
import android.view.ViewGroup;

import com.box.mode.QueryInfoThing;

public class QueryInfoRecyclerAdapter extends MyRecyclerAdapter<QueryInfoThing> {
    private BaseViewHolder myViewHolder;
    private QueryInfoThing[] arry;
    private boolean isfirstitem = true;

    public QueryInfoRecyclerAdapter(QueryInfoThing[] arry, Context context) {
        super(arry, context);
        this.arry = arry;
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        myViewHolder = new QueryInfoViewHolder(parent);
        return myViewHolder;
    }

    @Override
    public void OnBindViewHolder(BaseViewHolder holder, int position) {
        holder.itemView.setId(position);
        holder.itemView.setTag("cao");
        holder.setFirstData(arry[position], isfirstitem);
        isfirstitem = false;
    }
}
