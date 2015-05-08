package com.box.box.customer.me;

import android.app.ActionBar;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.box.box.R;
import com.box.box.customer.me.function.ShareDialogFragment;
import com.box.util.Utils;

public class MeFragmnet extends Fragment implements View.OnClickListener{
	private LinearLayout sign;
	private LinearLayout myInfoBtn;
	private LinearLayout rewardBtn;
	private LinearLayout logisticsBtn;
	private LinearLayout appBtn;
	private LinearLayout rankBtn;
	private LinearLayout shareBtn;
	private LinearLayout fbBtn;
	private LinearLayout vipBtn;
	private LinearLayout setBtn;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar actionBar = getActivity().getActionBar();
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setTitle("个人中心");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_me, container, false);
		initView(root);
		return root;
	}

	private void initView(View root) {
		sign = (LinearLayout) root.findViewById(R.id.me_sign);
		myInfoBtn = (LinearLayout) root.findViewById(R.id.me_tab_myinfo);
		rewardBtn = (LinearLayout) root.findViewById(R.id.me_tab_reward);
		logisticsBtn = (LinearLayout) root.findViewById(R.id.me_tab_logistics);
		appBtn = (LinearLayout) root.findViewById(R.id.me_tab_application);
		rankBtn = (LinearLayout) root.findViewById(R.id.me_tab_rank);
		shareBtn = (LinearLayout) root.findViewById(R.id.me_tab_share);
		fbBtn = (LinearLayout) root.findViewById(R.id.me_tab_help);
		vipBtn = (LinearLayout) root.findViewById(R.id.me_tab_vip);
		setBtn = (LinearLayout) root.findViewById(R.id.me_tab_set);

		sign.setOnClickListener(this);
		myInfoBtn.setOnClickListener(this);
		rewardBtn.setOnClickListener(this);
		logisticsBtn.setOnClickListener(this);
		appBtn.setOnClickListener(this);
		rankBtn.setOnClickListener(this);
		shareBtn.setOnClickListener(this);
		fbBtn.setOnClickListener(this);
		vipBtn.setOnClickListener(this);
		setBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.me_sign:
				break;
			case R.id.me_tab_myinfo:
				break;
			case R.id.me_tab_reward:
				break;
			case R.id.me_tab_logistics:
				break;
			case R.id.me_tab_application:
				break;
			case R.id.me_tab_rank:
				break;
			case R.id.me_tab_share:
				Utils.Toast("share");
				new ShareDialogFragment().show(getActivity().getFragmentManager(), "share");
				break;
			case R.id.me_tab_help:
				break;
			case R.id.me_tab_vip:
				break;
			case R.id.me_tab_set:
				break;
		}
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}
}
