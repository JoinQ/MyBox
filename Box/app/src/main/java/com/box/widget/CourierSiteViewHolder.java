package com.box.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.box.box.R;
import com.box.mode.SiteThing;

public class CourierSiteViewHolder extends BaseViewHolder<SiteThing, NullPointerException> implements View.OnClickListener {
    private TextView mSiteText;
    private TextView mNumberText;

    private Context context;

    public CourierSiteViewHolder(ViewGroup parent) {
        super(parent, R.layout.recyclerview_adapter_courier_site);
        context = parent.getContext();
        mSiteText = (TextView) itemView.findViewById(R.id.courier_order_site);
        mNumberText = (TextView) itemView.findViewById(R.id.courier_order_amout);
    }

    @Override
    public void setFirstData(SiteThing data, boolean isFirst) {
        super.setFirstData(data, false);
        mSiteText.setText(data.getSite());
        mNumberText.setText(data.getAmout() + "");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        }
    }
}
