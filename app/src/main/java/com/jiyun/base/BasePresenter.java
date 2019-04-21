package com.jiyun.base;

import java.util.ArrayList;

/**
 * Created by 灵风 on 2019/4/2.
 */

public abstract class BasePresenter<V extends BaseMvpView> {

    protected V mMvpView;
    protected ArrayList<BaseModel> models = new ArrayList<>();

    public BasePresenter(){
        initModel();
    }

    public void bind(V view){
        this.mMvpView = view;
    }

    public abstract void initModel();

    public void onDestroy() {
        mMvpView = null;
        if (models.size()>0){
            for (BaseModel model : models) {
                model.onDestroy();
            }
            models.clear();
        }
    }
}
