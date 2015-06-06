package com.box.box.courier;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.box.app.BoxActivity;
import com.box.box.R;
import com.box.box.courier.me.CourierMeFragment;
import com.box.box.courier.order.CourierOrderFragment;
import com.box.box.courier.search.CourierSearchFragment;
import com.box.launch.LoginActivity;
import com.box.view.Tab;
import com.umeng.update.UmengUpdateAgent;

public class CourierMainActivity extends BoxActivity implements View.OnClickListener {
    private FragmentManager mFm;
    private Fragment mFragment;
    private CourierOrderFragment mOrderFragment;
    private CourierSearchFragment mSearchFragment;
    private CourierMeFragment mMeFragmnet;

    private Tab tabOrder;
    private Tab tabSearch;
    private Tab tabMe;

    private static final int ORDER_ID = 1;
    private static final int SEARCH_ID = 2;
    private static final int ME_ID = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courier);
        initUmeng();
        initData();
        initView();

        mFragment = mOrderFragment;
        mFm.beginTransaction().add(R.id.container, mFragment, "order").commit();
    }

    private void initUmeng() {
        UmengUpdateAgent.update(this);
    }

    private void initData() {
        mFm = getSupportFragmentManager();
        mOrderFragment = new CourierOrderFragment();
        mSearchFragment = new CourierSearchFragment();
        mMeFragmnet = new CourierMeFragment();
    }

    private void initView() {
        tabOrder = (Tab) findViewById(R.id.tab_courier_order);
        tabSearch = (Tab) findViewById(R.id.tab_courier_search);
        tabMe = (Tab) findViewById(R.id.tab_courier_me);

        tabOrder.initTab(R.drawable.tab_courier_order, R.drawable.tab_courier_order_no, R.color.courierActionbarColor, R.color.tab_noselect, "发件名单");
        tabSearch.initTab(R.drawable.tab_courier_search, R.drawable.tab_courier_search_no, R.color.courierActionbarColor, R.color.tab_noselect, "附近寄件");
        tabMe.initTab(R.drawable.tab_courier_me, R.drawable.tab_courier_me_no, R.color.courierActionbarColor, R.color.tab_noselect, "个人中心");

        tabOrder.setViewSelect();
        tabSearch.setViewNoSelect();
        tabMe.setViewNoSelect();

        tabOrder.setOnClickListener(this);
        tabSearch.setOnClickListener(this);
        tabMe.setOnClickListener(this);

    }

    private void selectWhat(int selectTab) {
        switch (selectTab) {
            case ORDER_ID:
                if (mFragment != mOrderFragment) {
                    mFragment = mOrderFragment;
                    mFm.beginTransaction()
                            .replace(R.id.container, mFragment, "order").commit();
                }
                break;
            case SEARCH_ID:
                if (mFragment != mSearchFragment) {
                    mFragment = mSearchFragment;
                    mFm.beginTransaction()
                            .replace(R.id.container, mFragment, "search").commit();
                }
                break;
            case ME_ID:
                if (mFragment != mMeFragmnet) {
                    mFragment = mMeFragmnet;
                    mFm.beginTransaction()
                            .replace(R.id.container, mFragment, "cme").commit();
                }
                break;

            default:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab_courier_order:
                tabOrder.setViewSelect();
                tabSearch.setViewNoSelect();
                tabMe.setViewNoSelect();
                selectWhat(ORDER_ID);
                break;
            case R.id.tab_courier_search:
                tabOrder.setViewNoSelect();
                tabSearch.setViewSelect();
                tabMe.setViewNoSelect();
                selectWhat(SEARCH_ID);
                break;
            case R.id.tab_courier_me:
                tabOrder.setViewNoSelect();
                tabSearch.setViewNoSelect();
                tabMe.setViewSelect();
                selectWhat(ME_ID);
                break;

            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.user:
                //用户数据
                startActivity(new Intent(CourierMainActivity.this, LoginActivity.class));
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
