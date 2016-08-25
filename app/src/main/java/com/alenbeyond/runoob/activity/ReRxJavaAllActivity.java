package com.alenbeyond.runoob.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alenbeyond.runoob.App;
import com.alenbeyond.runoob.R;
import com.alenbeyond.runoob.activity.base.BaseActivity;
import com.alenbeyond.runoob.adapter.RVRxAllAdapter;
import com.alenbeyond.runoob.greendao.gen.AllOperatorsDao;
import com.alenbeyond.runoob.greendao.gen.DaoSession;
import com.alenbeyond.runoob.listenter.OnItemClickListener;
import com.alenbeyond.runoob.resource.rxjava.bean.AllOperators;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReRxJavaAllActivity extends BaseActivity {

    @BindView(R.id.rv_rx_java)
    RecyclerView mRvRxJava;

    private String title;
    private long id;
    private RVRxAllAdapter mAdapter;
    private List<AllOperators> datas;

    @Override
    protected void getIntentData() {
        title = getIntent().getStringExtra("title");
        id = getIntent().getLongExtra("id", -1);
    }

    @Override
    public void initWidget() {
        setContentView(R.layout.activity_re_rx_java_all);
        ButterKnife.bind(this);
        setStatusTranslucent();
        initToolBar(title, true);
        LinearLayoutManager lm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRvRxJava.setLayoutManager(lm);
        mRvRxJava.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                switch (newState) {
                    case RecyclerView.SCROLL_STATE_IDLE:
                        Glide.with(ReRxJavaAllActivity.this).onStart();
                        break;
                    case RecyclerView.SCROLL_STATE_DRAGGING:
                        Glide.with(ReRxJavaAllActivity.this).onStop();
                        break;
                }
            }
        });
        mAdapter = new RVRxAllAdapter(this);
        mAdapter.setOnItemClickListener(new OnItemClickListener<AllOperators>() {
            @Override
            public void onItemClickListener(View v, int position, AllOperators allOperators) {
                Intent intent = new Intent(ReRxJavaAllActivity.this, WebActivity.class);
                intent.putExtra(WebActivity.INTENT_TITLE, allOperators.getName());
                intent.putExtra(WebActivity.INTENT_URL, allOperators.getUrl());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void loadData() {
        DaoSession daoSession = App.daoMaster.newSession();
        AllOperatorsDao operatorsDao = daoSession.getAllOperatorsDao();

        datas = operatorsDao.queryBuilder()
                .where(AllOperatorsDao.Properties.Operators_id.eq(id))
                .orderAsc(AllOperatorsDao.Properties.Id)
                .list();

        mAdapter.setDatas(datas);
        mRvRxJava.setAdapter(mAdapter);
    }
}
