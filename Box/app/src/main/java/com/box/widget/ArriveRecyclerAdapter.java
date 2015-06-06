package com.box.widget;

import android.content.Context;
import android.view.ViewGroup;

import com.box.mode.ArrivedThing;
import com.box.mode.ArrivingThing;
import com.box.mode.Things;

public class ArriveRecyclerAdapter extends BaseRecyclerAdapter<Things> {
    private BaseViewHolder myViewHolder;

    public ArriveRecyclerAdapter(Things<ArrivedThing, ArrivingThing> things, Context context) {
        super(things, context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        myViewHolder = new ArriveViewHolder(parent);
        return myViewHolder;
    }

    @Override
    public void OnBindViewHolder(BaseViewHolder holder, int position) {
        holder.itemView.setId(position);
        holder.itemView.setTag("cao");
        if (getItem(position) != null) {
            if (getItem(position).getT() != null && getItem(position).getM() != null) {
                if (getItem(position).getT().length != 0 || getItem(position).getM().length != 0) {
                    if (position + 1 > getItem(position).getT().length) {
                        if (position == getItem(position).getT().length) {
                            myViewHolder.setSecondData(getItem(position).getM()[position - getItem(position).getT().length], true);
                        } else {
                            myViewHolder.setSecondData(getItem(position).getM()[position - getItem(position).getT().length], false);
                        }
                    } else {
                        if (position == 0) {
                            myViewHolder.setFirstData(getItem(position).getT()[position], true);
                        } else {
                            myViewHolder.setFirstData(getItem(position).getT()[position], false);
                        }
                    }
                }
            }
        }
    }

}
