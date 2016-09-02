package com.alenbeyond.runoob.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.alenbeyond.runoob.App;
import com.alenbeyond.runoob.R;
import com.alenbeyond.runoob.activity.WebActivity;
import com.alenbeyond.runoob.greendao.bean.RNApiGroup;
import com.alenbeyond.runoob.greendao.bean.RNApiSub;
import com.alenbeyond.runoob.greendao.gen.DaoSession;
import com.alenbeyond.runoob.greendao.gen.RNApiSubDao;
import com.alenbeyond.runoob.listenter.OnItemClickListener;
import com.alenbeyond.runoob.rx.ApiManager;
import com.alenbeyond.runoob.rx.MyObserver;
import com.orhanobut.logger.Logger;

import java.util.List;

/**
 * Created by Alen on 2016/9/2.
 */
public class VPReactNativeAdapter extends PagerAdapter {

    private Context context;
    private List<RNApiGroup> datas;
    private RNApiSubDao mRnApiSubDao;

    public VPReactNativeAdapter(Context context) {
        this.context = context;
    }

    public VPReactNativeAdapter(Context context, List<RNApiGroup> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        final DaoSession daoSession = App.daoMaster.newSession();
        mRnApiSubDao = daoSession.getRNApiSubDao();

        final View view = View.inflate(context, R.layout.adapter_item_react_native, null);
        final SwipeRefreshLayout swlRefresh = (SwipeRefreshLayout) view.findViewById(R.id.srl_refresh);
        final RecyclerView rvReact = (RecyclerView) view.findViewById(R.id.rv_react);
        rvReact.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        final RVReactNativeAdapter adapter = new RVReactNativeAdapter(context);

        swlRefresh.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent, R.color.colorGray);
        swlRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ApiManager.getObRNApiSub(datas.get(position).getReactId(), new MyObserver<List<RNApiSub>>() {
                    @Override
                    public void onNext(List<RNApiSub> rnApiSubs) {
                        adapter.setDatas(rnApiSubs);
                        rvReact.setAdapter(adapter);
                        mRnApiSubDao.insertInTx(rnApiSubs);
                        swlRefresh.setRefreshing(false);
                    }
                });
            }
        });
        adapter.setOnItemClickListener(new OnItemClickListener<RNApiSub>() {
            @Override
            public void onItemClickListener(View v, int position, RNApiSub rnApiSub) {
                Intent intent = new Intent(context, WebActivity.class);
                intent.putExtra(WebActivity.INTENT_TITLE, rnApiSub.getName());
                intent.putExtra(WebActivity.INTENT_URL, rnApiSub.getUrl());
                context.startActivity(intent);
            }
        });
        List<RNApiSub> subs = mRnApiSubDao.queryBuilder().where(RNApiSubDao.Properties.GroupId.eq
                (datas.get(position).getReactId())).build().list();
        if (subs == null || subs.size() == 0) {
            ApiManager.getObRNApiSub(datas.get(position).getReactId(), new MyObserver<List<RNApiSub>>() {
                @Override
                public void onNext(List<RNApiSub> rnApiSubs) {
                    adapter.setDatas(rnApiSubs);
                    rvReact.setAdapter(adapter);
                    mRnApiSubDao.insertInTx(rnApiSubs);
                    swlRefresh.setRefreshing(false);
                }
            });
        } else {
            adapter.setDatas(subs);
            rvReact.setAdapter(adapter);
            swlRefresh.setRefreshing(false);
        }

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return datas.get(position).getName();
    }
}
