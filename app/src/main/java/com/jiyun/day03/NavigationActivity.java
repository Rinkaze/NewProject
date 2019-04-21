package com.jiyun.day03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class NavigationActivity extends AppCompatActivity {

    private String mUrl = "https://www.v2ex.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        initData();
    }

    private static final String TAG = "NavigationActivity";
    private void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Document doc = Jsoup.connect(mUrl).get();
                    Elements select = doc.select("div#Main");
                    Element last = select.select("div.box").last();
                    Elements divs = last.select("div");
                    for (int i = 0; i < divs.size(); i++) {
                        if (i != 0){
                            Element element = divs.get(i);
                            Element fade = element.select("table tbody tr td > span.fade").first();
                            if (fade != null) {
                                String channel = fade.text();
                                Log.e(TAG, "类别: " + channel);
                            }

                            Elements titles = element.select("table tbody tr td > a");
                            for (Element title : titles) {
                                String href = title.attr("href");
                                String text = title.text();
                                Log.e(TAG, "标题: " +text + ", 链接:" + href);
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
