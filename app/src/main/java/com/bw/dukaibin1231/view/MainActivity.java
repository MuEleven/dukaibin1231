package com.bw.dukaibin1231.view;
/*  作者 杜凯宾
    时间 19年12.31
    功能 列表展示
 * */
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.dukaibin1231.R;
import com.bw.dukaibin1231.adapter.MyAdapter;
import com.bw.dukaibin1231.base.BaseActivity;
import com.bw.dukaibin1231.bean.MyBean;
import com.bw.dukaibin1231.contract.IMainContract;
import com.bw.dukaibin1231.presenter.MainPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainPresenter> implements IMainContract.IView {

    @BindView(R.id.recy)
    RecyclerView recyclerView;
    @BindView(R.id.free)
    Button free;

    @Override
    protected MainPresenter providePresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initData() {
        mPresenter.getMainData();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onMainSuccess(MyBean bean) {
        free.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ShowActivity.class);
                startActivity(intent);
            }
        });
        List<MyBean.RankingBean> data = bean.getRanking();
        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        //适配器
        MyAdapter myAdapter = new MyAdapter(data);
        myAdapter.setOnItemClickLintLner(new MyAdapter.OnItemClickLintLner() {
            @Override
            public void OnItemClick(int posintion) {
                Intent intent = new Intent(MainActivity.this, ShowActivity.class);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(myAdapter);

    }

    @Override
    public void onMainFailure(Throwable throwable) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
