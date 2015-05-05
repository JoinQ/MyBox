package com.box.box.customer.exress.functionfragment.query;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.box.app.BoxActivity;
import com.box.box.R;
import com.box.mode.QueryInfoThing;
import com.box.view.DividerItemDecoration;
import com.box.widget.QueryInfoRecyclerAdapter;

public class QueryInfoActivity extends BoxActivity {

    private RecyclerView recyclerView;
    private QueryInfoRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queryinfo);

        ActionBar actionBar = this.getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setTitle("物流信息");
        init();
    }

    private void init() {
        QueryInfoThing[] queryInfoThing = {new QueryInfoThing(R.drawable.query_info_red, "已到达渝北XX小区XX栋XX柜5号", "2015-04-24  14：00"),
                new QueryInfoThing(R.drawable.query_info_gray, "正在派件（派件人：陈先生，电话：12345678900）", "2015-04-24  9：00"),
                new QueryInfoThing(R.drawable.query_info_gray, "快递已到达重庆分拨中心，等待派件中", "2015-04-23  14：00")};

        recyclerView = (RecyclerView) findViewById(R.id.express_info_rv_timeline);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(QueryInfoActivity.this));

        adapter = new QueryInfoRecyclerAdapter(queryInfoThing, this);

        recyclerView.addItemDecoration(new DividerItemDecoration(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}

