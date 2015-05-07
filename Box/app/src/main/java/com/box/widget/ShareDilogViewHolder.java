package com.box.widget;

import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.box.box.R;
import com.box.mode.QueryInfoThing;
import com.box.mode.ShareDialog;

import org.w3c.dom.Text;

public class ShareDilogViewHolder extends BaseViewHolder<ShareDialog, NullPointerException> {
    public ImageView shareImage;
    public TextView shareText;


    public ShareDilogViewHolder(ViewGroup parent) {
        super(parent, R.layout.recyclerview_sharedilog_adapter);
        shareImage = (ImageView) itemView.findViewById(R.id.share_adapter_img);
        shareText = (TextView) itemView.findViewById(R.id.share_adapter_text);
    }

    @Override
    public void setFirstData(ShareDialog data, boolean isFirst) {
        super.setFirstData(data, isFirst);
        shareImage.setImageResource(data.getId());
        shareText.setText(data.getName());
    }
}
