package com.box.widget;

import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.box.box.R;
import com.box.mode.QueryInfoThing;
import com.box.mode.RankThing;

public class RankViewHolder extends BaseViewHolder<RankThing, NullPointerException> {
    public ImageView rank_ad_iv_grade;
    public TextView rank_ad_tv_grade;
    public ImageView rank_ad_iv_head;
    public TextView rank_ad_tv_name;
    public TextView rank_ad_tv_level;
    public TextView rank_ad_tv_money;


    public RankViewHolder(ViewGroup parent) {
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

        switch (data.getGrade())
        {
            case 1:
                rank_ad_iv_grade.setImageResource(R.drawable.rank_no1);
                break;
            case 2:
                rank_ad_iv_grade.setImageResource(R.drawable.rank_no2);
                break;
            default:
                rank_ad_iv_grade.setImageResource(R.drawable.rank_no3);
                break;
        }

        rank_ad_tv_grade.setText(data.getGrade()+"");
        rank_ad_iv_head.setImageResource(data.getHead());
        rank_ad_tv_name.setText(data.getName());
        rank_ad_tv_level.setText(data.getLevel()+"");
        rank_ad_tv_money.setText(data.getMoney()+"");
    }
}