package com.everywhere.trip.ui.my.activity;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.everywhere.trip.R;
import com.everywhere.trip.base.BaseActivity;
import com.everywhere.trip.base.Constants;
import com.everywhere.trip.model.UpdateInfoModel;
import com.everywhere.trip.net.ResultCallBack;
import com.everywhere.trip.presenter.EmptyPresenter;
import com.everywhere.trip.util.GlideUtil;
import com.everywhere.trip.util.SpUtil;
import com.everywhere.trip.view.main.EmptyView;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;

public class InformationActivity extends BaseActivity<EmptyView, EmptyPresenter> implements EmptyView, View.OnClickListener {

    @BindView(R.id.toolBar)
    Toolbar toolBar;
    @BindView(R.id.rl_header)
    RelativeLayout rlHeader;
    @BindView(R.id.rl_nick)
    RelativeLayout rlNick;
    @BindView(R.id.rl_gender)
    RelativeLayout rlGender;
    @BindView(R.id.rl_signature)
    RelativeLayout rlSignature;
    @BindView(R.id.rl_updatePsw)
    RelativeLayout rlUpdatePsw;
    @BindView(R.id.rl_bindPhone)
    RelativeLayout rlBindPhone;
    @BindView(R.id.iv_header)
    ImageView ivHeader;
    @BindView(R.id.tv_nick)
    TextView tvNick;
    @BindView(R.id.tv_gender)
    TextView tvGender;
    @BindView(R.id.tv_signature)
    TextView tvSignature;
    @BindView(R.id.ll_parent)
    LinearLayout mLl;
    private int type;
    /**
     * 男
     */
    private Button mBtM;
    /**
     * 女
     */
    private Button mBtF;
    /**
     * 保密
     */
    private Button mBtU;
    /**
     * 取消
     */
    private Button mBtCancel;
    private PopupWindow popupWindow;

    @Override
    protected EmptyPresenter initPresenter() {
        return new EmptyPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_information;
    }

    @Override
    protected void initView() {
        StatusBarUtil.setLightMode(this);
        toolBar.setNavigationIcon(R.drawable.back_white);
        toolBar.setTitle("");
        setSupportActionBar(toolBar);
        GlideUtil.loadUrlCircleImage(R.mipmap.zhanweitu_touxiang, R.mipmap.zhanweitu_touxiang, (String) SpUtil.getParam(Constants.PHOTO, ""), ivHeader, this);
        tvNick.setText((String) SpUtil.getParam(Constants.USERNAME, "user"));
        setGender();
        tvSignature.setText((String) SpUtil.getParam(Constants.DESC, ""));

        rlHeader.setOnClickListener(this);
        rlNick.setOnClickListener(this);
        rlGender.setOnClickListener(this);
        rlSignature.setOnClickListener(this);

    }

    private void setGender() {
        String gender = (String) SpUtil.getParam(Constants.GENDER, "保密");
        if (gender.equals("M")) {
            tvGender.setText("男");
        } else if (gender.equals("F")) {
            tvGender.setText("女");
        } else {
            tvGender.setText("保密");
        }
    }

    @Override
    protected void initListener() {
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_header:
                type = UpdateInfoActivity.HEADER_TYPE;
                UpdateInfoActivity.startAct(this,type,"");
                break;
            case R.id.rl_nick:
                type = UpdateInfoActivity.NICK_TYPE;
                UpdateInfoActivity.startAct(this, type,"");
                break;
            case R.id.rl_gender:
                popup();
                break;
            case R.id.rl_signature:
                type = UpdateInfoActivity.SIGNATURE_TYPE;
                UpdateInfoActivity.startAct(this, type,"");
                break;
        }
    }

    private void popup() {
        View inflate = View.inflate(this, R.layout.layout_popup, null);
        mBtM = (Button) inflate.findViewById(R.id.bt_m);
        mBtF = (Button) inflate.findViewById(R.id.bt_f);
        mBtU = (Button) inflate.findViewById(R.id.bt_u);
        mBtCancel = (Button) inflate.findViewById(R.id.bt_cancel);
        clickListener();
        popupWindow = new PopupWindow(inflate, WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.showAtLocation(mLl, Gravity.CENTER, 0, 0);
        inflate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }

    private static final String TAG = "InformationActivity";
    private void clickListener() {
        mBtM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new UpdateInfoModel().updateInfo((String) SpUtil.getParam(Constants.TOKEN, ""), "M", UpdateInfoActivity.GENDER_TYPE, new ResultCallBack<String>() {
                    @Override
                    public void onSuccess(String bean) {
                        SpUtil.setParam(Constants.GENDER,"M");
                        tvGender.setText("男");
                    }

                    @Override
                    public void onFail(String msg) {
                        Log.e(TAG, "onFail: e="+msg );
                    }
                });
                popupWindow.dismiss();
            }
        });
        mBtF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new UpdateInfoModel().updateInfo((String) SpUtil.getParam(Constants.TOKEN, ""), "F", UpdateInfoActivity.GENDER_TYPE, new ResultCallBack<String>() {
                    @Override
                    public void onSuccess(String bean) {
                        SpUtil.setParam(Constants.GENDER,"F");
                        tvGender.setText("女");
                    }

                    @Override
                    public void onFail(String msg) {
                        Log.e(TAG, "onFail: e="+msg );
                    }
                });
                popupWindow.dismiss();
            }
        });
        mBtU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new UpdateInfoModel().updateInfo((String) SpUtil.getParam(Constants.TOKEN, ""), "U", UpdateInfoActivity.GENDER_TYPE, new ResultCallBack<String>() {
                    @Override
                    public void onSuccess(String bean) {
                        SpUtil.setParam(Constants.GENDER,"U");
                        tvGender.setText("保密");
                    }

                    @Override
                    public void onFail(String msg) {
                        Log.e(TAG, "onFail: e="+msg );
                    }
                });
                popupWindow.dismiss();
            }
        });
        mBtCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (type == UpdateInfoActivity.NICK_TYPE) {
            String name = (String) SpUtil.getParam(Constants.USERNAME, "no");
            tvNick.setText(name);
        } else if (type == UpdateInfoActivity.SIGNATURE_TYPE) {
            String signature = (String) SpUtil.getParam(Constants.DESC, "未设置");
            tvSignature.setText(signature);
        }
        String gender = (String) SpUtil.getParam(Constants.GENDER, "保密");
        if (gender.equals("F")){
            tvGender.setText("女");
        }else if (gender.equals("M")){
            tvGender.setText("男");
        }else {
            tvGender.setText("保密");
        }
        String photo = (String) SpUtil.getParam(Constants.PHOTO,"");
        GlideUtil.loadUrlCircleImage(R.mipmap.zhanweitu_touxiang,R.mipmap.zhanweitu_touxiang,photo,ivHeader,this);
    }

}
