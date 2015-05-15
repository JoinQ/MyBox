package com.box.box.customer.me;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.box.box.R;
import com.box.box.customer.me.function.MyInformationActivity;
import com.box.box.customer.me.function.RankActivity;
import com.box.box.customer.me.function.ShareDialogFragment;
import com.box.mode.MeList;

import java.util.ArrayList;
import java.util.List;

public class MeFragmnet extends Fragment implements View.OnClickListener, ListView.OnItemClickListener {
    private ListView listView;

    private List<MeList> list = new ArrayList<MeList>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list.add(new MeList(R.drawable.me_info, "个人信息", true));
        list.add(new MeList(R.drawable.me_logistics, "我的物流", true));
        list.add(new MeList(R.drawable.me_application, "应用中心", false));
        list.add(new MeList(R.drawable.me_share, "向好友推荐", false));
        list.add(new MeList(R.drawable.me_rank, "排名", true));
        list.add(new MeList(R.drawable.me_set, "设置", false));
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
        listView = (ListView) root.findViewById(R.id.me_list);
        listView.setAdapter(new MyAdapter(list, getActivity()));
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0:
                startActivity(new Intent(MeFragmnet.this.getActivity(), MyInformationActivity.class));
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                new ShareDialogFragment().show(getActivity().getFragmentManager(), "share");
                break;
            case 4:
                startActivity(new Intent(MeFragmnet.this.getActivity(), RankActivity.class));
                break;
            case 5:
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (list != null) {
            list.clear();
        }
    }

    class MyAdapter extends BaseAdapter {
        private List<MeList> meList;
        private Context context;

        public MyAdapter(List<MeList> meList, Context context) {
            this.meList = meList;
            this.context = context;
        }

        @Override
        public int getCount() {
            return meList.size();
        }

        @Override
        public Object getItem(int position) {
            return meList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View rootView;
            ViewHolder viewHolder;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                rootView = LayoutInflater.from(context).inflate(R.layout.list_me_adapter, parent, false);
                viewHolder.mView = (View) rootView.findViewById(R.id.me_adapter_view);
                viewHolder.mNameText = (TextView) rootView.findViewById(R.id.me_adapter_name);
                viewHolder.mHeadImage = (ImageView) rootView.findViewById(R.id.me_adapter_icon);
                rootView.setTag(viewHolder);
            } else {
                rootView = convertView;
                viewHolder = (ViewHolder) rootView.getTag();
            }
            viewHolder.mNameText.setText(meList.get(position).getName());
            viewHolder.mHeadImage.setImageResource(meList.get(position).getImageId());
            if (!meList.get(position).getIsAppear()) {
                viewHolder.mView.setVisibility(View.GONE);
            }
            return rootView;
        }

        private class ViewHolder {
            private View mView;
            private TextView mNameText;
            private ImageView mHeadImage;
        }
    }
}
