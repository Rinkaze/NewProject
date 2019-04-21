package com.jiyun.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jiyun.adapter.RecDailyNewsAdapter;
import com.jiyun.base.BaseFragment;
import com.jiyun.base.Constants;
import com.jiyun.bean.DailyNewsBean;
import com.jiyun.day03.CalenderActivity;
import com.jiyun.day03.R;
import com.jiyun.presenter.DailyNewsPresenter;
import com.jiyun.util.CircularAnimUtil;
import com.jiyun.util.DateUtil;
import com.jiyun.view.DailyNewsView;
import com.prolificinteractive.materialcalendarview.CalendarDay;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.app.Activity.RESULT_OK;
import static com.jiyun.util.CircularAnimUtil.PERFECT_MILLS;

/**
 * Created by 灵风 on 2019/4/17.
 */

public class DailyNewsFragment extends BaseFragment<DailyNewsView, DailyNewsPresenter> implements DailyNewsView{
    @BindView(R.id.recView)
    RecyclerView mRecView;
    @BindView(R.id.fab_calender)
    FloatingActionButton fabCalender;
    private RecDailyNewsAdapter dailyNewsAdapter;
    private long durationMills = PERFECT_MILLS;

    @Override
    protected DailyNewsPresenter initPresenter() {
        return new DailyNewsPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dailynews_layout;
    }

    @Override
    protected void initView() {
        mRecView.setLayoutManager(new LinearLayoutManager(getContext()));
        ArrayList<DailyNewsBean.StoriesEntity> stories = new ArrayList<>();
        ArrayList<DailyNewsBean.Top_storiesEntity> topStories = new ArrayList<>();
        dailyNewsAdapter = new RecDailyNewsAdapter(getContext(), stories, topStories);
        mRecView.setAdapter(dailyNewsAdapter);
    }

    @Override
    protected void initData() {
        mPresenter.getDailyNewsData();
    }

    @Override
    public void updateData(DailyNewsBean dailyNewsBean) {
        dailyNewsAdapter.setStories((ArrayList<DailyNewsBean.StoriesEntity>) dailyNewsBean.getStories());
        if (dailyNewsBean.getTop_stories() == null){
            dailyNewsAdapter.setTopStories(new ArrayList<DailyNewsBean.Top_storiesEntity>());
        }else {
            dailyNewsAdapter.setTopStories((ArrayList<DailyNewsBean.Top_storiesEntity>) dailyNewsBean.getTop_stories());
        }
        dailyNewsAdapter.setTime(dailyNewsBean.getDate());
    }

    @OnClick(R.id.fab_calender)
    void startCalender() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startAnim();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void startAnim() {
        int[] location = new int[2];
        fabCalender.getLocationInWindow(location);
        final int cx = location[0] + fabCalender.getWidth() / 2;
        final int cy = location[1] + fabCalender.getHeight() / 2;
        final ImageView view = new ImageView(getContext());
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.setImageResource(R.color.fab_bg);
        final ViewGroup decorView = (ViewGroup) getActivity().getWindow().getDecorView();
        int w = decorView.getWidth();
        int h = decorView.getHeight();
        decorView.addView(view, w, h);

        // 计算中心点至view边界的最大距离
        int maxW = Math.max(cx, w - cx);
        int maxH = Math.max(cy, h - cy);
        final int finalRadius = (int) Math.sqrt(maxW * maxW + maxH * maxH) + 1;
        Animator
                anim = ViewAnimationUtils.createCircularReveal(view, cx, cy, 0, finalRadius);
        int maxRadius = (int) Math.sqrt(w * w + h * h) + 1;
        // 若使用默认时长，则需要根据水波扩散的距离来计算实际时间
        if (durationMills == PERFECT_MILLS) {
            // 算出实际边距与最大边距的比率
            double rate = 1d * finalRadius / maxRadius;
            // 水波扩散的距离与扩散时间成正比
            durationMills = (long) (PERFECT_MILLS * rate);
        }
        final long finalDuration = durationMills;
        anim.setDuration(finalDuration);
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Intent it = new Intent();
                it.setClass(getContext(),CalenderActivity.class);
                startActivityForResult(it,100);

                // 默认渐隐过渡动画.
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                // 默认显示返回至当前Activity的动画.
                fabCalender.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Animator anim =
                                ViewAnimationUtils.createCircularReveal(view, cx, cy, finalRadius, 0);
                        anim.setDuration(finalDuration);
                        anim.addListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                try {
                                    decorView.removeView(view);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        anim.start();
                    }
                }, 1000);
            }
        });
        anim.start();
    }

    private static final String TAG = "DailyNewsFragment";
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK){
            String s = data.getStringExtra(Constants.DATA);
            String date = showDate();
            int i = Integer.parseInt(s);
            if (!(i+"").equals(date)){
                Log.e(TAG, "onActivityResult: "+i );
                mPresenter.getLastNewsData(i+1+"");
            }else {
                mPresenter.getDailyNewsData();
            }
        }
    }

    private String showDate() {
        CalendarDay day = CalendarDay.from(DateUtil.getCurrentYear(), DateUtil.getCurrentMonth(), DateUtil.getCurrentDay());
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String date = format.format(day.getDate());
        Log.e(TAG, "chooseDate: "+ date);
        return date;
    }
}
