package com.example.zhangshaohang.ui.main.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhangshaohang.ui.R;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    /**
     * 请输入手机号码
     */
    private EditText mPhone;
    private ImageView mTitleImg;
    /**
     * +86
     */
    private TextView mChs;
    /**
     * 发送验证码
     */
    private Button mSendVerify;
    private ImageView mWechat;
    /**
     * 微信登录
     */
    private TextView mTvWechat;
    /**
     * or
     */
    private TextView mOr;
    /**
     * 你好，为了获取更好的服务
     */
    private TextView mTitle;
    /**
     * 请登录到处旅行
     */
    private TextView mMsg;
    private LinearLayout mLoginLl;
    private ImageView mImgBack;
    private LinearLayout mVerifyLl;
    private EditText mEt1;
    private EditText mEt2;
    private EditText mEt3;
    private EditText mEt4;
    boolean isNull = true;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= 23) {
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE, Manifest.permission.READ_LOGS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.SET_DEBUG_APP, Manifest.permission.SYSTEM_ALERT_WINDOW, Manifest.permission.GET_ACCOUNTS, Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this, mPermissionList, 123);
        }
        initView();
        initListener();
    }

    private void initListener() {
        mPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 11) {
                    mSendVerify.setBackground(getResources().getDrawable(R.mipmap.button_highlight));
                } else {
                    mSendVerify.setBackground(getResources().getDrawable(R.mipmap.button_unavailable));
                }
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void initView() {
        mPhone = (EditText) findViewById(R.id.phone);
        mTitleImg = (ImageView) findViewById(R.id.title_img);
        mChs = (TextView) findViewById(R.id.chs);
        mWechat = (ImageView) findViewById(R.id.wechat);
        mWechat.setOnClickListener(this);
        mTvWechat = (TextView) findViewById(R.id.tv_wechat);
        mSendVerify = (Button) findViewById(R.id.send_verify);
        mSendVerify.setOnClickListener(this);
        mTitle = (TextView) findViewById(R.id.title);
        mMsg = (TextView) findViewById(R.id.msg);
        mOr = (TextView) findViewById(R.id.or);
        mLoginLl = (LinearLayout) findViewById(R.id.login_ll);
        mImgBack = (ImageView) findViewById(R.id.img_back);
        mImgBack.setOnClickListener(this);
        mVerifyLl = (LinearLayout) findViewById(R.id.verify_ll);
        mEt1 = (EditText) findViewById(R.id.et1);
        mEt2 = (EditText) findViewById(R.id.et2);
        mEt3 = (EditText) findViewById(R.id.et3);
        mEt4 = (EditText) findViewById(R.id.et4);
        mEt1.addTextChangedListener(this);
        mEt2.addTextChangedListener(this);
        mEt3.addTextChangedListener(this);
        mEt4.addTextChangedListener(this);
        mVerifyLl.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.send_verify:
                String string = mPhone.getText().toString();
                if (string.length() == 11 && string.matches("1[0-9]{10}")) {
                    mLoginLl.setVisibility(View.GONE);
                    mVerifyLl.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.wechat:
                UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.QQ, umAuthListener);
                break;
            case R.id.img_back:
                mVerifyLl.setVisibility(View.GONE);
                mLoginLl.setVisibility(View.VISIBLE);
                break;
        }
    }

    private static final String TAG = "LoginActivity";
    UMAuthListener umAuthListener = new UMAuthListener() {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            if (data != null){
                for (Map.Entry<String, String> stringStringEntry : data.entrySet()) {
                    String key = stringStringEntry.getKey();
                    String value = stringStringEntry.getValue();
                    Log.e(TAG, "key: " + key + ", value: " + value);
                }
                mTitle.setText("为了您的账号安全");
                mMsg.setText("请绑定手机号");
                mOr.setVisibility(View.GONE);
                mWechat.setVisibility(View.GONE);
                mTvWechat.setVisibility(View.GONE);
            }
        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {

            Toast.makeText(LoginActivity.this, "失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(LoginActivity.this, "取消了", Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onStop() {
        super.onStop();
        UMShareAPI.get(this).deleteOauth(this, SHARE_MEDIA.QQ, umAuthListener);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (s.toString().length() == 1) {
            if (mEt1.isFocused()) {
                mEt1.clearFocus();
                mEt2.requestFocus();
            } else if (mEt2.isFocused()) {
                mEt2.clearFocus();
                mEt3.requestFocus();
            } else if (mEt3.isFocused()) {
                mEt3.clearFocus();
                mEt4.requestFocus();
            } else if (mEt4.isFocused()){
                if (mEt1.getText().toString().length()>0 && mEt2.getText().toString().length()>0 && mEt3.getText().toString().length()>0){
                    Toast.makeText(this, "验证码输入完成", Toast.LENGTH_SHORT).show();
                    mEt1.setEnabled(false);
                    mEt2.setEnabled(false);
                    mEt3.setEnabled(false);
                    mEt4.setEnabled(false);
                }
            }
        }

        if (s.toString().length() == 0) {
            if (mEt4.isFocused()) {
                mEt4.clearFocus();
                mEt3.requestFocus();
            } else if (mEt2.isFocused()) {
                mEt2.clearFocus();
                mEt1.requestFocus();
            } else if (mEt3.isFocused()) {
                mEt3.clearFocus();
                mEt2.requestFocus();
            }
        }
    }
}
