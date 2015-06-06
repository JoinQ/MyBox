package com.box.widget;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.box.box.R;
import com.box.mode.OrderInfoThing;

public class CourierOrderInfoViewHolder extends BaseViewHolder<OrderInfoThing, NullPointerException> {
    private TextView mNameText;
    private TextView mNumberText;
    private TextView mAddressText;

    private Context context;

    public CourierOrderInfoViewHolder(ViewGroup parent) {
        super(parent, R.layout.recyclerview_orderinfo_adapter);
        context = parent.getContext();
        mNameText = (TextView) itemView.findViewById(R.id.courier_orderinfo_name);
        mNumberText = (TextView) itemView.findViewById(R.id.courier_orderinfo_number);
        mAddressText = (TextView) itemView.findViewById(R.id.courier_orderinfo_twoline);
    }

    @Override
    public void setFirstData(OrderInfoThing data, boolean isFirst) {
        super.setFirstData(data, false);
        mNameText.setText("顺风");
        mNumberText.setText(data.getNumber());
        mAddressText.setText(context.getString(R.string.recycleradapter_address, data.getAddress()));
    }

}
