package com.box.widget;


import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.box.box.R;
import com.box.mode.RankThing;

public class RankRecyclerAdapter extends MyRecyclerAdapter<RankThing> {
    private BaseViewHolder myViewHolder;
    private RankThing[] arry;
    private boolean isfirstitem = true;

    public RankRecyclerAdapter(RankThing[] arry, Context context) {
        super(arry, context);
        this.arry = arry;
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
        holder.setFirstData(arry[position], isfirstitem);
        isfirstitem = false;
    }

    public static class QueryInfoViewHolder extends BaseViewHolder<RankThing, NullPointerException> {
        public ImageView rank_ad_iv_grade;
        public TextView rank_ad_tv_grade;
        public ImageView rank_ad_iv_head;
        public TextView rank_ad_tv_name;
        public TextView rank_ad_tv_level;
        public TextView rank_ad_tv_money;


        public QueryInfoViewHolder(ViewGroup parent) {
            super(parent, R.layout.recyclerview_rank_adapter);
            rank_ad_iv_grade = (ImageView) itemView.findViewById(R.id.rank_ad_iv_grade);
            rank_ad_tv_grade = (TextView) itemView.findViewById(R.id.rank_ad_tv_grade);
            rank_ad_iv_head = (ImageView) itemView.findViewById(R.id.rank_ad_iv_head);
            rank_ad_tv_name = (TextView) itemView.findViewById(R.id.rank_ad_tv_name);
            rank_ad_tv_level = (TextView) itemView.findViewById(R.id.rank_ad_tv_level);
            rank_ad_tv_money = (TextView) itemView.findViewById(R.id.rank_ad_tv_money);
        }

        @Override
        public void setFirstData(RankThing data, boolean isFirst) {
            super.setFirstData(data, isFirst);

    //        rank_ad_iv_grade.setImageResource(data.getGrade());
            rank_ad_tv_grade.setText(data.getGrade());
            rank_ad_iv_head.setImageResource(data.getHead());
            rank_ad_tv_name.setText(data.getName());
            rank_ad_tv_level.setText(data.getLevel());
        }
    }
}
