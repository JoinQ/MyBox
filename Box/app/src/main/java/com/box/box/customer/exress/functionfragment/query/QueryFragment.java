package com.box.box.customer.exress.functionfragment.query;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.box.box.R;
import com.box.mode.QueryingGThing;
import com.box.mode.QueryingSThing;
import com.box.mode.Things;
import com.box.util.Utils;
import com.box.widget.BaseRecyclerAdapter;
import com.box.widget.QueryRecyclerAdapter;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class QueryFragment extends Fragment implements TextWatcher {
    private SuperRecyclerView recyclerView;
    private EditText searchEdit;

    private Things<QueryingSThing, QueryingGThing> things;
    private QueryingSThing[] queryingSThing;
    private QueryingGThing[] queryingGThing;
    private QueryRecyclerAdapter adapter;
    private LinearLayout queryBg;

    private View root;
    private boolean isFirst = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        queryingSThing = new QueryingSThing[]{new QueryingSThing("3", R.drawable.coporation1, "顺风", "4352423423", "2015-5-1 6：00", "已到达渝北小区2栋3号柜", true),
                new QueryingSThing("3", R.drawable.coporation2, "中通", "0982014123", "2015-5-1 6:00", "已到达渝北小区1栋16号柜", false),
                new QueryingSThing("3", R.drawable.coporation2, "北通", "432423", "2015-5-1 6:00", "已到达渝北小区1栋16号柜", false)};

        queryingGThing = new QueryingGThing[]{new QueryingGThing("2", R.drawable.coporation1, "顺风", "1232131419", "2015-5-1 6：00", "已到达渝北小区2栋3号柜"),
                new QueryingGThing("2", R.drawable.coporation2, "中通", "214123123", "2015-5-1 6:00", "已到达渝北小区1栋16号柜")};
        things = new Things<QueryingSThing, QueryingGThing>(queryingSThing, queryingGThing);
        adapter = new QueryRecyclerAdapter(things, getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_query, container, false);
        return root;
    }

    private void initView(View v) {
        queryBg = (LinearLayout) v.findViewById(R.id.query_header);
        searchEdit = (EditText) v.findViewById(R.id.query_search_edit);
        recyclerView = (SuperRecyclerView) v.findViewById(R.id.query_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        recyclerView.hideProgress();
        recyclerView.hideMoreProgress();

        searchEdit.addTextChangedListener(this);

        recyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                adapter.clear();
                adapter.add(things);
                searchEdit.setText("");
                Utils.Toast("刷新");
            }
        });

        adapter.setOnRecyclerOnClickListener(new BaseRecyclerAdapter.OnRecyclerItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                startActivity(new Intent(getActivity(), QueryInfoActivity.class));
            }
        });
    }

    public void setLayout() {
        if (isFirst) {
            isFirst = false;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    QueryFragment.this.getView().startAnimation(getAlphaAnimation());
                    initView(root);
                    queryBg.setVisibility(View.VISIBLE);
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
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        String str = searchEdit.getText().toString().trim();
        if (!str.equals("")) {
            List<QueryingSThing> listQueryingS = new ArrayList<QueryingSThing>();
            List<QueryingGThing> listQueryingG = new ArrayList<QueryingGThing>();
            for (QueryingSThing queryingS : queryingSThing) {
                if (queryingS.getIdNumber().indexOf(str) != -1) {
                    listQueryingS.add(queryingS);
                }
            }
            for (QueryingGThing queryingG : queryingGThing) {
                if (queryingG.getIdNumber().indexOf(str) != -1) {
                    listQueryingG.add(queryingG);
                }
            }
            Things<QueryingSThing, QueryingGThing> things2 = new Things<QueryingSThing, QueryingGThing>((QueryingSThing[]) listQueryingS.toArray(new QueryingSThing[listQueryingS.size()]), (QueryingGThing[]) listQueryingG.toArray(new QueryingGThing[listQueryingG.size()]));
            adapter.clear();
            adapter = new QueryRecyclerAdapter(things2, getActivity());
            recyclerView.setAdapter(adapter);
        } else {
            adapter.clear();
            adapter = new QueryRecyclerAdapter(things, getActivity());
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
