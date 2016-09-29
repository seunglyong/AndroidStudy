package org.androidstudy.mission5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static int PICKER_DIALOG = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void editBirthDayClicked(View view)
    {
        Intent intent = new Intent(getApplicationContext(),DatePickerActivity.class);
        startActivityForResult(intent,PICKER_DIALOG);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICKER_DIALOG && resultCode == RESULT_OK)
        {
            int nYear = (int)data.getExtras().get("year");
            int nMonth = (int)data.getExtras().get("month");
            int nDay = (int)data.getExtras().get("day");

            TextView tvBirth = (TextView)findViewById(R.id.tvBirth);
            tvBirth.setText(nYear + "년" + nMonth + "월" + nDay + "일");
        }
    }

    public void btnSaveClicked(View view)
    {
        TextView tvBirth = (TextView)findViewById(R.id.tvBirth);
        EditText etName = (EditText)findViewById(R.id.etName);
        EditText etAge = (EditText)findViewById(R.id.etAge);
        Toast toast = Toast.makeText(getApplicationContext(), etAge.getText().toString() +" 살 "+etName.getText().toString()+"님의 생일은"
                + tvBirth.getText().toString() + "입니다.", Toast.LENGTH_LONG);
        toast.show();

    }

}
