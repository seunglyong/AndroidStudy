package org.androidstudy.mission5;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by yiseunglyong on 2016. 9. 30..
 */

public class DatePickerActivity extends Activity {

    private int m_nYear = 1983;
    private int m_nMonth = 11;
    private int m_nDay = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datepicker);


    }

    public void etDateClicked(View view)
    {
        EditText sender = (EditText)view;
        DatePickerDialog dialog = new DatePickerDialog(this, listener, m_nYear, m_nMonth, m_nDay);
        dialog.show();
    }

    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
        {
            m_nYear = year;
            m_nMonth = monthOfYear + 1;
            m_nDay = dayOfMonth;

            EditText yearEditText = (EditText)findViewById(R.id.etYear);
            EditText monthEditText = (EditText)findViewById(R.id.etMonth);
            EditText dayEditText = (EditText)findViewById(R.id.etDay);

            yearEditText.setText(String.valueOf(year));
            monthEditText.setText(String.valueOf(monthOfYear+1));
            dayEditText.setText(String.valueOf(dayOfMonth));
        }
    };

    public void btnSetDateClicked(View view)
    {
        Intent intent = new Intent();
        intent.putExtra("year",m_nYear);
        intent.putExtra("month",m_nMonth);
        intent.putExtra("day",m_nDay);

        setResult(RESULT_OK,intent);
        finish();
    }

    public void btnCloseClicked(View view) {
        finish();
    }
}

