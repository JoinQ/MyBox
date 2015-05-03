package com.box.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.box.box.R;
import com.box.mode.ArrivedThing;
import com.box.mode.ArrivingThing;
import com.box.mode.ExpressInfoThing;
import com.box.mode.Things;

import java.util.List;

/**
 * Created by yyx on 2015/05/03 003.
 */
public class ExpressInfoRecylerAdapter extends RecyclerView.Adapter<ExpressInfoRecylerAdapter.ViewHolder> {
    private Context context;
//    private List<ExpressInfoThing> items;
    private int itemLayout;
    private ExpressInfoThing[] expressInfoThing;


    public ExpressInfoRecylerAdapter(ExpressInfoThing[] expressInfoThing, int itemLayout) {
        this.itemLayout = itemLayout;
        this.expressInfoThing = expressInfoThing;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.express_info_re_adapter, viewGroup, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        ExpressInfoThing item = expressInfoThing[position];
        viewHolder.express_info_ad_iv.setImageResource(item.getImage());
        viewHolder.express_info_ad_tv_sta.setText(item.getStatus());
        viewHolder.express_info_ad_tv_time.setText(item.getTime());
        viewHolder.itemView.setTag(item);

    }

    @Override
    public int getItemCount() {
        return expressInfoThing.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView express_info_ad_iv;
        public TextView express_info_ad_tv_sta;
        public TextView express_info_ad_tv_time;


        public ViewHolder(View itemView) {
            super(itemView);
            express_info_ad_iv = (ImageView) itemView.findViewById(R.id.express_info_ad_iv);
            express_info_ad_tv_sta = (TextView) itemView.findViewById(R.id.express_info_ad_tv_sta);
            express_info_ad_tv_time = (TextView) itemView.findViewById(R.id.express_info_ad_tv_time);
        }
    }

}
