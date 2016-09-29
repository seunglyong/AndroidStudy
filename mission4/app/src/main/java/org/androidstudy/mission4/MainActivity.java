package org.androidstudy.mission4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int MAIN_ACTIVITY = 1000;
    public static final int MENU_ACTIVITY = 1001;

    public static final int CUSTOMER_ACTIVITY = 1002;
    public static final int INCOME_ACTIVITY = 1003;
    public static final int PRODUCT_ACTIVITY = 1004;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnLoginClicked(View view)
    {
        EditText tbId = (EditText)findViewById(R.id.tbId);
        EditText tbPassword = (EditText)findViewById(R.id.tbPassword);

        Toast toastMessage;
        if(tbId.getText().toString().equals("") ) {
            toastMessage = Toast.makeText(getApplicationContext(), "ID를 입력해 주십시오", Toast.LENGTH_LONG);
            toastMessage.show();
            return;
        }


        if(tbPassword.getText().toString().equals("")) {
            toastMessage = Toast.makeText(getApplicationContext(), "Password를 입력해 주십시오", Toast.LENGTH_LONG);
            toastMessage.show();
            return;
        }


        Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
        startActivityForResult(intent,MENU_ACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Toast toast = null;

        if(resultCode == RESULT_OK)
        {
            if(requestCode == MENU_ACTIVITY)
                toast = Toast.makeText(getApplicationContext(),"몌뉴 화면으로 부터 이동하였습니다.",Toast.LENGTH_LONG);
            else if(requestCode == CUSTOMER_ACTIVITY)
                toast = Toast.makeText(getApplicationContext(),"고객 관리 화면으로 부터 이동하였습니다.",Toast.LENGTH_LONG);
            else if(requestCode == INCOME_ACTIVITY)
                toast = Toast.makeText(getApplicationContext(),"매출 관리 화면으로 부터 이동하였습니다.",Toast.LENGTH_LONG);
            else if(requestCode == PRODUCT_ACTIVITY)
                toast = Toast.makeText(getApplicationContext(),"상품 관리 화면으로 부터 이동하였습니다.",Toast.LENGTH_LONG);
            else
                toast = null;

            if(toast != null)
                toast.show();
            return;
        }

    }
}
