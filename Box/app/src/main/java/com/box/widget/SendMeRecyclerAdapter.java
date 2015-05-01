package com.box.widget;

import android.content.Context;
import android.view.ViewGroup;

import com.box.mode.SendedThing;
import com.box.mode.SendingThing;
import com.box.mode.Things;

public class SendMeRecyclerAdapter extends MyRecyclerAdapter<Things> {
    private Context context;
    private SendingThing[] sendingThings;
    private SendedThing[] sendedThings;

    private BaseViewHolder myViewHolder;

    public SendMeRecyclerAdapter(Things<SendingThing, SendedThing> things, Context context) {
        super(things, context);
        if (things != null) {
            sendingThings = things.getT();
            sendedThings = things.getM();
        }
        this.context = context;
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        myViewHolder = new SendMeViewHolder(parent);
        return myViewHolder;
    }

    @Override
    public void OnBindViewHolder(BaseViewHolder holder, int position) {
        holder.itemView.setId(position);
        holder.itemView.setTag("cao");
        if (sendedThings != null && sendingThings != null) {
            if (sendingThings.length != 0 || sendedThings.length != 0) {
                if (position + 1 > sendingThings.length) {
                    if (position == sendingThings.length) {
                        myViewHolder.setSecondData(sendedThings[position - sendingThings.length], true);
                    } else {
                        myViewHolder.setSecondData(sendedThings[position - sendingThings.length], false);
                    }
                } else {
                    if (position == 0) {
                        myViewHolder.setFirstData(sendingThings[position], true);
                    } else {
                        myViewHolder.setFirstData(sendingThings[position], false);
                    }
                }
            }
        }
    }

}
