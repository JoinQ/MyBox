package com.box.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.box.mode.Things;
import java.util.List;

abstract public class MyRecyclerAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> implements View.OnClickListener {
    private OnRecyclerItemClickListener onRecyclerOnClickListener;

    private List<T> list;
    private T things;
    private T[] arry;
    private Context context;

    public MyRecyclerAdapter(T things, Context context) {
        this.context = context;
        this.things = things;
    }
    public MyRecyclerAdapter(List<T> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public MyRecyclerAdapter(T[] arry, Context context) {
        this.arry = arry;
        this.context = context;
    }

    public void clear() {
        things = null;
        list = null;
        arry = null;
        notifyDataSetChanged();
    }

    public void add(T things) {
        this.things = things;
        notifyDataSetChanged();
    }

    public T getItem(int postion) {
        if (things == null) {
            if(list == null) {
                if (arry == null) {
                    return null;
                }
                return arry[postion];
            }
            return list.get(postion);
        }
        return things;
    }

    abstract public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType);

    abstract public void OnBindViewHolder(BaseViewHolder holder, int position);

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return OnCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.itemView.setOnClickListener(this);
        OnBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        if(things != null) {
            int adCount = 0;
            int aingCount = 0;
            if (things instanceof Things) {
                if (things != null) {
                    if (((Things) things).getT() != null) {
                        adCount = (((Things) things).getT()).length;
                    }
                    if (((Things) things).getM() != null) {
                        aingCount = (((Things) things).getM()).length;
                    }
                }
            }
            return adCount + aingCount;
        } else {
            if (list == null) {
                if (arry == null) {
                    return 0;
                } else {
                    return arry.length;
                }
            }
            return list.size();
        }
    }

    @Override
    public void onClick(View v) {
        if (onRecyclerOnClickListener != null) {
            onRecyclerOnClickListener.onItemClick(v, v.getId());
        }
    }

    public static interface OnRecyclerItemClickListener {
        void onItemClick(View v, int position);
    }

    public void setOnRecyclerOnClickListener(OnRecyclerItemClickListener onRecyclerOnClickListener) {
        this.onRecyclerOnClickListener = onRecyclerOnClickListener;
    }
}

