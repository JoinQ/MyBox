package com.box.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.box.box.R;
import com.box.mode.CurrentThing;

import org.w3c.dom.Text;

public class CourierCurrentViewHolder extends BaseViewHolder<CurrentThing, NullPointerException> {
    private TextView mTitleText;
    private TextView mNameText;
    private TextView mNumberText;
    private TextView mSecondLineText;
    private TextView mThreeLineText;
    private TextView mPingLunBtn;

    private ImageView mComeRight;
    private ImageView mHeader;
    private Context context;

    public CourierCurrentViewHolder(ViewGroup parent) {
        super(parent, R.layout.recyclerview_adapter);
        context = parent.getContext();
        mTitleText = (TextView) itemView.findViewById(R.id.recyclerView_title);
        mNameText = (TextView) itemView.findViewById(R.id.recyclerView_name);
        mNumberText = (TextView) itemView.findViewById(R.id.recyclerView_phone);
        mSecondLineText = (TextView) itemView.findViewById(R.id.recyclerView_twoline);
        mThreeLineText = (TextView) itemView.findViewById(R.id.recyclerView_threeline);
        mPingLunBtn = (TextView) itemView.findViewById(R.id.recyclerview_pinglun);
        mHeader = (ImageView) itemView.findViewById(R.id.recyclerView_header);
        mComeRight = (ImageView) itemView.findViewById(R.id.recyclerview_comein);
    }

    @Override
    public void setFirstData(CurrentThing data, boolean isFirst) {
        super.setFirstData(data, false);
        mHeader.setImageResource(data.getHeaderId());
        mNameText.setText(data.getName());
        mNumberText.setText(data.getPhone());
        mSecondLineText.setText(context.getString(R.string.recycleradapter_receiver, data.getUserName(), data.getPhone()));
        mThreeLineText.setText(context.getString(R.string.recycleradapter_place, data.getAddress()));

        mTitleText.setVisibility(View.GONE);
        mComeRight.setVisibility(View.VISIBLE);
        mPingLunBtn.setVisibility(View.INVISIBLE);
    }
}
