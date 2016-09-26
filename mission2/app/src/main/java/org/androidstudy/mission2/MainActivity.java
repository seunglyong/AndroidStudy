package org.androidstudy.mission2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText tbMessage = (EditText)findViewById(R.id.tbMessage);
        InputFilter.LengthFilter filter = new InputFilter.LengthFilter(80);
        tbMessage.setFilters(new InputFilter[]{filter});

        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                TextView tv = (TextView)findViewById(R.id.textBytes);
                int nLength = s.length();
                tv.setText( String.valueOf(nLength) + " / 80 바이트" );
            }
        };

        tbMessage.addTextChangedListener(watcher);

    }

    public void btnSendClicked(View view)
    {
        EditText tbMessage = (EditText)findViewById(R.id.tbMessage);
        String strMessage = tbMessage.getText().toString();

        Toast toast;
        if(strMessage.length() != 0)
        {
            toast = Toast.makeText(getApplicationContext(), strMessage,Toast.LENGTH_LONG);
        }
        else
        {
            toast = Toast.makeText(getApplicationContext(), "입력된 문자열이 없습니다",Toast.LENGTH_LONG);
        }

        toast.show();
    }
    public void btnCloseClicked(View view)
    {
        finish();
    }
}
