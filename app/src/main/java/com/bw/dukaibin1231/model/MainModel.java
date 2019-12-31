package com.bw.dukaibin1231.model;

import com.bw.dukaibin1231.bean.MyBean;
import com.bw.dukaibin1231.contract.IMainContract;
import com.bw.dukaibin1231.tools.NetUtil;
import com.google.gson.Gson;

public class MainModel implements IMainContract.IModel{

    @Override
    public void getMainData(IModelCallBack iModelCallBack) {
        String httpUrl = "http://blog.zhaoliang5156.cn/api/news/ranking.json";

        NetUtil.getInstance().getJsonGet(httpUrl, new NetUtil.MyCallBack() {
            @Override
            public void onGetJson(String json) {

                MyBean bean = new Gson().fromJson(json, MyBean.class);
                iModelCallBack.onMainSuccess(bean);
            }

            @Override
            public void onError(Throwable throwable) {
                iModelCallBack.onMainFailure(throwable);
            }
        });
    }
}

