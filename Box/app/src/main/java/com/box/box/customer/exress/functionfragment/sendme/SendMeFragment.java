package com.box.box.customer.exress.functionfragment.sendme;

import android.content.Intent;
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
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.box.box.R;
import com.box.mode.SendedThing;
import com.box.mode.SendingThing;
import com.box.mode.Things;
import com.box.util.Utils;
import com.box.widget.BaseRecyclerAdapter;
import com.box.widget.SendMeRecyclerAdapter;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

public class SendMeFragment extends Fragment implements View.OnClickListener{

    private SuperRecyclerView recyclerView;
    private Things things;
    private SendMeRecyclerAdapter adapter;

    private FrameLayout sendme_fl_wyjj;

    private View root;
    private LinearLayout headerView;
    private boolean isFirst = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SendingThing[] sendingThing = {new SendingThing("3", R.drawable.coporation1, "顺" +
                "风", "12345678901", "快递员已经取走", "2015-5-1 6：00")};
        SendedThing[] sendedThing = {new SendedThing("2", R.drawable.coporation1, "顺风", "1234567980", "已经收货", "非常好啊！"),
                new SendedThing("2", R.drawable.coporation2, "中通", "1234567980", "送货途中", "真牛逼！")};
        things = new Things<SendingThing, SendedThing>(sendingThing, sendedThing);
        adapter = new SendMeRecyclerAdapter(things, getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_sendme, container, false);
//        initView(root);
        return root;
    }

    private void initView(View v) {
        headerView = ((LinearLayout) root.findViewById(R.id.sendme_header));
        recyclerView = (SuperRecyclerView) v.findViewById(R.id.sendme_recyclerview);
        sendme_fl_wyjj= (FrameLayout) v.findViewById(R.id.sendme_fl_wyjj);
        sendme_fl_wyjj.setOnClickListener(this);
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
                    SendMeFragment.this.getView().startAnimation(getAlphaAnimation());
                    initView(root);
                    headerView.setVisibility(View.VISIBLE);
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

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.sendme_fl_wyjj:
                startActivity(new Intent(this.getActivity(),WantSendActivity.class));
                break;
        }
    }
}
