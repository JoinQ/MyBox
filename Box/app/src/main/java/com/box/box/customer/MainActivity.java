package com.box.box.customer;

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
import com.box.box.customer.exress.ExpressFragmnet;
import com.box.box.customer.market.MarketFragment;
import com.box.box.customer.me.MeFragmnet;
import com.box.launch.LoginActivity;
import com.box.view.Tab;
import com.umeng.update.UmengUpdateAgent;

public class MainActivity extends BoxActivity implements View.OnClickListener {
    private FragmentManager mFm;
    private Fragment mFragment;
    private ExpressFragmnet mExpressFragment;
    private MarketFragment mMarketFragment;
    private MeFragmnet mMeFragmnet;

    private Tab tabExpress;
    private Tab tabMarket;
    private Tab tabMe;

    private static final int EXPRESS_ID = 1;
    private static final int MARKET_ID = 2;
    private static final int ME_ID = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUmeng();
        initData();
        initView();

        mFragment = mExpressFragment;
        mFm.beginTransaction().add(R.id.container, mFragment, "express").commit();
    }

    private void initUmeng() {
        UmengUpdateAgent.update(this);
    }

    private void initData() {
        mFm = getSupportFragmentManager();
        mExpressFragment = new ExpressFragmnet();
        mMarketFragment = new MarketFragment();
        mMeFragmnet = new MeFragmnet();
    }

    private void initView() {
        tabExpress = (Tab) findViewById(R.id.tab_express);
        tabMarket = (Tab) findViewById(R.id.tab_maket);
        tabMe = (Tab) findViewById(R.id.tab_me);

        tabExpress.initTab(R.drawable.tab_express, R.drawable.tab_express_no, R.color.actionbarColor, R.color.tab_noselect, "我的快递");
        tabMarket.initTab(R.drawable.tab_market, R.drawable.tab_market_no, R.color.actionbarColor, R.color.tab_noselect, "购物市场");
        tabMe.initTab(R.drawable.tab_me, R.drawable.tab_me_no, R.color.actionbarColor, R.color.tab_noselect, "个人中心");

        tabExpress.setViewSelect();
        tabMarket.setViewNoSelect();
        tabMe.setViewNoSelect();

        tabExpress.setOnClickListener(this);
        tabMarket.setOnClickListener(this);
        tabMe.setOnClickListener(this);

    }

    private void selectWhat(int selectTab) {
        switch (selectTab) {
            case EXPRESS_ID:
                if (mFragment != mExpressFragment) {
                    mFragment = mExpressFragment;
                    mFm.beginTransaction()
                            .replace(R.id.container, mFragment, "express").commit();
                }
                break;
            case MARKET_ID:
                if (mFragment != mMarketFragment) {
                    mFragment = mMarketFragment;
                    mFm.beginTransaction()
                            .replace(R.id.container, mFragment, "market").commit();
                }
                break;
            case ME_ID:
                if (mFragment != mMeFragmnet) {
                    mFragment = mMeFragmnet;
                    mFm.beginTransaction()
                            .replace(R.id.container, mFragment, "me").commit();
                }
                break;

            default:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab_express:
                tabExpress.setViewSelect();
                tabMarket.setViewNoSelect();
                tabMe.setViewNoSelect();
                selectWhat(EXPRESS_ID);
                break;
            case R.id.tab_maket:
                tabExpress.setViewNoSelect();
                tabMarket.setViewSelect();
                tabMe.setViewNoSelect();
                selectWhat(MARKET_ID);
                break;
            case R.id.tab_me:
                tabExpress.setViewNoSelect();
                tabMarket.setViewNoSelect();
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
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
