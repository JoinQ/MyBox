package com.box.box.customer.me.function;

import android.app.ActionBar;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.box.app.BoxActivity;
import com.box.box.R;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class EditInformationActivity extends BoxActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private Button edit_information_gender_man;
    private Button edit_information_gender_women;
    private FrameLayout edit_information_fl_birthday;

    private TextView edit_information_tv_birthday;

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
        edit_information_fl_birthday = (FrameLayout) findViewById(R.id.edit_information_fl_birthday);

        edit_information_gender_man.setOnClickListener(this);
        edit_information_gender_women.setOnClickListener(this);
        edit_information_fl_birthday.setOnClickListener(this);
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

            case R.id.edit_information_fl_birthday:
                Calendar calendar = Calendar.getInstance(Locale.CHINA);
                Date myDate = new Date();
                calendar.setTime(myDate);
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dlg = new DatePickerDialog(this, this, year, month, day);
                dlg.show();
                break;
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        edit_information_tv_birthday = (TextView) findViewById(R.id.edit_information_tv_birthday);
        edit_information_tv_birthday.setText(Integer.toString(year) + "-" +
                Integer.toString(monthOfYear) + "-" +
                Integer.toString(dayOfMonth));
    }
}
