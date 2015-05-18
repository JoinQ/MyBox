package com.box.box.courier.order.functionfragment.current;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.box.box.R;
import com.box.mode.CurrentThing;
import com.box.util.Utils;
import com.box.widget.CourierCurrentRecyclerAdapter;
import com.box.widget.BaseRecyclerAdapter;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

public class CourierCurrentFragment extends Fragment {
    private SuperRecyclerView recyclerView;
    private CourierCurrentRecyclerAdapter adapter;
    private CurrentThing[] currentThings;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentThings = new CurrentThing[]{new CurrentThing("景苑7栋1单元10号柜子", R.drawable.coporation1, "顺风", "12345678901", "1232132332", "胡小丽"),
                new CurrentThing("景苑7栋1单元10号柜子", R.drawable.coporation2, "中通", "12345678901", "213121", "胡晓利")};
        adapter = new CourierCurrentRecyclerAdapter(currentThings, getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_courier_current, container, false);
        initView(root);
        return root;
    }

    private void initView(View root) {
        recyclerView = (SuperRecyclerView) root.findViewById(R.id.courier_current_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.hideProgress();
        recyclerView.hideMoreProgress();
        recyclerView.setAdapter(adapter);
        recyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                adapter.clear();
                adapter.add(currentThings);
                Utils.Toast("刷新le");
            }
        });

        adapter.setOnRecyclerOnClickListener(new BaseRecyclerAdapter.OnRecyclerItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                if (position == 1) {
                    Utils.Toast("cao");
                } else {
                    Utils.Toast("ok");
                }
            }
        });
    }
}
