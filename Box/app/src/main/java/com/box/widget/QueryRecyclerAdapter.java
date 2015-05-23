package com.box.widget;

import android.content.Context;
import android.view.ViewGroup;

import com.box.mode.QueryingGThing;
import com.box.mode.QueryingSThing;
import com.box.mode.Things;

import java.text.ParseException;

public class QueryRecyclerAdapter extends BaseRecyclerAdapter<Things> {
    private Context context;
    private QueryingGThing[] queryedThings;
    private QueryingSThing[] queryingThings;

    private BaseViewHolder myViewHolder;

    public QueryRecyclerAdapter(Things<QueryingSThing, QueryingGThing> things, Context context) {
        super(things, context);
        if (things != null) {
            queryingThings = things.getT();
            queryedThings = things.getM();
        }
        this.context = context;
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        myViewHolder = new QueryViewHolder(parent);
        return myViewHolder;
    }

    @Override
    public void OnBindViewHolder(BaseViewHolder holder, int position)  {
        holder.itemView.setId(position);
        holder.itemView.setTag("cao");
        if (queryingThings != null && queryedThings != null) {
            if (queryingThings.length != 0 || queryingThings.length != 0) {
                if (position + 1 > queryingThings.length) {
                    if (position == queryingThings.length) {
                        myViewHolder.setSecondData(queryedThings[position - queryingThings.length], true);
                    } else {
                        myViewHolder.setSecondData(queryedThings[position - queryingThings.length], false);
                    }
                } else {
                    if (position == 0) {
                        myViewHolder.setFirstData(queryingThings[position], true);
                    } else {
                        myViewHolder.setFirstData(queryingThings[position], false);
                    }
                }
            }
        }
    }

}
