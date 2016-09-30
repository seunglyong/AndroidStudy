package org.androidstudy.mission6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;
import static org.androidstudy.mission6.R.id.layoutURL;

public class MainActivity extends AppCompatActivity {

    public static String m_strURL = "http://www.naver.com";
    private WebView m_WebView;
    private boolean m_bURLExpanded = false;
    private Animation m_ShowAnimation;
    private Animation m_HideAnimation;
    private LinearLayout m_layoutURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m_layoutURL = (LinearLayout)findViewById(R.id.layoutURL);
        EditText tbURL =(EditText)findViewById(R.id.tbURL);
        tbURL.setText(m_strURL);
        m_ShowAnimation = AnimationUtils.loadAnimation(this,R.anim.show_animation);
        m_ShowAnimation.setAnimationListener(new ShowHideAnimationEndListener());
        m_HideAnimation = AnimationUtils.loadAnimation(this,R.anim.hide_animation);
        m_HideAnimation.setAnimationListener(new ShowHideAnimationEndListener());
        InitWebView();

    }

    public void btnExpandClicked(View view)
    {
        m_bURLExpanded = !m_bURLExpanded;
        ImageButton imageButton = (ImageButton)view;

        if(m_bURLExpanded)
            imageButton.setImageResource(R.drawable.arrow_up);
        else
            imageButton.setImageResource(R.drawable.arrow_down);

        PerformExpandAction(m_bURLExpanded);
    }

    private void PerformExpandAction(boolean bVisible)
    {
        if(bVisible)
            m_layoutURL.startAnimation(m_ShowAnimation);
        else
            m_layoutURL.startAnimation(m_HideAnimation);
    }

    private void InitWebView()
    {
        m_WebView = (WebView)findViewById(R.id.webView);
        m_WebView.getSettings().setJavaScriptEnabled(true);
        m_WebView.setWebViewClient(new WebViewClient());
        m_WebView.loadUrl(m_strURL);
    }

    public void LoadURLInWebView(String strURL)
    {
        m_WebView.loadUrl(strURL);
    }

    public void btnLoadClicked(View view)
    {
        EditText tbURL = (EditText)findViewById(R.id.tbURL);
        LoadURLInWebView(tbURL.getText().toString());
        PerformExpandAction(false);
    }

    private final class ShowHideAnimationEndListener implements Animation.AnimationListener
    {
        @Override
        public void onAnimationEnd(Animation animation) {
            if(animation.equals(m_ShowAnimation))
                m_layoutURL.setVisibility(View.VISIBLE);
            else
                m_layoutURL.setVisibility(View.GONE);
        }

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }

}
