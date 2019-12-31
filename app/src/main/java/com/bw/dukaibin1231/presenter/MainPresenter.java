package com.bw.dukaibin1231.presenter;

import com.bw.dukaibin1231.base.BasePresenter;
import com.bw.dukaibin1231.bean.MyBean;
import com.bw.dukaibin1231.contract.IMainContract;
import com.bw.dukaibin1231.model.MainModel;

public class MainPresenter extends BasePresenter<IMainContract.IView> implements IMainContract.IPresenter {
    private MainModel mainModel;
    @Override
    protected void initModel() {
        mainModel = new MainModel();
    }

    @Override
    public void getMainData() {
        mainModel.getMainData(new IMainContract.IModel.IModelCallBack() {
            @Override
            public void onMainSuccess(MyBean bean) {
                view.onMainSuccess(bean);
            }

            @Override
            public void onMainFailure(Throwable throwable) {
                view.onMainFailure(throwable);
            }
        });
    }
}
