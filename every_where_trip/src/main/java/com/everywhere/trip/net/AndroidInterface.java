package com.everywhere.trip.net;

import android.content.Context;
import android.content.Intent;
import android.webkit.JavascriptInterface;

import com.everywhere.trip.base.Constants;
import com.everywhere.trip.ui.main.activity.MainInfoActivity;
import com.everywhere.trip.ui.main.activity.SubjectActivity;
import com.everywhere.trip.ui.main.activity.WebViewActivity;
import com.just.agentweb.AgentWeb;

/**
 * Created by 灵风 on 2019/5/13.
 */

public class AndroidInterface {
    private AgentWeb agentWeb;
    Context context;

    public AndroidInterface(AgentWeb agentWeb, Context context) {
        this.agentWeb = agentWeb;
        this.context = context;
    }

    @JavascriptInterface
    public void callAndroid(String type, int id) {
//        callAndroid('route_details', id)
        Intent intent = new Intent(context, MainInfoActivity.class);
        intent.putExtra(Constants.DATA, id);
        context.startActivity(intent);
    }

    @JavascriptInterface
    public void callAndroid(String type) {
//        callAndroid('route_details', id)
        context.startActivity(new Intent(context, SubjectActivity.class));
    }
}
