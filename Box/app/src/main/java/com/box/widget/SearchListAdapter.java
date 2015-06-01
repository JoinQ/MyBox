package com.box.widget;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.box.box.R;
import com.box.mode.RankThing;

import java.util.List;
import java.util.Map;

public class SearchListAdapter extends BaseAdapter {

    private Context context;
    private List<Map<String, Object>> listItems;
    private LayoutInflater listContainer;

    private TextView list_courier_jjr;
    private TextView list_courier_add_from;
    private TextView list_courier_add_to;
    private TextView list_courier_pay_type;
    private TextView list_courier_time;
    private TextView list_courier_state;


    public SearchListAdapter(Context context, List<Map<String, Object>> listItems) {
        this.context = context;
        listContainer = LayoutInflater.from(context);   //创建视图容器并设置上下文
        this.listItems = listItems;
    }


    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = listContainer.inflate(R.layout.listview_courier_search_adapter, null);
        list_courier_jjr = (TextView) convertView.findViewById(R.id.list_courier_jjr);
        list_courier_add_from = (TextView) convertView.findViewById(R.id.list_courier_add_from);
        list_courier_add_to = (TextView) convertView.findViewById(R.id.list_courier_add_to);
        list_courier_pay_type = (TextView) convertView.findViewById(R.id.list_courier_pay_type);
        list_courier_time = (TextView) convertView.findViewById(R.id.list_courier_time);
        list_courier_state = (TextView) convertView.findViewById(R.id.list_courier_state);

        list_courier_jjr.setText(listItems.get(position).get("jjr").toString());
        list_courier_add_from.setText(listItems.get(position).get("add_from").toString());
        list_courier_add_to.setText(listItems.get(position).get("add_to").toString());
        list_courier_pay_type.setText(listItems.get(position).get("type").toString());
        list_courier_time.setText(listItems.get(position).get("time").toString());
        if (listItems.get(position).get("state").toString().equals("true"))
            list_courier_state.setVisibility(View.VISIBLE);
        else
            list_courier_state.setVisibility(View.GONE);
        return convertView;
    }
}
