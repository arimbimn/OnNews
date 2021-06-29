package com.arimbimega.onnews.Webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.arimbimega.onnews.Model.Articles;
import com.arimbimega.onnews.R;

import java.util.ArrayList;

public class DetailNewsActivity extends AppCompatActivity {

    TextView tvtitleTest, tvdescTest;

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_news);


        Articles articles = getIntent().getParcelableExtra("articlesArrayList");
        String UrlNews = articles.getUrl();

        //Log.d("cek", "List Article" + articles.getTitle());

//        tvtitleTest = findViewById(R.id.tvtitleTest);
//        tvdescTest = findViewById(R.id.tvdescTest);
//
//        String judul = articles.getTitle();
//        String deskripsi = articles.getDescription();
//
//        tvtitleTest.setText(judul);
//        tvdescTest.setText(deskripsi);

        webView = findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new Callback());
        webView.loadUrl(UrlNews);

    }

    private class Callback extends WebViewClient {
        @Override
        public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
            return false;
        }
    }

}