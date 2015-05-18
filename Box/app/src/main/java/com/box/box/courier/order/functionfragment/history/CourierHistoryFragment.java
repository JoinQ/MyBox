package com.box.box.courier.order.functionfragment.history;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;

import com.box.box.R;
import com.box.mode.HistoryThing;
import com.box.util.Utils;
import com.box.widget.CourierHistoryRecyclerAdapter;
import com.box.widget.BaseRecyclerAdapter;
import com.malinskiy.superrecyclerview.OnMoreListener;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

public class CourierHistoryFragment extends Fragment {
    private View root;
    private SuperRecyclerView recyclerView;
    private CourierHistoryRecyclerAdapter adapter;
    private HistoryThing[] historyThings;
    private boolean isFirst = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        historyThings = new HistoryThing[] {new HistoryThing("满意", "xx小区xx号柜", R.drawable.coporation1, "123131231", "xx小区xx号柜", "2015-12-01 11:10"),
                new HistoryThing("满意", "xx小区xx号柜", R.drawable.coporation1, "123131231", "xx小区xx号柜", "2015-12-01 11:10"),
                new HistoryThing("满意", "xx小区xx号柜", R.drawable.coporation1, "123131231", "xx小区xx号柜", "2015-12-01 11:10")};
        adapter = new CourierHistoryRecyclerAdapter(historyThings, getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_courier_history, container, false);
        return root;
    }

    private void initView(View v) {
        recyclerView = (SuperRecyclerView) v.findViewById(R.id.courier_history_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        recyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                adapter.clear();
                adapter.add(historyThings);
                Utils.Toast("刷新le");
            }
        });

        recyclerView.setOnMoreListener(new OnMoreListener() {
            @Override
            public void onMoreAsked(int i, int i1, int i2) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapter.add(historyThings);
                        recyclerView.hideMoreProgress();
                    }
                }, 500);
                ;
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

    public void setLayout() {
        if (isFirst) {
            isFirst = false;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    CourierHistoryFragment.this.getView().startAnimation(getAlphaAnimation());
                    initView(root);
                }
            }, 300);
        }
    }

    private AnimationSet getAlphaAnimation() {
        AnimationSet animationSet = new AnimationSet(false);
        AlphaAnimation animation = new AlphaAnimation(0, 1);
        animation.setInterpolator(new DecelerateInterpolator());
        animation.setDuration(300);
        animation.setFillAfter(true);
        animationSet.addAnimation(animation);
        return animationSet;
    }
}
