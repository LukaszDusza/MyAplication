package lukaszdusza.pl.firstwebbrowser;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private WebView webView;
    private EditText urlField;
    private Button button;
    private String setUrl;
    private Button wstecz;
    private Button doPrzodu;
    private Button odswiez;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_relative_layout);


        urlField = (EditText) findViewById(R.id.urlField);
        webView = (WebView) findViewById(R.id.webView);
        button = (Button) findViewById(R.id.button);
        wstecz = (Button) findViewById(R.id.wstecz);
        doPrzodu = (Button) findViewById(R.id.doPrzodu);
        odswiez = (Button) findViewById(R.id.odswiez);


        wstecz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                webView.goBack();
            }
        });

        doPrzodu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.goForward();
            }
        });

        doPrzodu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.reload();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startBrowser();
            }
        });
    }

    public void startBrowser() {
        Log.d(TAG, "********* onClick **************");
            setUrl = ""+urlField.getText();
                webView.setWebViewClient(new WebViewClient() {

                    @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                urlField.setText(url);
            }
        });
        webView.loadUrl(setUrl.toString());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);



    }


}






