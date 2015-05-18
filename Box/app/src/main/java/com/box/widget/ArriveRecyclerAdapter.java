package com.box.widget;

import android.content.Context;
import android.view.ViewGroup;

import com.box.mode.ArrivedThing;
import com.box.mode.ArrivingThing;
import com.box.mode.Things;

public class ArriveRecyclerAdapter extends BaseRecyclerAdapter<Things> {
    private ArrivedThing[] arrivedThings;
    private ArrivingThing[] arrivingThings;

    private BaseViewHolder myViewHolder;

    public ArriveRecyclerAdapter(Things<ArrivedThing, ArrivingThing> things, Context context) {
        super(things, context);
        if (things != null) {
            arrivedThings = things.getT();
            arrivingThings = things.getM();
        }
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
        if (arrivedThings != null && arrivingThings != null) {
            if (arrivedThings.length != 0 || arrivingThings.length != 0) {
                if (position + 1 > arrivedThings.length) {
                    if (position == arrivedThings.length) {
                        myViewHolder.setSecondData(arrivingThings[position - arrivedThings.length], true);
                    } else {
                        myViewHolder.setSecondData(arrivingThings[position - arrivedThings.length], false);
                    }
                } else {
                    if (position == 0) {
                        myViewHolder.setFirstData(arrivedThings[position], true);
                    } else {
                        myViewHolder.setFirstData(arrivedThings[position], false);
                    }
                }
            }
        }
    }

}
