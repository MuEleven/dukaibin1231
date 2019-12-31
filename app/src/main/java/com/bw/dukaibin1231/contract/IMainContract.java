package com.bw.dukaibin1231.contract;

import com.bw.dukaibin1231.bean.MyBean;

public interface IMainContract {

    interface IView{
        void onMainSuccess(MyBean bean);
        void onMainFailure(Throwable throwable);
    }

    interface IPresenter{
        void getMainData();
    }

    interface IModel{
        void getMainData(IModelCallBack iModelCallBack);

        interface IModelCallBack{
            void onMainSuccess(MyBean bean);
            void onMainFailure(Throwable throwable);
        }
    }
}
