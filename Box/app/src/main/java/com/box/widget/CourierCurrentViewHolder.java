package com.box.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.box.box.R;
import com.box.mode.CurrentThing;

import org.w3c.dom.Text;

public class CourierCurrentViewHolder extends BaseViewHolder<CurrentThing, NullPointerException> implements View.OnClickListener {
    private TextView mTitleText;
    private TextView mNumText;
    private TextView mNameText;
    private TextView mNumberText;
    private TextView mSecondLineText;
    private TextView mThreeLineText;
    private TextView mPingLunBtn;

    private RelativeLayout mAllrl;
    private FrameLayout mtitlefl;

    private ImageView mComeRight;
    private ImageView mHeader;
    private Context context;

    public CourierCurrentViewHolder(ViewGroup parent) {
        super(parent, R.layout.recyclerview_adapter);
        context = parent.getContext();
        mTitleText = (TextView) itemView.findViewById(R.id.recyclerView_title);
        mNumText = (TextView) itemView.findViewById(R.id.recyclerView_num);
        mNameText = (TextView) itemView.findViewById(R.id.recyclerView_name);
        mNumberText = (TextView) itemView.findViewById(R.id.recyclerView_phone);
        mSecondLineText = (TextView) itemView.findViewById(R.id.recyclerView_twoline);
        mThreeLineText = (TextView) itemView.findViewById(R.id.recyclerView_threeline);
        mPingLunBtn = (TextView) itemView.findViewById(R.id.recyclerview_pinglun);
        mAllrl = (RelativeLayout) itemView.findViewById(R.id.recyclerView_rl);
        mtitlefl = (FrameLayout) itemView.findViewById(R.id.recyclerView_fl_title);
        mHeader = (ImageView) itemView.findViewById(R.id.recyclerView_header);
        mComeRight = (ImageView) itemView.findViewById(R.id.recyclerview_comein);
    }

    @Override
    public void setFirstData(CurrentThing data, boolean isFirst) {
        super.setFirstData(data, false);
        mTitleText.setText(data.getSite());
        mNumText.setText("["+data.getNum()+"]");
        mNumText.setVisibility(View.VISIBLE);
        mHeader.setImageResource(data.getHeaderId());
        mNameText.setText(data.getName());
        mNumberText.setText(data.getPhone());
        mSecondLineText.setText(context.getString(R.string.recycleradapter_receiver, data.getUserName(), data.getPhone()));
        mThreeLineText.setText(context.getString(R.string.recycleradapter_place, data.getAddress()));

        mtitlefl.setBackgroundResource(R.color.courier_current_title_background);

        mTitleText.setVisibility(View.VISIBLE);
        mTitleText.setPadding(0,8,0,8);
        mtitlefl.setOnClickListener(this);
        mComeRight.setVisibility(View.VISIBLE);
        mPingLunBtn.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.recyclerView_fl_title:
                if (mAllrl.getVisibility() == View.VISIBLE) {
                    mAllrl.setVisibility(View.GONE);
                } else {
                    mAllrl.setVisibility(View.VISIBLE);
                }
                break;
        }
    }
}
