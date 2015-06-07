package com.box.box.courier.me.function;

import android.app.ActionBar;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.box.app.BoxActivity;
import com.box.box.R;
import com.box.util.Utils;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CourierMyInformationActivity extends BoxActivity implements View.OnClickListener,DatePickerDialog.OnDateSetListener {
    private MenuItem edit;
    private MenuItem confirm;

    private EditText information_ed_name;
    private EditText information_ed_phone;
    private EditText information_ed_hometown;
    private EditText information_ed_nowplace;
    private EditText information_ed_code;
    private EditText information_ed_birthday;
    private EditText information_ed_gender;
    private EditText information_ed_email;

    private LinearLayout information_ll_gender;

    private Button edit_information_gender_man;
    private Button edit_information_gender_women;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_information);
        ActionBar actionBar = this.getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setTitle("个人信息");

        init();
    }

    private void init() {
        information_ed_name = (EditText) findViewById(R.id.information_ed_name);
        information_ed_phone = (EditText) findViewById(R.id.information_ed_phone);
        information_ed_hometown = (EditText) findViewById(R.id.information_ed_hometown);
        information_ed_nowplace = (EditText) findViewById(R.id.information_ed_nowplace);
        information_ed_code = (EditText) findViewById(R.id.information_ed_code);
        information_ed_birthday = (EditText) findViewById(R.id.information_ed_birthday);
        information_ed_gender = (EditText) findViewById(R.id.information_ed_gender);
        information_ed_email = (EditText) findViewById(R.id.information_ed_email);

        information_ll_gender = (LinearLayout) findViewById(R.id.information_ll_gender);


        edit_information_gender_man = (Button) findViewById(R.id.edit_information_gender_man);
        edit_information_gender_women = (Button) findViewById(R.id.edit_information_gender_women);
        edit_information_gender_man.setOnClickListener(this);
        edit_information_gender_women.setOnClickListener(this);
    }


    private void editInfo() {
        confirm.setVisible(true);
        edit.setVisible(false);

        information_ed_name.setFocusable(true);
        information_ed_name.setFocusableInTouchMode(true);
        information_ed_phone.setFocusable(true);
        information_ed_phone.setFocusableInTouchMode(true);
        information_ed_hometown.setFocusable(true);
        information_ed_hometown.setFocusableInTouchMode(true);
        information_ed_nowplace.setFocusable(true);
        information_ed_nowplace.setFocusableInTouchMode(true);
        information_ed_code.setFocusable(true);
        information_ed_code.setFocusableInTouchMode(true);
        information_ed_email.setFocusable(true);
        information_ed_email.setFocusableInTouchMode(true);

        information_ed_gender.setVisibility(View.GONE);
        information_ll_gender.setVisibility(View.VISIBLE);

        information_ed_birthday.setOnClickListener(this);
    }

    private void confirmInfo() {
        confirm.setVisible(false);
        edit.setVisible(true);

        information_ed_name.setFocusable(false);
        information_ed_name.setFocusableInTouchMode(false);
        information_ed_phone.setFocusable(false);
        information_ed_phone.setFocusableInTouchMode(false);
        information_ed_hometown.setFocusable(false);
        information_ed_hometown.setFocusableInTouchMode(false);
        information_ed_nowplace.setFocusable(false);
        information_ed_nowplace.setFocusableInTouchMode(false);
        information_ed_code.setFocusable(false);
        information_ed_code.setFocusableInTouchMode(false);
        information_ed_email.setFocusable(false);
        information_ed_email.setFocusableInTouchMode(false);

        information_ed_gender.setVisibility(View.VISIBLE);
        information_ll_gender.setVisibility(View.GONE);

        information_ed_birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_editting:
                Utils.Toast("编辑");
                editInfo();
                break;
            case R.id.action_confirm:
                Utils.Toast("确定");
                confirmInfo();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_my_information, menu);
        edit = menu.findItem(R.id.action_editting);
        confirm = menu.findItem(R.id.action_confirm);
        confirm.setVisible(false);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.edit_information_gender_man:
                edit_information_gender_man.setBackgroundResource(R.drawable.want_send_button_shape_on);
                edit_information_gender_man.setTextColor(this.getResources().getColor(R.color.want_send_button_on));

                edit_information_gender_women.setBackgroundResource(R.drawable.want_send_button_shape_off);
                edit_information_gender_women.setTextColor(this.getResources().getColor(R.color.want_send_button_off));

                information_ed_gender.setText("男");
                break;

            case R.id.edit_information_gender_women:
                edit_information_gender_women.setBackgroundResource(R.drawable.want_send_button_shape_on);
                edit_information_gender_women.setTextColor(this.getResources().getColor(R.color.want_send_button_on));

                edit_information_gender_man.setBackgroundResource(R.drawable.want_send_button_shape_off);
                edit_information_gender_man.setTextColor(this.getResources().getColor(R.color.want_send_button_off));

                information_ed_gender.setText("女");
                break;

            case R.id.information_ed_birthday:
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
        information_ed_birthday.setText(Integer.toString(year) + "-" +
                Integer.toString(monthOfYear) + "-" +
                Integer.toString(dayOfMonth));
    }
}
