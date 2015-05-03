package com.box.box.customer.exress;

import android.app.ActionBar;
import android.content.res.AssetFileDescriptor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.box.app.BoxActivity;
import com.box.box.R;
import com.box.mode.ArrivedThing;
import com.box.mode.ExpressInfoThing;
import com.box.widget.ArriveRecyclerAdapter;
import com.box.widget.DividerItemDecoration;
import com.box.widget.ExpressInfoRecylerAdapter;

import java.util.List;

import cn.smssdk.statistics.NewAppReceiver;

public class ExpressInformationActivity extends BoxActivity {

    private RecyclerView express_info_rv_timeline;
    private RecyclerView.Adapter express_info_rv_timeline_Adapter;
    private RecyclerView.LayoutManager express_info_rv_timeline_Manager;
    private ExpressInfoRecylerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_express_information);

        ActionBar actionBar = this.getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("物流信息");

        init();
    }

    private void init() {
        ExpressInfoThing[] expressInfoThing = {new ExpressInfoThing(R.drawable.express_info_red, "已到达渝北XX小区XX栋XX柜5号", "2015-04-24  14：00"),
                new ExpressInfoThing(R.drawable.express_info_gray, "正在派件（派件人：陈先生，电话：12345678900）", "2015-04-24  9：00"),
                new ExpressInfoThing(R.drawable.express_info_gray, "快递已到达重庆分拨中心，等待派件中", "2015-04-23  14：00")};

        express_info_rv_timeline = (RecyclerView) findViewById(R.id.express_info_rv_timeline);
        express_info_rv_timeline.setHasFixedSize(true);

        express_info_rv_timeline_Manager = new LinearLayoutManager(ExpressInformationActivity.this);
        express_info_rv_timeline.setLayoutManager(express_info_rv_timeline_Manager);

        express_info_rv_timeline_Adapter = new ExpressInfoRecylerAdapter(expressInfoThing,R.layout.express_info_re_adapter);

        express_info_rv_timeline.addItemDecoration(new DividerItemDecoration(this));
        express_info_rv_timeline.setAdapter(express_info_rv_timeline_Adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: //对用户按home icon的处理，本例只需关闭activity，就可返回上一activity，即主activity。
                finish();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
