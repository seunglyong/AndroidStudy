package org.androidstudy.mission4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static org.androidstudy.mission4.MainActivity.CUSTOMER_ACTIVITY;
import static org.androidstudy.mission4.MainActivity.INCOME_ACTIVITY;
import static org.androidstudy.mission4.MainActivity.PRODUCT_ACTIVITY;

/**
 * Created by yiseunglyong on 2016. 9. 29..
 */

public class SubActivity extends Activity {

    private int m_nCurrentLayoutType = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Bundle extras = getIntent().getExtras();
        //if (extras != null)
        m_nCurrentLayoutType = extras.getInt("requestCode", 0);

        UpdateLayout();
    }


    public void UpdateLayout()
    {

        String strTextViewContent = "";

        switch(m_nCurrentLayoutType)
        {
            case CUSTOMER_ACTIVITY: strTextViewContent = "고객 관리";break;
            case INCOME_ACTIVITY:strTextViewContent = "매출 관리";break;
            case PRODUCT_ACTIVITY:strTextViewContent = "상품 관리";break;
        }

        TextView tvTop = (TextView)findViewById(R.id.tbTopText);
        tvTop.setText(strTextViewContent);

    }

    public void btnCloseClicked(View view)
    {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("resultCode",m_nCurrentLayoutType);
        setResult(RESULT_OK,resultIntent);
        finish();
    }

}
