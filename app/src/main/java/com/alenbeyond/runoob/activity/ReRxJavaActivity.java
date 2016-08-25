package com.alenbeyond.runoob.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alenbeyond.runoob.App;
import com.alenbeyond.runoob.R;
import com.alenbeyond.runoob.activity.base.BaseActivity;
import com.alenbeyond.runoob.adapter.RVRxAdapter;
import com.alenbeyond.runoob.greendao.gen.AllOperatorsDao;
import com.alenbeyond.runoob.greendao.gen.DaoSession;
import com.alenbeyond.runoob.listenter.OnItemClickListener;
import com.alenbeyond.runoob.resource.rxjava.bean.Operators;
import com.alenbeyond.runoob.rx.ApiManager;
import com.alenbeyond.runoob.rx.MyObserver;
import com.alenbeyond.runoob.utils.UiUtils;
import com.orhanobut.logger.Logger;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReRxJavaActivity extends BaseActivity {

    @BindView(R.id.rv_rx_java)
    RecyclerView mRvRxJava;
    private RVRxAdapter mAdapter;
    private String title;

    @Override
    protected void getIntentData() {
        title = getIntent().getStringExtra("title");
    }

    @Override
    public void initWidget() {
        setContentView(R.layout.activity_re_rx_java);
        ButterKnife.bind(this);
        setStatusTranslucent();
        initToolBar(title, true);
        LinearLayoutManager lm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRvRxJava.setLayoutManager(lm);
    }

    @Override
    protected void loadData() {
        mAdapter = new RVRxAdapter(this);
        mAdapter.setOnItemClickListener(new OnItemClickListener<Operators>() {
            @Override
            public void onItemClickListener(View v, int position, Operators operators) {
                Intent intent = new Intent(ReRxJavaActivity.this, ReRxJavaAllActivity.class);
                intent.putExtra("id", operators.getOuter_id());
                intent.putExtra("title", operators.getName());
                startActivity(intent);
            }
        });

        ApiManager.getObRxOperators(new MyObserver<List<Operators>>() {
            @Override
            public void onNext(List<Operators> operatorses) {
                mAdapter.setDatas(operatorses);
                mRvRxJava.setAdapter(mAdapter);
            }
        });
    }
}
