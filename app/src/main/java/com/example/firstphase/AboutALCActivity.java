package com.example.firstphase;

        import android.net.http.SslError;
        import android.os.Bundle;
        import android.support.design.widget.FloatingActionButton;
        import android.support.design.widget.Snackbar;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.View;
        import android.webkit.SslErrorHandler;
        import android.webkit.WebSettings;
        import android.webkit.WebView;
        import android.webkit.WebViewClient;

public class AboutALCActivity extends AppCompatActivity {

    private WebView wv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        wv1 = (WebView) findViewById((R.id.web_about));
//        wv1.setWebViewClient(new WebViewClient());
//        wv1.loadUrl("https://andela.com/alc/");
        WebSettings webSettings = wv1.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wv1.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);

                return true;
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed(); // Ignore SSL certificate errors
            }
        });

        wv1.loadUrl("https://andela.com/alc/");
    }
}
//    @Override
//    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
//        handler.proceed(); // Ignore SSL certificate errors
//    }

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//    }
//    public void onBackPressed() {
//        if (wv1.canGoBack()) {
//            wv1.goBack();
//        } else {
//            super.onBackPressed();
//        }
//    }

