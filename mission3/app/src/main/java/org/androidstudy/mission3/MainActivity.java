package org.androidstudy.mission3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int REQ_SUB_PAGE_ACTIVITY = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void LoginButtonClicked(View view)
    {
        Intent SubPageIntent = new Intent(getApplicationContext(),SubPageActivity.class);
        startActivityForResult(SubPageIntent,REQ_SUB_PAGE_ACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQ_SUB_PAGE_ACTIVITY && resultCode == RESULT_OK)
        {
            String strResult = data.getExtras().getString("resultValue");
            Toast toast = Toast.makeText(getApplicationContext(),strResult + "버튼이 눌렸습니다.",Toast.LENGTH_LONG);
            toast.show();
        }

    }
}
