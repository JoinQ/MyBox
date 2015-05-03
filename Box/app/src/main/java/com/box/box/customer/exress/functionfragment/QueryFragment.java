package com.box.box.customer.exress.functionfragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;

import com.box.box.R;
import com.box.box.customer.exress.ExpressInformationActivity;
import com.box.mode.QueryingGThing;
import com.box.mode.QueryingSThing;
import com.box.mode.Things;
import com.box.util.Utils;
import com.box.widget.MyRecyclerAdapter;
import com.box.widget.QueryRecyclerAdapter;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

public class QueryFragment extends Fragment {
    private SuperRecyclerView recyclerView;
    private Things things;
    private QueryRecyclerAdapter adapter;

    private View root;
    private boolean isFirst = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QueryingSThing[] queryingSThing = {new QueryingSThing("3", R.drawable.coporation1, "顺风", "12345678901", "2015-5-1 6：00", "已到达渝北小区2栋3号柜"),
                new QueryingSThing("3", R.drawable.coporation2, "中通", "12345678901", "2015-5-1 6:00", "已到达渝北小区1栋16号柜")};
        QueryingGThing[] queryingGThing = {new QueryingGThing("2", R.drawable.coporation1, "顺风", "12345678901", "2015-5-1 6：00", "已到达渝北小区2栋3号柜"),
                new QueryingGThing("2", R.drawable.coporation2, "中通", "12345678901", "2015-5-1 6:00", "已到达渝北小区1栋16号柜")};
        things = new Things<QueryingSThing, QueryingGThing>(queryingSThing, queryingGThing);
        adapter = new QueryRecyclerAdapter(things, getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_query, container, false);
//        initView(root);
        return root;
    }

    private void initView(View v) {
        recyclerView = (SuperRecyclerView) v.findViewById(R.id.query_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        recyclerView.hideProgress();

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
                Log.i("ExpressInformation", "ExpressInformationActivity");
                startActivity(new Intent(QueryFragment.this.getActivity(), ExpressInformationActivity.class));
            }
        });
    }

    public void setLayout() {
        if (isFirst) {
            isFirst = false;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    ((LinearLayout) root.findViewById(R.id.query_header)).addView(LayoutInflater.from(getActivity()).inflate(R.layout.header_query, null, false));
                    QueryFragment.this.getView().startAnimation(getAlphaAnimation());
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
