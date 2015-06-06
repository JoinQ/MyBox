package com.box.box.courier.order;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.box.app.BoxActivity;
import com.box.box.R;
import com.box.mode.OrderInfoThing;
import com.box.mode.QueryingGThing;
import com.box.mode.QueryingSThing;
import com.box.mode.Things;
import com.box.util.Utils;
import com.box.widget.BaseRecyclerAdapter;
import com.box.widget.CourierOrderInfoRecyclerAdapter;
import com.box.widget.QueryRecyclerAdapter;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CourierOrderInfoActivity extends BoxActivity implements TextWatcher{
    private SuperRecyclerView recyclerView;
    private EditText searchEdit;

    private CourierOrderInfoRecyclerAdapter adapter;
    private OrderInfoThing[] orderInfoThings = new OrderInfoThing[]{new OrderInfoThing("15栋7号柜子", "23131231"), new OrderInfoThing("15栋6号柜子", "23131231"), new OrderInfoThing("13栋7号柜子", "52313131")};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setTitle("订单列表");
        setContentView(R.layout.activity_courier_order_info);
        adapter = new CourierOrderInfoRecyclerAdapter(orderInfoThings, this);
        initView();
    }

    private void initView() {
        recyclerView = (SuperRecyclerView) findViewById(R.id.courier_orderinfo_recyclerview);
        searchEdit = (EditText) findViewById(R.id.courier_orderinfo_edit);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.hideProgress();
        recyclerView.hideMoreProgress();
        recyclerView.setAdapter(adapter);
        recyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                adapter.clear();
                adapter.add(orderInfoThings);
                Utils.Toast("刷新le");
            }
        });

        adapter.setOnRecyclerOnClickListener(new BaseRecyclerAdapter.OnRecyclerItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent();
                intent.setClass(CourierOrderInfoActivity.this, CourierOrderSendInfoActivity.class);
                startActivity(intent);
            }
        });

        searchEdit.addTextChangedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_courier_order_info, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_finish:
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
            List<OrderInfoThing> listOrderInfo = new ArrayList<OrderInfoThing>();
            for (OrderInfoThing orderInfoThing : orderInfoThings) {
                if (orderInfoThing.getNumber().indexOf(str) != -1) {
                    listOrderInfo.add(orderInfoThing);
                }
            }
            adapter.clear();
            adapter.add(listOrderInfo);
        } else {
            adapter.clear();
            adapter.add(orderInfoThings);
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
