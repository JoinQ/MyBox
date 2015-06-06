package com.box.box.courier.search;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.box.box.R;
import com.box.mode.SiteThing;
import com.box.util.Utils;
import com.box.widget.BaseRecyclerAdapter;
import com.box.widget.CourierSiteRecyclerAdapter;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

public class CourierSearchFragment extends Fragment {
    private SuperRecyclerView recyclerView;
    private CourierSiteRecyclerAdapter adapter;
    private SiteThing[] siteThings;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getActivity().getActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setTitle("附近寄件");
        siteThings = new SiteThing[]{new SiteThing("站点一", 7), new SiteThing("站点二", 1), new SiteThing("站点三", 10)};
        adapter = new CourierSiteRecyclerAdapter(siteThings, getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_courier_search, container, false);
        initView(root);
        return root;
    }

    private void initView(View root) {
        recyclerView = (SuperRecyclerView) root.findViewById(R.id.courier_search_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.hideProgress();
        recyclerView.hideMoreProgress();
        recyclerView.setAdapter(adapter);
        recyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                adapter.clear();
                adapter.add(siteThings);
                Utils.Toast("刷新le");
            }
        });

        adapter.setOnRecyclerOnClickListener(new BaseRecyclerAdapter.OnRecyclerItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), CourierSearchInfoActivity.class);
                startActivity(intent);
            }
        });
    }
}
