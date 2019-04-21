package com.jiyun.day03;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.jiyun.adapter.RecShowAdapter;
import com.jiyun.base.Constants;
import com.jiyun.bean.GoldTitleBean;
import com.jiyun.widget.SimpleItemTouchCallback;

import java.io.Serializable;
import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity {

    private Toolbar mToolBar;
    private RecyclerView mRecView;
    private RecShowAdapter adapter;
    private ArrayList<GoldTitleBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        initView();
        initData();
        initListener();
    }

    private void initListener() {
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAct();
            }
        });
    }

    private void initData() {
        list = (ArrayList<GoldTitleBean>) getIntent().getSerializableExtra(Constants.DATA);
        adapter = new RecShowAdapter(this, list);
        mRecView.setAdapter(adapter);

        //拖拽移动和左滑删除
        SimpleItemTouchCallback simpleItemTouchCallBack = new SimpleItemTouchCallback(adapter);
        simpleItemTouchCallBack.setmSwipeEnable(false);
        ItemTouchHelper helper = new ItemTouchHelper(simpleItemTouchCallBack);
        helper.attachToRecyclerView(mRecView);
    }

    private void initView() {
        mToolBar = (Toolbar) findViewById(R.id.toolBar);
        mRecView = (RecyclerView) findViewById(R.id.recView);
        mRecView.setLayoutManager(new LinearLayoutManager(this));
        mToolBar.setTitle("首页特别展示");
        mToolBar.setNavigationIcon(R.mipmap.ic_close);
        setSupportActionBar(mToolBar);


    }

    private void finishAct() {
        Intent intent = new Intent();
        intent.putExtra(Constants.DATA,list);
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        finishAct();
    }
}
