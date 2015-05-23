package com.box.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.box.mode.Things;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract public class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> implements View.OnClickListener {
    private OnRecyclerItemClickListener onRecyclerOnClickListener;

    private List<T> list = new ArrayList<T>();
    private T things;
    private Context context;

    public BaseRecyclerAdapter(T things, Context context) {
        this.context = context;
        this.things = things;
    }
    public BaseRecyclerAdapter(List<T> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public BaseRecyclerAdapter(T[] arry, Context context) {
        list = new ArrayList<T>(Arrays.asList(arry));
        this.context = context;
    }

    public void clear() {
        things = null;
        list.clear();
        notifyDataSetChanged();
    }

    public void add(T things) {
        this.things = things;
        notifyDataSetChanged();
    }

    public void add(T[] arry) {
        if (arry != null) {
            List list2 = new ArrayList<T>(Arrays.asList(arry));
            list.addAll(list2);
        }
        notifyDataSetChanged();
    }

    public void add(List<T> list) {
        if (list != null) {
            this.list.addAll(list);
        }
        notifyDataSetChanged();
    }

    public T getItem(int postion) {
        if (things == null) {
            if(list == null) {
                return null;
            }
            return list.get(postion);
        }
        return things;
    }

    abstract public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType);

    abstract public void OnBindViewHolder(BaseViewHolder holder, int position) throws ParseException;

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return OnCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.itemView.setOnClickListener(this);
        try {
            OnBindViewHolder(holder, position);
        } catch (ParseException e) {
            e.printStackTrace();
        }
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
                return 0;
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

