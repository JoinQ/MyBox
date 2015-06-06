package com.box.box.courier.search;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.box.app.BoxActivity;
import com.box.box.R;
import com.box.mode.OrderInfoThing;
import com.box.mode.SearchInfoThing;
import com.box.util.Utils;
import com.box.widget.BaseRecyclerAdapter;
import com.box.widget.CourierSearchInfoRecyclerAdapter;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CourierSearchInfoActivity extends BoxActivity implements TextWatcher {
    private SuperRecyclerView recyclerView;
    private EditText searchEdit;

    private CourierSearchInfoRecyclerAdapter adapter;
    private SearchInfoThing[] searchInfoThings = {new SearchInfoThing("牛逼", "尽无言", "123132"), new SearchInfoThing("呵呵呵", "尽无", "123132412"), new SearchInfoThing("呵呵呵", "尽", "12313412")};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setTitle("订单列表");
        setContentView(R.layout.activity_courier_search_info);
        adapter = new CourierSearchInfoRecyclerAdapter(searchInfoThings, this);
        initView();
    }

    private void initView() {
        recyclerView = (SuperRecyclerView) findViewById(R.id.courier_searchinfo_recyclerview);
        searchEdit = (EditText) findViewById(R.id.courier_searchinfo_edit);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.hideProgress();
        recyclerView.hideMoreProgress();
        recyclerView.setAdapter(adapter);
        recyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                adapter.clear();
                adapter.add(searchInfoThings);
                Utils.Toast("刷新le");
            }
        });

        adapter.setOnRecyclerOnClickListener(new BaseRecyclerAdapter.OnRecyclerItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent();
                intent.setClass(CourierSearchInfoActivity.this, CourierSearchSendInfoActivity.class);
                startActivity(intent);
            }
        });

        searchEdit.addTextChangedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_courier_search_info, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_notice:
                finish();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        String str = searchEdit.getText().toString().trim();
        if (!str.equals("")) {
            List<SearchInfoThing> listSearchInfo = new ArrayList<SearchInfoThing>();
            for (SearchInfoThing searchInfoThing : searchInfoThings) {
                if (searchInfoThing.getPhone().indexOf(str) != -1 || searchInfoThing.getName().indexOf(str) != -1) {
                    listSearchInfo.add(searchInfoThing);
                }
            }
            adapter.clear();
            adapter.add(listSearchInfo);
        } else {
            adapter.clear();
            adapter.add(searchInfoThings);
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
