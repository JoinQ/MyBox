package com.box.box.customer.market;

import android.app.ActionBar;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.box.box.R;
import com.box.mode.MarketThing;
import com.box.util.Utils;
import com.box.widget.MarketRecyclerAdapter;
import com.box.widget.BaseRecyclerAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jude.view.jpagerview.JPagerAdapter;
import com.jude.view.jpagerview.JPagerView;
import com.malinskiy.superrecyclerview.OnMoreListener;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MarketFragment extends Fragment {
    private JPagerView jPagerView;
    private SuperRecyclerView recyclerView;

    private MarketRecyclerAdapter adapter;
    private List<Uri> listHeader = new ArrayList<Uri>();
    private List<MarketThing> listContent = new ArrayList<MarketThing>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listHeader.add(Uri.parse("http://g.hiphotos.baidu.com/image/pic/item/35a85edf8db1cb135fb18e0cdf54564e93584bd0.jpg"));
        listHeader.add(Uri.parse("http://gb.cri.cn/mmsource/images/2004/12/16/el041216108.jpg"));
        listHeader.add(Uri.parse("http://img.17611.com/tu/src/199/51e49fd238a18.jpg"));
        for (int i = 0; i < 3; i++) {
            listContent.add(new MarketThing("水果", "http://img3.imgtn.bdimg.com/it/u=3512762600,2004724643&fm=21&gp=0.jpg"));
            listContent.add(new MarketThing("海鲜", "http://pic1.nipic.com/2008-12-15/20081215912624_2.jpg"));
            listContent.add(new MarketThing("衣服", "http://img3.imgtn.bdimg.com/it/u=2994269798,1858998173&fm=21&gp=0.jpg"));
        }

        adapter = new MarketRecyclerAdapter(listContent, getActivity());

        ActionBar actionBar = getActivity().getActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setTitle("购物市场");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_market, container, false);

        initView(root);
        return root;
    }

    private void initView(View root) {
        jPagerView = (JPagerView) root.findViewById(R.id.maket_jpager);
        recyclerView = (SuperRecyclerView) root.findViewById(R.id.maket_recyclerview);

        jPagerView.setAdapter(new MyJpageAdapter(listHeader, getActivity()));
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyclerView.hideProgress();
        recyclerView.setAdapter(adapter);

        final List<MarketThing> list = new ArrayList<MarketThing>();
        list.add(new MarketThing("水果", "http://img3.imgtn.bdimg.com/it/u=3512762600,2004724643&fm=21&gp=0.jpg"));
        list.add(new MarketThing("海鲜", "http://pic1.nipic.com/2008-12-15/20081215912624_2.jpg"));
        list.add(new MarketThing("衣服", "http://img3.imgtn.bdimg.com/it/u=2994269798,1858998173&fm=21&gp=0.jpg"));

        recyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                adapter.clear();
                adapter.add(listContent);
                Utils.Toast("刷新le");
            }
        });

        recyclerView.setOnMoreListener(new OnMoreListener() {
            @Override
            public void onMoreAsked(int i, int i1, int i2) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapter.add(list);
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        listContent.clear();
        listHeader.clear();
    }
}

class MyJpageAdapter extends JPagerAdapter {
    private Context context;
    private List<Uri> list;

    public MyJpageAdapter(List<Uri> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public View getView(ViewGroup container, final int position) {
        SimpleDraweeView view = new SimpleDraweeView(container.getContext());
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view.setImageURI(list.get(position));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.Toast(position + "");
            }
        });
        return view;
    }


    @Override
    public int getCount() {
        if (list != null) {
            return list.size();
        } else {
            return 0;
        }
    }

}
