package com.everywhere.trip.ui.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.everywhere.trip.R;
import com.everywhere.trip.base.Constants;
import com.everywhere.trip.net.AndroidInterface;
import com.jaeger.library.StatusBarUtil;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.WebChromeClient;

public class WebViewActivity extends AppCompatActivity {

    private LinearLayout mLl;
    private AgentWeb mAgentWeb;
    private TextView tvTitle;
    private Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        initView();
    }

    private void initView() {
        StatusBarUtil.setLightMode(this);
        mLl = (LinearLayout) findViewById(R.id.ll);
        tvTitle = (TextView) findViewById(R.id.tb_title);
        toolBar = (Toolbar) findViewById(R.id.toolBar);
        toolBar.setTitle("");
        tvTitle.setText(getIntent().getStringExtra(Constants.TITLE));
        toolBar.setNavigationIcon(R.mipmap.back_white);
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent((LinearLayout) mLl, new LinearLayout.LayoutParams(-1, -1))
                .closeIndicator()
                .createAgentWeb()
                .ready()
                .go(getIntent().getStringExtra(Constants.DATA));
        mAgentWeb.getJsInterfaceHolder().addJavaObject("android",new AndroidInterface(mAgentWeb,this));
        initListener();
    }

    private void initListener() {
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WebViewActivity.this,MainActivity.class));
                finish();
            }
        });
    }

}
