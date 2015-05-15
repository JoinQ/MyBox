package com.box.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.box.box.R;
import com.box.mode.SettingThing;

public class SettingViewHolder extends BaseViewHolder<SettingThing, NullPointerException> {
    public View view;
    public ImageView img;
    public TextView text;


    public SettingViewHolder(ViewGroup parent) {
        super(parent, R.layout.recyclerview_adapter_setting);
        view = itemView.findViewById(R.id.setting_adapter_view);
        img = (ImageView) itemView.findViewById(R.id.setting_adapter_icon);
        text = (TextView) itemView.findViewById(R.id.setting_adapter_name);
    }

    @Override
    public void setFirstData(SettingThing data, boolean isFirst) {
        super.setFirstData(data, isFirst);
        text.setText(data.getName());
        img.setImageResource(data.getImageId());
        if (!data.getIsAppear()) {
            view.setVisibility(View.GONE);
        }
    }
}