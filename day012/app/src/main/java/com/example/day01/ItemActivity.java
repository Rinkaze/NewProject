package com.example.day01;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by 灵风 on 2019/4/29.
 */

public class ItemActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mToCenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_layout);
        initView();
    }

    private void initView() {
        mToCenter = (ImageView) findViewById(R.id.to_center);
        mToCenter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.to_center:
                startActivity(new Intent(this,MainActivity.class));
                break;
        }
    }
}
