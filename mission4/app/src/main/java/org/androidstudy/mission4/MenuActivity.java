package org.androidstudy.mission4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import static org.androidstudy.mission4.MainActivity.CUSTOMER_ACTIVITY;
import static org.androidstudy.mission4.MainActivity.INCOME_ACTIVITY;
import static org.androidstudy.mission4.MainActivity.PRODUCT_ACTIVITY;

/**
 * Created by yiseunglyong on 2016. 9. 29..
 */

public class MenuActivity extends Activity {

    private static Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void btnCustomerClicked(View view)
    {
        if(intent == null) {
            intent = new Intent(getApplicationContext(), SubActivity.class);
            intent.putExtra("requestCode", CUSTOMER_ACTIVITY);
            startActivityForResult(intent, CUSTOMER_ACTIVITY);
        }
        else
        {
            intent.putExtra("requestCode",CUSTOMER_ACTIVITY);
            startActivityForResult(intent, CUSTOMER_ACTIVITY);
        }

    }
    public void btnIncomeClicked(View view)
    {
        if(intent == null) {
            intent = new Intent(getApplicationContext(), SubActivity.class);
            startActivityForResult(intent, INCOME_ACTIVITY);
        }
        else
        {
            intent.putExtra("requestCode",INCOME_ACTIVITY);
            startActivityForResult(intent, INCOME_ACTIVITY);
        }

    }
    public void btnProductClicked(View view)
    {
        if(intent == null) {
            intent = new Intent(getApplicationContext(), SubActivity.class);
            startActivityForResult(intent, PRODUCT_ACTIVITY);
        }
        else
        {
            intent.putExtra("requestCode",PRODUCT_ACTIVITY);
            startActivityForResult(intent, PRODUCT_ACTIVITY);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }
}
