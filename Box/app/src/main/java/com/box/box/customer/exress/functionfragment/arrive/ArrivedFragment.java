package com.box.box.customer.exress.functionfragment.arrive;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.box.box.R;
import com.box.mode.ArrivedThing;
import com.box.mode.ArrivingThing;
import com.box.mode.Things;
import com.box.util.Utils;
import com.box.widget.ArriveRecyclerAdapter;
import com.box.widget.MyRecyclerAdapter;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

public class ArrivedFragment extends Fragment {
    private SuperRecyclerView recyclerView;
    private Things things;
    private ArriveRecyclerAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrivedThing[] arrivedThings = {new ArrivedThing("3", R.drawable.coporation1, "顺风", "12345678901", "2015-04-24 2:00pm", "景苑7栋1单元10号柜子"),
                new ArrivedThing("3", R.drawable.coporation2, "中通", "12345678901", "2015-04-24 3:00pm", "景苑7栋1单元10号柜子")};
        ArrivingThing[] arrivingThings = {new ArrivingThing("2", R.drawable.coporation1, "顺风", "1234567980", "2015-04-24 1:00pm", "非常好啊！"),
                new ArrivingThing("2", R.drawable.coporation2, "中通", "1234567980", "2015-04-24 2:00pm", "真垃圾！")};
        things = new Things<ArrivedThing, ArrivingThing>(arrivedThings, arrivingThings);
        adapter = new ArriveRecyclerAdapter(things, getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_arrived, container, false);
        initView(root);
        return root;
    }

    private void initView(View v) {
        recyclerView = (SuperRecyclerView) v.findViewById(R.id.arrived_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.hideProgress();
        recyclerView.hideMoreProgress();
        recyclerView.setAdapter(adapter);
        recyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                adapter.clear();
                adapter.add(things);
                Utils.Toast("刷新");
            }
        });

        adapter.setOnRecyclerOnClickListener(new MyRecyclerAdapter.OnRecyclerItemClickListener() {
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