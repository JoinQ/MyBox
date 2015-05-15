package com.box.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.box.box.R;

public class Tab extends RelativeLayout {
	private ImageView mTabImageView;
	private TextView mTabTextView;
	private ImageView mTabDefaultImageView;
	private TextView mTabDefaultTextView;
	private LinearLayout mTabSelectll;
	private LinearLayout mTabDefaultSelectll;

	public Tab(Context context) {
		super(context);
		initView(context);
	}

	public Tab(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initView(context);
	}

	public Tab(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);
	}

	private void initView(Context context) {
		View view = LayoutInflater.from(context).inflate(R.layout.view_tab, this,
				false);
		mTabImageView = (ImageView) view.findViewById(R.id.tab_img);
		mTabTextView = (TextView) view.findViewById(R.id.tab_text);

		mTabDefaultImageView = (ImageView) view.findViewById(R.id.tab_img_default);
		mTabDefaultTextView = (TextView) view.findViewById(R.id.tab_text_default);

		mTabSelectll = (LinearLayout) view.findViewById(R.id.tab_ll);
		mTabDefaultSelectll = (LinearLayout) view.findViewById(R.id.tab_default_ll);
		addView(view);
	}

	public void initTab(int imgIdSelect, int imgIdNoSelect, int tab_select, int tab_noselect, String text) {
		mTabTextView.setText(text);
		mTabTextView.setTextColor(getResources().getColor(tab_select));
		mTabImageView.setImageResource(imgIdSelect);

		mTabDefaultTextView.setText(text);
		mTabDefaultTextView.setTextColor(getResources().getColor(tab_noselect));
		mTabDefaultImageView.setImageResource(imgIdNoSelect);
	}

	public void setViewSelect() {
		mTabSelectll.setVisibility(View.VISIBLE);
		mTabDefaultSelectll.setAlpha(0);
	}

	public void setViewNoSelect() {
		mTabSelectll.setVisibility(View.GONE);
		mTabDefaultSelectll.setAlpha(1);
	}

	public void setTabAlpha(float args) {
		mTabSelectll.setAlpha(args);
		mTabDefaultSelectll.setAlpha(1- args);
	}
}
