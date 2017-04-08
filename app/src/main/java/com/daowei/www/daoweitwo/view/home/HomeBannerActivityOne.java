package com.daowei.www.daoweitwo.view.home;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.daowei.www.daoweitwo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import im.delight.android.webview.AdvancedWebView;

public class HomeBannerActivityOne extends AppCompatActivity {
    @BindView(R.id.home_webview)
    AdvancedWebView webView;
    @BindView(R.id.banner_item_toolbar)
    Toolbar toolbar;
    private ProgressDialog dialog;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent = getIntent();
        setContentView(R.layout.activity_home_banner_one);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setTitle("");
        initView();
    }

    @Override
    protected void onDestroy() {
        webView.destroy();
        super.onStop();
    }

    private void initView() {
        dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("详情加载中...");
        dialog.setMax(100);
        String target = intent.getStringExtra("target");
        webView.loadUrl(target);
        dialog.show();
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                dialog.setProgress(newProgress);
                if(newProgress==100){
                    dialog.dismiss();
                }
            }
        });
    }

    public void bannerEnd(View view) {
        finish();
    }

    public void text_finish(View view) {
        finish();
    }
}
