package com.box.box.courier.search;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.box.box.R;
import com.box.util.Utils;
import com.box.view.SlideCutListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.box.view.SlideCutListView.RemoveDirection;
import com.box.widget.SearchListAdapter;

public class CourierSearchFragment extends Fragment implements AdapterView.OnItemSelectedListener, SlideCutListView.RemoveListener {

    private static String[] site = {"A站点", "B站点", "C站点", "D站点", "E站点"};

    private Spinner courier_search_sp_site;
    private TextView courier_search_tv_date;
    private TextView courier_search_tv_time;
    private ArrayAdapter<String> siteAdapter;

    private SlideCutListView slideCutListView;
    private SearchListAdapter listAdapter;
    private List<Map<String, Object>> listItems;
    private List<String> dataSourceList = new ArrayList<String>();

    private TextView item_state;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getActivity().getActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setTitle("附近订单");

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_courier_search, container, false);

        init(root);
        return root;
    }

    private List<Map<String, Object>> getListItems() {
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 10; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("jjr", "胡晓利13368384763");
            map.put("add_from", "寄件地址：重庆邮电大学20栋楼下5号柜");
            map.put("add_to", "目的地址：重庆邮电大学10栋");
            map.put("type", "付款类型：到付");
            map.put("time", "8:00");
            if (i % 2 == 0)
                map.put("state", true);
            else
                map.put("state", false);
            listItems.add(map);
        }
        return listItems;
    }


    private void init(View root) {
        courier_search_sp_site = (Spinner) root.findViewById(R.id.courier_search_sp_site);
        //将可选内容与ArrayAdapter连接起来
        siteAdapter = new ArrayAdapter<String>(CourierSearchFragment.this.getActivity(), android.R.layout.simple_spinner_item, site);
        siteAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        courier_search_sp_site.setAdapter(siteAdapter);
        courier_search_sp_site.setOnItemSelectedListener(this);

        courier_search_tv_date = (TextView) root.findViewById(R.id.courier_search_tv_date);
        courier_search_tv_time = (TextView) root.findViewById(R.id.courier_search_tv_time);

        SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy/MM/dd");
        courier_search_tv_date.setText(sdfdate.format(new java.util.Date()));

        SimpleDateFormat sdftime = new SimpleDateFormat("HH:mm:ss");
        courier_search_tv_time.setText(sdftime.format(new java.util.Date()));


        slideCutListView = (SlideCutListView) root.findViewById(R.id.courier_search_slideCutListView);
        slideCutListView.setLayoutParams(new LinearLayout.LayoutParams(
                Utils.getScreenWidth() * 2, LinearLayout.LayoutParams.MATCH_PARENT));
        slideCutListView.setRemoveListener(this);
        listItems = getListItems();
        listAdapter = new SearchListAdapter(CourierSearchFragment.this.getActivity(), listItems);
        slideCutListView.setAdapter(listAdapter);

        slideCutListView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CourierSearchFragment.this.getActivity(), "点击  " + position, Toast.LENGTH_SHORT).show();
                item_state = (TextView) view.findViewById(R.id.list_courier_state);
                if (item_state.getVisibility() == View.GONE)
                    startActivity(new Intent(CourierSearchFragment.this.getActivity(), CourierGetExpressActivity.class));
            }
        });


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Utils.Toast(site[position]);
        TextView tv = (TextView) view;
        try {
            tv.setTextColor(CourierSearchFragment.this.getResources().getColor(R.color.toptabtext_release));
        } catch (Exception e) {
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //滑动删除之后的回调方法
    @Override
    public void removeItem(RemoveDirection direction, int position) {
        switch (direction) {
            case LEFT:
                Toast.makeText(CourierSearchFragment.this.getActivity(), "向左  " + position, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(CourierSearchFragment.this.getActivity(), CourierFeedbackActivity.class));
                break;

            default:
                break;
        }

    }

}
