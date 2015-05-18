package com.box.widget;

import android.graphics.Color;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.box.box.R;
import com.box.mode.MarketThing;
import com.box.mode.QueryInfoThing;
import com.facebook.drawee.view.SimpleDraweeView;

public class MarketViewHolder extends BaseViewHolder<MarketThing, NullPointerException> {
    public SimpleDraweeView mImageView;
    public TextView mTextName;


    public MarketViewHolder(ViewGroup parent) {
        super(parent, R.layout.recylerview_adapter_market);
        mImageView = (SimpleDraweeView) itemView.findViewById(R.id.recycler_adapter_market_img);
        mTextName = (TextView) itemView.findViewById(R.id.recycler_adapter_market_name);
    }

    @Override
    public void setFirstData(MarketThing data, boolean isFirst) {
        super.setFirstData(data, isFirst);
        mImageView.setImageURI(Uri.parse(data.getImgUri()));
        mTextName.setText(data.getName());
    }
}