package com.box.widget;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.box.box.R;
import com.box.mode.SearchInfoThing;

public class CourierSearchInfoViewHolder extends BaseViewHolder<SearchInfoThing, NullPointerException> {
    private TextView mNameText;
    private TextView mNumberText;
    private TextView mBeckText;

    private Context context;

    public CourierSearchInfoViewHolder(ViewGroup parent) {
        super(parent, R.layout.recyclerview_searchinfo_adapter);
        context = parent.getContext();
        mNameText = (TextView) itemView.findViewById(R.id.courier_searchinfo_name);
        mNumberText = (TextView) itemView.findViewById(R.id.courier_searchinfo_number);
        mBeckText = (TextView) itemView.findViewById(R.id.courier_searchinfo_twoline);
    }

    @Override
    public void setFirstData(SearchInfoThing data, boolean isFirst) {
        super.setFirstData(data, false);
        mNameText.setText(data.getName());
        mNumberText.setText(data.getPhone());
        mBeckText.setText(context.getString(R.string.recycleradapter_state, data.getBeck()));
    }

}
