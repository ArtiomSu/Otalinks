package com.otalinksR2;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends AppCompatActivity {

    WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myWebView = (WebView) findViewById(R.id.webview);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("https://venkateswaran321.github.io/R2-ota");
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
//        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setSupportZoom(true);
        webSettings.setDefaultTextEncodingName("utf-8");
//        webview.getSettings().setAppCacheEnabled(false);
//        webview.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        myWebView.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String s1, String s2, String s3, long l) {
                Intent view = new Intent();
                view.setAction(Intent.ACTION_VIEW);
                view.setData(Uri.parse(url));
                startActivity(view);
            }
        });
    }

//    public void onclick(View view) {
//        setContentView(R.layout.activity_main);
//        WebView webview = findViewById(R.id.webview);
//        webview.setWebViewClient(new WebViewClient());
//        webview.getSettings().setAppCacheEnabled(false);
//        webview.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
//        webview.loadUrl("https://venkateswaran321.github.io/R2-ota");
//        WebSettings webSettings = webview.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        webSettings.setDomStorageEnabled(true);
//        webSettings.setLoadWithOverviewMode(true);
////        webSettings.setUseWideViewPort(true);
//        webSettings.setBuiltInZoomControls(true);
//        webSettings.setDisplayZoomControls(false);
//        webSettings.setSupportZoom(true);
//        webSettings.setDefaultTextEncodingName("utf-8");
//        webview.setDownloadListener(new DownloadListener() {
//            @Override
//            public void onDownloadStart(String url, String s1, String s2, String s3, long l) {
//                Intent view = new Intent();
//                view.setAction(Intent.ACTION_VIEW);
//                view.setData(Uri.parse(url));
//                startActivity(view);
//            }});
//    }

    @Override
    public void onBackPressed() {
        if (myWebView.canGoBack()) {
            myWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
