package com.box.widget;


import android.content.Context;
import android.view.ViewGroup;

import com.box.mode.QueryInfoThing;
import com.box.mode.ShareDialog;

public class ShareDialogRecyclerAdapter extends MyRecyclerAdapter<ShareDialog> {
    private BaseViewHolder myViewHolder;
    private boolean isfirstitem = true;

    public ShareDialogRecyclerAdapter(ShareDialog[] arry, Context context) {
        super(arry, context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        myViewHolder = new ShareDilogViewHolder(parent);
        return myViewHolder;
    }

    @Override
    public void OnBindViewHolder(BaseViewHolder holder, int position) {
        holder.itemView.setId(position);
        holder.setFirstData(getItem(position), isfirstitem);
        isfirstitem = false;
    }
}
