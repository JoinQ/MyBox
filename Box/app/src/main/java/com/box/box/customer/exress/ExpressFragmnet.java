package com.box.box.customer.exress;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.box.box.R;
import com.box.box.customer.exress.functionfragment.arrive.ArrivedFragment;
import com.box.box.customer.exress.functionfragment.query.QueryFragment;
import com.box.box.customer.exress.functionfragment.sendme.SendMeFragment;
import com.box.util.Utils;

public class ExpressFragmnet extends Fragment implements View.OnClickListener {
    private FragmentManager fm;
    private ArrivedFragment mArrivedFragment;
    private QueryFragment mQueryFragment;
    private SendMeFragment mSendMeFragment;

    private TextView mArrivedText;
    private TextView mSendMeText;
    private TextView mQueryText;

    private ImageView mSlider;
    private ViewPager mVp;

    private static final String ARRIVED_ID = "0";
    private static final String SEND_ID = "1";
    private static final String QUERY_ID = "2";

    private int tab_i = 0;
    private boolean tab_p;

    public ExpressFragmnet() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getActivity().getActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setTitle("我的快递");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_express, container, false);

        initFragment();
        initView(root);
        setListener();
        return root;
    }

    private void initFragment() {
        fm = getActivity().getSupportFragmentManager();
        mArrivedFragment = new ArrivedFragment();
        mQueryFragment = new QueryFragment();
        mSendMeFragment = new SendMeFragment();

        fm.beginTransaction().add(mArrivedFragment, ARRIVED_ID).commit();
        fm.beginTransaction().add(mSendMeFragment, SEND_ID).commit();
        fm.beginTransaction().add(mQueryFragment, QUERY_ID).commit();
    }

    private void initView(View v) {
        mArrivedText = (TextView) v.findViewById(R.id.tobtab_arrived);
        mSendMeText = (TextView) v.findViewById(R.id.tobtab_mysend);
        mQueryText = (TextView) v.findViewById(R.id.tobtab_query);
        mSlider = (ImageView) v.findViewById(R.id.slider);
        mVp = (ViewPager) v.findViewById(R.id.viewPager);
        mSlider.setLayoutParams(new LinearLayout.LayoutParams(Utils.getScreenWidth() / 3, ViewGroup.LayoutParams.MATCH_PARENT));
        mVp.setOffscreenPageLimit(3);
        mVp.setAdapter(new VpAdapter(fm));
    }

    private void setListener() {
        mArrivedText.setOnClickListener(this);
        mSendMeText.setOnClickListener(this);
        mQueryText.setOnClickListener(this);

        mVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mSlider.setX((position + positionOffset) * Utils.getScreenWidth() / 3);

                fm.findFragmentByTag(position + "").getView();
                if (positionOffsetPixels == 0) {
                    tab_p = false;
                }

                switch (position) {
                    case 0:
                        fm.findFragmentByTag(position + "").getView().setAlpha(1 - Math.abs(positionOffset));
                        fm.findFragmentByTag(position + 1 + "").getView().setAlpha(Math.abs(positionOffset));
                        break;
                    case 1:
                        if (tab_i < positionOffsetPixels || tab_p) {
                            fm.findFragmentByTag(position + "").getView().setAlpha(1 - Math.abs(positionOffset));
                            fm.findFragmentByTag(position + 1 + "").getView().setAlpha(Math.abs(positionOffset));
                            tab_p = true;
                        } else {
                            fm.findFragmentByTag(position + "").getView().setAlpha(1 - Math.abs(positionOffset));
                            fm.findFragmentByTag(position - 1 + "").getView().setAlpha(Math.abs(positionOffset));
                        }
                        break;
                    case 2:
                        fm.findFragmentByTag(position + "").getView().setAlpha(1 - Math.abs(positionOffset));
                        fm.findFragmentByTag(position - 1 + "").getView().setAlpha(Math.abs(positionOffset));
                        break;

                    default:
                        break;
                }
                tab_i = positionOffsetPixels;
            }

            @Override
            public void onPageSelected(int position) {
                mQueryText.setTextColor(getResources().getColor(R.color.toptabtext_release));
                mSendMeText.setTextColor(getResources().getColor(R.color.toptabtext_release));
                mArrivedText.setTextColor(getResources().getColor(R.color.toptabtext_release));

                switch (position) {
                    case 0:
                        mArrivedText.setTextColor(getResources().getColor(R.color.toptabtext_active));
                        break;
                    case 1:
                        mSendMeFragment.setLayout();
                        mSendMeText.setTextColor(getResources().getColor(R.color.toptabtext_active));
                        break;
                    case 2:
                        mQueryFragment.setLayout();
                        mQueryText.setTextColor(getResources().getColor(R.color.toptabtext_active));
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tobtab_arrived:
                mVp.setCurrentItem(0);
                break;
            case R.id.tobtab_mysend:
                mVp.setCurrentItem(1);
                break;
            case R.id.tobtab_query:
                mVp.setCurrentItem(2);
                break;
        }
    }

    class VpAdapter extends PagerAdapter {

        private FragmentManager fm;

        public VpAdapter(FragmentManager fm) {
            this.fm = fm;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(((Fragment) object).getView());
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((Fragment) object).getView();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Fragment fragment = fm.findFragmentByTag(position + "");
            container.addView(fragment.getView());
            return fragment;
        }
    }

}
