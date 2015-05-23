package com.box.box.customer.exress.functionfragment.arrive;

import android.app.ActionBar;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.box.box.R;
import com.box.util.Utils;
import com.box.view.CustomNestRadioGroup;

public class CommentDialogFragment extends DialogFragment implements View.OnClickListener, CustomNestRadioGroup.OnCheckedChangeListener{
    private CustomNestRadioGroup radioGroup;
    private TextView closeBtn;
    @Override
    public void onResume() {
        super.onResume();
        getDialog().getWindow().setLayout(Utils.getScreenWidth() - Utils.dip2px(24), ActionBar.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_TITLE, 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.dialog_comment, container, false);
        initView(root);
        return root;
    }

    private void initView(View root) {
        radioGroup = (CustomNestRadioGroup) root.findViewById(R.id.dialog_comment_customradiogroup);
        closeBtn = (TextView) root.findViewById(R.id.dialog_comment_close);

        radioGroup.setOnCheckedChangeListener(this);
        closeBtn.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(CustomNestRadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.dialog_comment_fullest:
                Utils.Toast("非常好");
                break;
            case R.id.dialog_comment_full:
                Utils.Toast("好");
                break;
            case R.id.dialog_comment_just:
                Utils.Toast("一般");
                break;
            case R.id.dialog_comment_poor:
                Utils.Toast("差");
                break;
            case R.id.dialog_comment_poorest:
                Utils.Toast("非常差");
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_comment_close:
                dismiss();
                break;
        }
    }
}