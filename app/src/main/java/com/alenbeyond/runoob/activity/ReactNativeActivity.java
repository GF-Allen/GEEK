package com.alenbeyond.runoob.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;

import com.alenbeyond.runoob.App;
import com.alenbeyond.runoob.R;
import com.alenbeyond.runoob.activity.base.BaseActivity;
import com.alenbeyond.runoob.adapter.VPReactNativeAdapter;
import com.alenbeyond.runoob.greendao.bean.RNApiGroup;
import com.alenbeyond.runoob.greendao.gen.DaoSession;
import com.alenbeyond.runoob.greendao.gen.RNApiGroupDao;
import com.alenbeyond.runoob.rx.ApiManager;
import com.alenbeyond.runoob.rx.MyObserver;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReactNativeActivity extends BaseActivity {

    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.vp_react_native)
    ViewPager vpReactNative;

    private String title;

    @Override
    protected void getIntentData() {
        title = getIntent().getStringExtra("title");
    }

    @Override
    public void initWidget() {
        setContentView(R.layout.activity_react_native);
        ButterKnife.bind(this);
        setStatusTranslucent();
        initToolBar(title, true);
    }

    @Override
    protected void loadData() {
        DaoSession daoSession = App.daoMaster.newSession();
        RNApiGroupDao rnApiGroupDao = daoSession.getRNApiGroupDao();
        List<RNApiGroup> datas = rnApiGroupDao.queryBuilder().list();
        vpReactNative.setAdapter(new VPReactNativeAdapter(ReactNativeActivity.this, datas));
        tabs.setupWithViewPager(vpReactNative);
    }
}
