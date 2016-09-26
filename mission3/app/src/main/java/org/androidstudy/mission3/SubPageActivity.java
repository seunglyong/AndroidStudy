package org.androidstudy.mission3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by yiseunglyong on 2016. 9. 24..
 */

public class SubPageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subpage);
        SetButtonEvent();
    }

    public void SetButtonEvent()
    {
        Button btnCustomerManage = (Button)findViewById(R.id.btn_customer_manage);
        btnCustomerManage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("resultValue","고객 관리");
                setResult(RESULT_OK,resultIntent);
                finish();
            }
        });

        Button btnIncomeManage = (Button)findViewById(R.id.btn_income_manage);
        btnIncomeManage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("resultValue","매출 관리");
                setResult(RESULT_OK,resultIntent);
                finish();
            }
        });

        Button btnProductManage = (Button)findViewById(R.id.btn_product_manage);
        btnProductManage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("resultValue","상품 관리");
                setResult(RESULT_OK,resultIntent);
                finish();
            }
        });


    }
}
