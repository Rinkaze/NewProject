package com.jiyun.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.adapter.RecChildVtexAdapter;
import com.jiyun.base.BaseFragment;
import com.jiyun.bean.VtexBean;
import com.jiyun.bean.VtexDataBean;
import com.jiyun.bean.VtexTitleBean;
import com.jiyun.day03.R;
import com.jiyun.presenter.EmptyPresenter;
import com.jiyun.view.EmptyView;

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
 * Created by 灵风 on 2019/4/19.
 */

public class ChildVtexFragment extends BaseFragment<EmptyView, EmptyPresenter> {
    @BindView(R.id.recView)
    RecyclerView recView;
    private static final String TAG = "ChildVtexFragment";
    private RecChildVtexAdapter adapter;

    @Override
    protected EmptyPresenter initPresenter() {
        return new EmptyPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.selections_layout;
    }

    @Override
    protected void initView() {
        recView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected void initData() {
        final String mUrl = getArguments().getString("url").replace(".com//",".com/");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Document document = Jsoup.connect(mUrl).get();
                    final ArrayList<VtexDataBean> dataBeans = new ArrayList<>();
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
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter = new RecChildVtexAdapter(getContext(), dataBeans);
                            recView.setAdapter(adapter);
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                    String message = e.getMessage();
                    String message2 = e.getMessage();
                }
            }
        }).start();
    }
}
