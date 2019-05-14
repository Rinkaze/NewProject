package com.everywhere.trip.ui.my.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.everywhere.trip.R;
import com.everywhere.trip.base.BaseActivity;
import com.everywhere.trip.base.Constants;
import com.everywhere.trip.presenter.UpdateInfoPresenter;
import com.everywhere.trip.util.FileProviderUtils;
import com.everywhere.trip.util.GlideUtil;
import com.everywhere.trip.util.PhotosUtils;
import com.everywhere.trip.util.SpUtil;
import com.everywhere.trip.util.SystemUtil;
import com.everywhere.trip.view.my.UpdateInfoView;
import com.everywhere.trip.widget.GlideApp;
import com.jaeger.library.StatusBarUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UpdateInfoActivity extends BaseActivity<UpdateInfoView, UpdateInfoPresenter> implements UpdateInfoView {

    @BindView(R.id.tb_title)
    TextView tbTitle;
    @BindView(R.id.iv_big_header)
    ImageView ivBigHeader;
    @BindView(R.id.tb_finished)
    TextView tbFinished;
    @BindView(R.id.iv_menu)
    ImageView ivMenu;
    @BindView(R.id.toolBar)
    Toolbar toolBar;
    @BindView(R.id.et_info)
    EditText etInfo;
    @BindView(R.id.text_count)
    TextView textCount;
    @BindView(R.id.cv_info)
    CardView cvInfo;
    @BindView(R.id.ll_parent)
    LinearLayout mLl;
    public static int NICK_TYPE = 0;
    public static int SIGNATURE_TYPE = 1;
    public static int HEADER_TYPE = 2;
    public static int GENDER_TYPE = 3;
    private static int mType;
    private static String mImgUrl = "";
    private PopupWindow popupWindow;
    private Button mPopbtCamera;
    private Button mPopbtPhoto;
    private Button mPopbtCancel;
    private String uploadUrl = "http://yun918.cn/study/public/file_upload.php";
    private File cameraFile;

    public static void startAct(Context context, int type, String imgUrl) {
        mType = type;
        mImgUrl = imgUrl;
        context.startActivity(new Intent(context, UpdateInfoActivity.class));
    }

    @Override
    protected UpdateInfoPresenter initPresenter() {
        return new UpdateInfoPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_update_info;
    }

    @OnClick(R.id.tb_finished)
    public void onViewClicked() {
        String info = etInfo.getText().toString().trim();
        if (!TextUtils.isEmpty(info)) {
            if (mType == NICK_TYPE || mType == SIGNATURE_TYPE) {
                ivBigHeader.setVisibility(View.GONE);
                cvInfo.setVisibility(View.VISIBLE);
                mPresenter.updateInfo((String) SpUtil.getParam(Constants.TOKEN, ""), info, mType);
            }
        }
        if (mType == HEADER_TYPE) {
            cvInfo.setVisibility(View.GONE);
            ivBigHeader.setVisibility(View.VISIBLE);
            mPresenter.updateInfo((String) SpUtil.getParam(Constants.TOKEN, ""), mImgUrl, mType);
        }
    }

    @Override
    protected void initView() {
        StatusBarUtil.setLightMode(this);
        toolBar.setNavigationIcon(R.mipmap.back_white);
        etInfo.setSelection(etInfo.getText().toString().length());
        textCount.setText(etInfo.getText().toString().length()+"/27");
        if (mType == NICK_TYPE) {
            tbTitle.setText("修改昵称");
            etInfo.setText((String) SpUtil.getParam(Constants.USERNAME, ""));
            textCount.setText(etInfo.getText().toString().trim().length() + "/27");
        } else if (mType == SIGNATURE_TYPE) {
            tbTitle.setText("个性签名");
            etInfo.setText((String) SpUtil.getParam(Constants.DESC, ""));
            textCount.setText(etInfo.getText().toString().trim().length() + "/27");
        } else if (mType == HEADER_TYPE) {
            tbTitle.setText("个人头像");
            tbFinished.setVisibility(View.GONE);
            cvInfo.setVisibility(View.GONE);
            ivMenu.setVisibility(View.VISIBLE);
            ivBigHeader.setVisibility(View.VISIBLE);
            GlideUtil.loadUrlImage(R.mipmap.zhanweitu_home_kapian, R.mipmap.zhanweitu_home_kapian,
                    (String) SpUtil.getParam(Constants.PHOTO, ""), ivBigHeader, this);
        }
        registerForContextMenu(mLl);
    }

    private static final String TAG = "UpdateInfoActivity";

    @Override
    public void onSuccess(String msg) {
        if (mType == NICK_TYPE) {
            Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
            SpUtil.setParam(Constants.USERNAME, etInfo.getText().toString().trim());
            finish();
        } else if (mType == SIGNATURE_TYPE) {
            Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
            SpUtil.setParam(Constants.DESC, etInfo.getText().toString().trim());
            finish();
        } else if (mType == HEADER_TYPE) {
            SpUtil.setParam(Constants.PHOTO, mImgUrl);
            Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public void onFail(String msg) {

    }

    @Override
    protected void initListener() {
        etInfo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                textCount.setText(s.toString().length() + "/27");
            }
        });

        ivMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (popupWindow == null){
                    popup();
                }else {
                    popupWindow.dismiss();
                    popupWindow = null;
                }
            }
        });

        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void popup() {
        View view = View.inflate(this, R.layout.layout_popcamera_menu, null);
        mPopbtCamera = view.findViewById(R.id.popbt_camera);
        mPopbtPhoto = view.findViewById(R.id.popbt_photo);
        mPopbtCancel = view.findViewById(R.id.popbt_cancel);
        popupWindow = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, 450);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAtLocation(mLl, Gravity.BOTTOM, 0, 0);
        setClick();
    }

    private void setClick() {
        mPopbtCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cameraFile = new File(Environment.getExternalStorageDirectory() + File.separator + "xxx.jpg");
                PhotosUtils.goCamera(UpdateInfoActivity.this, cameraFile);
                popupWindow.dismiss();
            }
        });
        mPopbtPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhotosUtils.selectPhoto(UpdateInfoActivity.this);
                popupWindow.dismiss();
            }
        });
        mPopbtCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri filtUri;
        File outputFile = new File("/mnt/sdcard/t.jpg");//裁切后输出的图片
        switch (requestCode) {
            case PhotosUtils.REQUEST_CODE_PAIZHAO:
                //拍照完成，进行图片裁切
                filtUri = FileProviderUtils.uriFromFile(this, cameraFile);
                PhotosUtils.doCrop(this, filtUri, outputFile);
                break;
            case PhotosUtils.REQUEST_CODE_ZHAOPIAN:
                //相册选择图片完毕，进行图片裁切
                if (data == null || data.getData() == null) {
                    return;
                }
                filtUri = data.getData();
                PhotosUtils.doCrop(this, filtUri, outputFile);
                break;
            case PhotosUtils.REQUEST_CODE_CAIQIE:
                //图片裁切完成，显示裁切后的图片
                try {
                    Uri uri = Uri.fromFile(outputFile);
                    Bitmap bitmap = BitmapFactory.decodeStream(this.getContentResolver().openInputStream(uri));
//                    mUserImg.setImageBitmap(bitmap);

                    RequestOptions mRequestOptions = RequestOptions.circleCropTransform()
                            .skipMemoryCache(true);//不做内存缓存


                    GlideApp.with(this)
                            .load(bitmap)
                            .centerCrop()
                            .apply(mRequestOptions)
                            .placeholder(R.drawable.ic_launcher_background)//加载中显示的图片
                            .error(R.drawable.ic_launcher_foreground)// 错误后显示的图片
                            .into(ivBigHeader);
                    // file path
                    // okhttp
                    uploadUserIcon(outputFile);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
        }
    }


    public void uploadUserIcon(final File file) {

        // file --> RequestBody-- MultiPartBody
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/jpg"), file);

        MultipartBody multipartBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("key", "monthdemo")
                .addFormDataPart("file", System.currentTimeMillis()+file.getName(), requestBody)
                .build();

        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url(uploadUrl)
                .post(multipartBody)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: e=" + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                {"code":200,"res":"上传文件成功","data":{"url":"http:\/\/yun918.cn\/study\/public\/uploadfiles\/monthdemo\/tupian_out.jpg"}}

                try {
                    JSONObject jsonObject = new JSONObject(response.body().string());

                    JSONObject data = jsonObject.getJSONObject("data");
                    String result = data.optString("url");

                    // 把图片的服务器url 发送给homeFragment
                    mImgUrl = result;
                    Log.d(TAG, "onResponse: " + result);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ivMenu.setVisibility(View.GONE);
                            tbFinished.setVisibility(View.VISIBLE);
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
