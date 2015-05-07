package com.box.widget;


import android.content.Context;
import android.view.ViewGroup;

import com.box.mode.QueryInfoThing;
import com.box.mode.ShareDialog;

public class ShareDialogRecyclerAdapter extends MyRecyclerAdapter<ShareDialog> {
    private BaseViewHolder myViewHolder;
    private ShareDialog[] arry;
    private boolean isfirstitem = true;

    public ShareDialogRecyclerAdapter(ShareDialog[] arry, Context context) {
        super(arry, context);
        this.arry = arry;
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        myViewHolder = new ShareDilogViewHolder(parent);
        return myViewHolder;
    }

    @Override
    public void OnBindViewHolder(BaseViewHolder holder, int position) {
        holder.itemView.setId(position);
        holder.setFirstData(arry[position], isfirstitem);
        isfirstitem = false;
    }
}
