package pl.sdacademy.web_view_example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private WebView browser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        browser = (WebView) findViewById(R.id.browser);
        initBrowser();
    }


    private void initBrowser() {
        Log.d(TAG, "Loading new page");
        browser.setWebViewClient(new WebViewClient());
        browser.loadUrl("http://www.onet.pl");
    }
}
