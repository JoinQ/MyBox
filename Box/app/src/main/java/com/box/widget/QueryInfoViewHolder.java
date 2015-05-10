package com.box.widget;

import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.box.box.R;
import com.box.mode.QueryInfoThing;

public class QueryInfoViewHolder extends BaseViewHolder<QueryInfoThing, NullPointerException> {
    public ImageView mQFImg;
    public TextView mQFTextState;
    public TextView mQFTextTime;


    public QueryInfoViewHolder(ViewGroup parent) {
        super(parent, R.layout.recyclerview_queryinfo_adapter);
        mQFImg = (ImageView) itemView.findViewById(R.id.query_info_img);
        mQFTextState = (TextView) itemView.findViewById(R.id.query_info_state);
        mQFTextTime = (TextView) itemView.findViewById(R.id.query_info_time);
    }

    @Override
    public void setFirstData(QueryInfoThing data, boolean isFirst) {
        super.setFirstData(data, isFirst);

        if (isFirst) {
            mQFTextState.setTextColor(Color.BLACK);
            mQFTextTime.setTextColor(Color.BLACK);
        } else {
            mQFTextState.setTextColor(Color.GRAY);
            mQFTextTime.setTextColor(Color.GRAY);
        }

        mQFImg.setImageResource(data.getImage());
        mQFTextState.setText(data.getStatus());
        mQFTextTime.setText(data.getTime());
    }
}
