package com.box.widget;


import android.content.Context;
import android.view.ViewGroup;
import com.box.mode.RankThing;

public class RankRecyclerAdapter extends BaseRecyclerAdapter<RankThing> {
    private BaseViewHolder myViewHolder;
    private boolean isfirstitem = true;

    public RankRecyclerAdapter(RankThing[] arry, Context context) {
        super(arry, context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        myViewHolder = new RankViewHolder(parent);
        return myViewHolder;
    }

    @Override
    public void OnBindViewHolder(BaseViewHolder holder, int position) {
        holder.itemView.setId(position);
        holder.itemView.setTag("cao");
        holder.setFirstData(getItem(position), isfirstitem);
        isfirstitem = false;
    }
}
