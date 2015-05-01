package com.box.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.box.box.R;
import com.box.mode.ArrivedThing;
import com.box.mode.ArrivingThing;

public class ArriveViewHolder extends BaseViewHolder<ArrivedThing, ArrivingThing> {
    private TextView mTitleText;
    private TextView mNameText;
    private TextView mPhoneText;
    private TextView mSecondLineText;
    private TextView mThreeLineText;
    private TextView mPingLunBtn;

    private ImageView mComeRight;
    private ImageView mHeader;
    private Context context;

    public ArriveViewHolder(ViewGroup parent) {
        super(parent, R.layout.recyclerview_adapter);
        context = parent.getContext();
        mTitleText = (TextView) itemView.findViewById(R.id.recyclerView_title);
        mNameText = (TextView) itemView.findViewById(R.id.recyclerView_name);
        mPhoneText = (TextView) itemView.findViewById(R.id.recyclerView_phone);
        mSecondLineText = (TextView) itemView.findViewById(R.id.recyclerView_twoline);
        mThreeLineText = (TextView) itemView.findViewById(R.id.recyclerView_threeline);
        mPingLunBtn = (TextView) itemView.findViewById(R.id.recyclerview_pinglun);
        mHeader = (ImageView) itemView.findViewById(R.id.recyclerView_header);
        mComeRight = (ImageView) itemView.findViewById(R.id.recyclerview_comein);
    }

    @Override
    public void setFirstData(ArrivedThing data, boolean isFirst) {
        super.setFirstData(data, false);
        if (isFirst) {
            mTitleText.setVisibility(View.VISIBLE);
            mTitleText.setText(context.getString(R.string.recycleradapter_receiving, data.getNumber()));
        } else {
            mTitleText.setVisibility(View.GONE);
        }
        mHeader.setImageResource(data.getHeadImgId());
        mNameText.setText(data.getName());
        mPhoneText.setText(data.getPhone());
        mSecondLineText.setText(context.getString(R.string.recycleradapter_time, data.getTime()));
        mThreeLineText.setText(context.getString(R.string.recycleradapter_place, data.getPlace()));
        mComeRight.setVisibility(View.VISIBLE);
        mPingLunBtn.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setSecondData(ArrivingThing data, boolean isFirst) {
        super.setSecondData(data, false);
        if (isFirst) {
            mTitleText.setVisibility(View.VISIBLE);
            mTitleText.setText(context.getString(R.string.recycleradapter_received, data.getNumber()));
        } else {
            mTitleText.setVisibility(View.GONE);
        }
        mHeader.setImageResource(data.getHeadImgId());
        mNameText.setText(data.getName());
        mPhoneText.setText(data.getPhone());
        mSecondLineText.setText(context.getString(R.string.recycleradapter_state, data.getState()));
        mThreeLineText.setText(context.getString(R.string.recycleradapter_pinglun, data.getPinglun()));
        mPingLunBtn.setVisibility(View.VISIBLE);
        mPingLunBtn.setText("已评");
        mComeRight.setVisibility(View.INVISIBLE);
    }
}
