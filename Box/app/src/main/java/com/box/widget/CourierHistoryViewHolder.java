package com.box.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.box.box.R;
import com.box.mode.HistoryThing;

public class CourierHistoryViewHolder extends BaseViewHolder<HistoryThing, NullPointerException> {
    private TextView mNumberText;
    private TextView mTimeText;
    private TextView mGAddressText;
    private TextView mPAddressText;
    private TextView mCommentText;

    private RelativeLayout mDelete;
    private ImageView mHeader;
    private Context context;

    public CourierHistoryViewHolder(ViewGroup parent) {
        super(parent, R.layout.recyclerview_history_adapter);
        context = parent.getContext();
        mNumberText = (TextView) itemView.findViewById(R.id.history_number);
        mTimeText = (TextView) itemView.findViewById(R.id.history_time);
        mGAddressText = (TextView) itemView.findViewById(R.id.history_gaddress);
        mPAddressText = (TextView) itemView.findViewById(R.id.history_paddress);
        mCommentText = (TextView) itemView.findViewById(R.id.history_coment);
        mHeader = (ImageView) itemView.findViewById(R.id.history_header);
        mDelete = (RelativeLayout) itemView.findViewById(R.id.history_delte);
    }

    @Override
    public void setFirstData(HistoryThing data, boolean isFirst) {
        super.setFirstData(data, false);
        mHeader.setImageResource(data.getHeaderId());
        mNumberText.setText(data.getNumber());
        mTimeText.setText(data.getTime());
        mGAddressText.setText(data.getgAddress());
        mPAddressText.setText(data.getpAddress());
        mCommentText.setText(data.getComment());
        mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
