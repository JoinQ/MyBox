package com.box.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.box.box.R;
import com.box.mode.QueryingGThing;
import com.box.mode.QueryingSThing;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class QueryViewHolder extends BaseViewHolder<QueryingSThing, QueryingGThing> {
    private TextView mTitleText;
    private TextView mNameText;
    private TextView mPhoneText;
    private TextView mSecondLineText;
    private TextView mThreeLineText;
    private TextView mPingLunBtn;

    private ImageView mComeRight;
    private ImageView mHeader;
    private ImageView mOverday;

    private Context context;

    public QueryViewHolder(ViewGroup parent) {
        super(parent, R.layout.recyclerview_adapter);
        context = parent.getContext();
        mTitleText = (TextView) itemView.findViewById(R.id.recyclerView_title);
        mNameText = (TextView) itemView.findViewById(R.id.recyclerView_name);
        mPhoneText = (TextView) itemView.findViewById(R.id.recyclerView_phone);
        mSecondLineText = (TextView) itemView.findViewById(R.id.recyclerView_twoline);
        mThreeLineText = (TextView) itemView.findViewById(R.id.recyclerView_threeline);
        mPingLunBtn = (TextView) itemView.findViewById(R.id.recyclerview_pinglun);
        mHeader = (ImageView) itemView.findViewById(R.id.recyclerView_header);
        mOverday = (ImageView) itemView.findViewById(R.id.recyclerView_overday);
        mComeRight = (ImageView) itemView.findViewById(R.id.recyclerview_comein);
    }

    @Override
    public void setFirstData(QueryingSThing data, boolean isFirst) {
        super.setFirstData(data, false);
        if (isFirst) {
            mTitleText.setVisibility(View.VISIBLE);
            mTitleText.setText(context.getString(R.string.recycleradapter_wayget, data.getNumber()));
        } else {
            mTitleText.setVisibility(View.GONE);
        }
        mHeader.setImageResource(data.getHeadImgId());
        mNameText.setText(data.getName());
        mPhoneText.setText(data.getPhone());
        mSecondLineText.setText(context.getString(R.string.recycleradapter_time, data.getTime()));
        mThreeLineText.setText(context.getString(R.string.recycleradapter_state, data.getState()));
        mComeRight.setVisibility(View.VISIBLE);
        mPingLunBtn.setVisibility(View.INVISIBLE);

        if (data.isOverday())
        {
            mOverday.setVisibility(View.VISIBLE);
        }
        else
        {
            mOverday.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void setSecondData(QueryingGThing data, boolean isFirst) {
        super.setSecondData(data, false);
        if (isFirst) {
            mTitleText.setVisibility(View.VISIBLE);
            mTitleText.setText(context.getString(R.string.recycleradapter_waysend, data.getNumber()));
        } else {
            mTitleText.setVisibility(View.GONE);
        }
        mHeader.setImageResource(data.getHeadImgId());
        mNameText.setText(data.getName());
        mPhoneText.setText(data.getPhone());
        mSecondLineText.setText(context.getString(R.string.recycleradapter_time, data.getTime()));
        mThreeLineText.setText(context.getString(R.string.recycleradapter_state, data.getState()));
        mPingLunBtn.setVisibility(View.INVISIBLE);
        mComeRight.setVisibility(View.VISIBLE);
        mOverday.setVisibility(View.INVISIBLE);
    }
}
