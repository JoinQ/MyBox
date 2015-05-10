package com.box.box.courier.order;

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
import com.box.box.courier.order.functionfragment.current.CourierCurrentFragment;
import com.box.box.courier.order.functionfragment.history.CourierHistoryFragment;
import com.box.util.Utils;


public class CourierOrderFragment extends Fragment implements View.OnClickListener{
	private FragmentManager fm;
	private CourierCurrentFragment currentFragment;
	private CourierHistoryFragment historyFragment;

	private TextView mCurrentText;
	private TextView mHistoryText;

	private ImageView mSlider;
	private ViewPager mVp;

	private static final String CURRENT_ID = "0";
	private static final String HISTORY_ID = "1";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar actionBar = getActivity().getActionBar();
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setTitle("寄件名单");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_courier_order, container, false);
		initFragment();
		initView(root);
		setListener();
		return root;
	}

	private void initFragment() {
		fm = getActivity().getSupportFragmentManager();
		currentFragment = new CourierCurrentFragment();
		historyFragment = new CourierHistoryFragment();

		fm.beginTransaction().add(currentFragment, CURRENT_ID).commit();
		fm.beginTransaction().add(historyFragment, HISTORY_ID).commit();
	}

	private void initView(View root) {
		mCurrentText = (TextView) root.findViewById(R.id.courier_tobtab_current);
		mHistoryText = (TextView) root.findViewById(R.id.courier_tobtab_history);
		mSlider = (ImageView) root.findViewById(R.id.courier_slider);
		mVp = (ViewPager) root.findViewById(R.id.courier_viewpager);

		mSlider.setLayoutParams(new LinearLayout.LayoutParams(Utils.getScreenWidth() / 2, ViewGroup.LayoutParams.MATCH_PARENT));
		mVp.setOffscreenPageLimit(2);
		mVp.setAdapter(new VpAdapter(fm));
	}

	private void setListener() {
		mCurrentText.setOnClickListener(this);
		mHistoryText.setOnClickListener(this);

		mVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
				mSlider.setX((position + positionOffset) * Utils.getScreenWidth() / 2);

				switch (position) {
					case 0:
						fm.findFragmentByTag(position + "").getView().setAlpha(1 - Math.abs(positionOffset));
						fm.findFragmentByTag(position + 1 + "").getView().setAlpha(Math.abs(positionOffset));
						break;
					case 1:
						fm.findFragmentByTag(position + "").getView().setAlpha(1 - Math.abs(positionOffset));
						fm.findFragmentByTag(position - 1 + "").getView().setAlpha(Math.abs(positionOffset));
						break;

					default:
						break;
				}
			}

			@Override
			public void onPageSelected(int position) {
				mCurrentText.setTextColor(getResources().getColor(R.color.toptabtext_release));
				mHistoryText.setTextColor(getResources().getColor(R.color.toptabtext_release));

				switch (position) {
					case 0:
						mCurrentText.setTextColor(getResources().getColor(R.color.toptabtext_active));
						break;
					case 1:
						historyFragment.setLayout();
						mHistoryText.setTextColor(getResources().getColor(R.color.toptabtext_active));
						break;
				}
			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.courier_tobtab_current:
				mVp.setCurrentItem(0);
				break;
			case R.id.courier_tobtab_history:
				mVp.setCurrentItem(1);
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
			return 2;
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
