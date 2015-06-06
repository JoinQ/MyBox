package com.box.box.customer.me.function;

import android.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.box.app.BoxActivity;
import com.box.box.R;
import com.box.util.Utils;

public class EditInformationActivity extends BoxActivity implements View.OnClickListener {

    private Button edit_information_gender_man;
    private Button edit_information_gender_women;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_information);

        ActionBar actionBar = this.getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setTitle("编辑个人信息");

        init();
    }

    private void init() {
        edit_information_gender_man = (Button) findViewById(R.id.edit_information_gender_man);
        edit_information_gender_women = (Button) findViewById(R.id.edit_information_gender_women);

        edit_information_gender_man.setOnClickListener(this);
        edit_information_gender_women.setOnClickListener(this);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.edit_information_gender_man:
                edit_information_gender_women.setBackgroundResource(R.drawable.want_send_button_shape_on);
                edit_information_gender_man.setTextColor(this.getResources().getColor(R.color.want_send_button_on));

                edit_information_gender_women.setBackgroundResource(R.drawable.want_send_button_shape_off);
                edit_information_gender_women.setTextColor(this.getResources().getColor(R.color.want_send_button_off));
                break;

            case R.id.edit_information_gender_women:
                edit_information_gender_women.setBackgroundResource(R.drawable.want_send_button_shape_on);
                edit_information_gender_women.setTextColor(this.getResources().getColor(R.color.want_send_button_on));

                edit_information_gender_man.setBackgroundResource(R.drawable.want_send_button_shape_off);
                edit_information_gender_man.setTextColor(this.getResources().getColor(R.color.want_send_button_off));
                break;
        }
    }
}
