package org.androidstudy.mission1;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView m_ImageView1;
    private ImageView m_ImageView2;
    BitmapDrawable m_Bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m_ImageView1 = (ImageView) findViewById(R.id.imageView1);
        m_ImageView2 = (ImageView) findViewById(R.id.imageView2);


        Resources res = getResources();
        m_Bitmap = (BitmapDrawable) res.getDrawable(R.drawable.example);

        SetImage(m_Bitmap,m_ImageView1);

    }

    private void SetImage(BitmapDrawable imageToSet , ImageView imageView)
    {
        imageView.setImageDrawable(imageToSet);
        imageView.getLayoutParams().width = imageToSet.getIntrinsicWidth();
        imageView.getLayoutParams().height = imageToSet.getIntrinsicHeight();
    }

    public void btnUpButtonClicked(View view)
    {
        SetImage(m_Bitmap,m_ImageView1);
        m_ImageView2.setImageDrawable(null);
    }

    public void btnDownButtonClicked(View view)
    {
        m_ImageView1.setImageDrawable(null);
        SetImage(m_Bitmap,m_ImageView2);
    }

}
