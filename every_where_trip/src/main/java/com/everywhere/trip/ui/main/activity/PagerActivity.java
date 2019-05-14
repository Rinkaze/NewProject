package com.everywhere.trip.ui.main.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.everywhere.trip.R;
import com.everywhere.trip.util.SpUtil;
import com.everywhere.trip.widget.PreviewIndicator;

import java.util.ArrayList;

public class PagerActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mVp;
    private PreviewIndicator mPi;
    /**
     * 立即体验
     */
    private Button mBtn;
    private ArrayList<ImageView> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        initView();
        initData();
        if (Build.VERSION.SDK_INT >= 23) {
            int REQUEST_CODE_CONTACT = 101;
            String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.CAMERA};
            //验证是否许可权限
            for (String str : permissions) {
                if (this.checkSelfPermission(str) != PackageManager.PERMISSION_GRANTED) {
                    //申请权限
                    this.requestPermissions(permissions, REQUEST_CODE_CONTACT);
                    break;
                }
            }
        }
    }

    private void initData() {
        list = new ArrayList<>();
        ImageView imageView1 = new ImageView(this);
        Glide.with(this).load(R.mipmap.guide_01).into(imageView1);
        ImageView imageView2 = new ImageView(this);
        Glide.with(this).load(R.mipmap.guide_02).into(imageView2);
        ImageView imageView3 = new ImageView(this);
        Glide.with(this).load(R.mipmap.guide_03).into(imageView3);
        list.add(imageView1);
        list.add(imageView2);
        list.add(imageView3);
        mVp.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                ImageView view = list.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView((View) object);
            }
        });

        mVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 2){
                    mPi.setVisibility(View.GONE);
                    mBtn.setVisibility(View.VISIBLE);
                }else{
                    mPi.setVisibility(View.VISIBLE);
                    mBtn.setVisibility(View.GONE);
                }
                mPi.setSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mPi = (PreviewIndicator) findViewById(R.id.pi);
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(this);
        mPi.initSize(80,32,6);
        mPi.setNumbers(3);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn:
                SpUtil.setParam("isPagerOpened",true);
                startActivity(new Intent(this,LoginActivity.class));
                finish();
                break;
        }
    }
}
