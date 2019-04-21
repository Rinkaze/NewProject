package com.jiyun.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jiyun.adapter.VpChildVtexAdapter;
import com.jiyun.base.BaseFragment;
import com.jiyun.bean.VtexBean;
import com.jiyun.bean.VtexDataBean;
import com.jiyun.bean.VtexTitleBean;
import com.jiyun.day03.R;
import com.jiyun.presenter.VtexPresenter;
import com.jiyun.view.VtexView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 灵风 on 2019/4/3.
 */

public class VtexFragment extends BaseFragment<VtexView, VtexPresenter> implements VtexView {
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    private String mUrl = "https://www.v2ex.com/";
    private static final String TAG = "VtexFragment";
    private VtexBean mVtexBean;
    private VpChildVtexAdapter vpChildVtexAdapter;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 17){
                mVtexBean = (VtexBean)msg.obj;
                for (VtexTitleBean titleBean : mVtexBean.getTitles()) {
                    Bundle bundle = new Bundle();
                    bundle.putString("url",mUrl+titleBean.getLink());
                    ChildVtexFragment fragment = new ChildVtexFragment();
                    fragment.setArguments(bundle);
                    fragments.add(fragment);
                }
                vpChildVtexAdapter = new VpChildVtexAdapter(getChildFragmentManager(), fragments, mVtexBean.getTitles());
                vp.setAdapter(vpChildVtexAdapter);
            }
        }
    };
    private ArrayList<Fragment> fragments;

    @Override
    protected VtexPresenter initPresenter() {
        return new VtexPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.vtex_layout;
    }

    @Override
    protected void initView() {
        mVtexBean = new VtexBean();
        fragments = new ArrayList<>();
        tab.setupWithViewPager(vp);
    }

    public void showLog(){
        Log.e(TAG, "showLog: e=" + mVtexBean.toString());
    }

    @Override
    protected void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Document document = Jsoup.connect(mUrl).get();
                    Elements select = document.select("div#Tabs");
                    Elements elements = select.select("a[href]");
                    ArrayList<VtexTitleBean> titleBeans = new ArrayList<>();
                    for (Element element : elements) {
                        String link = element.attr("href");
                        String text = element.text();
                        Log.e(TAG, "link:" + link + ", text:" + text);
                        titleBeans.add(new VtexTitleBean(link,text));
                    }

                    ArrayList<VtexDataBean> dataBeans = new ArrayList<>();
                    Elements items = document.select("div.cell.item");
                    for (Element item : items) {
                        VtexDataBean dataBean = new VtexDataBean();
                        Element image = item.select("table tbody tr td a > img.avatar").first();
                        String src = image.attr("src");
                        Log.e(TAG, "imageSrc: " + src);
                        dataBean.setImg_src(src);

                        Element comment = item.select("table tbody tr td a.count_livid").first();
                        if (comment != null) {
                            String href = comment.attr("href");
                            String text = comment.text();
                            Log.e(TAG, "评论    链接: " + href + "数量: " + text);
                            dataBean.setComment_link(href);
                            dataBean.setComment_count(text);
                        }

                        Element title = item.select("table tbody tr td span.item_title > a").first();
                        String text = title.text();
                        Log.e(TAG, "标题: " + text);
                        dataBean.setTitle(text);

                        Element topic = item.select("table tbody tr td span.topic_info").first();
                        Element node = topic.select("a.node").first();
                        String secTab = node.text();
                        Log.e(TAG, "secTab: " + secTab);
                        dataBean.setSecTab(secTab);

                        Elements people = topic.select("strong > a");
                        String author = people.get(0).text();
                        Log.e(TAG, "作者: " + author);
                        dataBean.setAuthor(author);
                        if (people.size() > 1) {
                            String fromUser = people.get(1).text();
                            Log.e(TAG, "最后恢复来自: " + fromUser);
                            dataBean.setFromUser(fromUser);
                        }
                        dataBeans.add(dataBean);
                    }
                    VtexBean vtexBean = new VtexBean(titleBeans, dataBeans);
                    handler.sendMessage(handler.obtainMessage(17,vtexBean));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

}
