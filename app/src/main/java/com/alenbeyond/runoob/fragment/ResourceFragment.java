package com.alenbeyond.runoob.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alenbeyond.runoob.R;
import com.alenbeyond.runoob.activity.ReRxJavaActivity;
import com.alenbeyond.runoob.activity.ReRxJavaAllActivity;
import com.alenbeyond.runoob.activity.WebActivity;
import com.alenbeyond.runoob.adapter.RVResourceAdapter;
import com.alenbeyond.runoob.fragment.base.BaseFragment;
import com.alenbeyond.runoob.greendao.bean.MainResource;
import com.alenbeyond.runoob.listenter.OnItemClickListener;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by AlenBeyond on 2016/8/17.
 */
public class ResourceFragment extends BaseFragment {

    public static final String TYPE_URL = "type_url";

    /**
     * 在线阅读
     */
    private static final String TYPE_ONLINE_READER = "type_online_reader";

    /**
     * 在线测试
     */
    private static final String TYPE_ONLINE_TEST = "type_online_test";

    /**
     * Rxjava
     */
    public static final String TYPE_RXJAVA = "type_rxjava";

    @BindView(R.id.rv_resource)
    RecyclerView mRvResource;
    private RVResourceAdapter mAdapter;

    @Override
    protected View setContentView() {
        return View.inflate(getContext(), R.layout.fragment_resource, null);
    }

    @Override
    protected void initView() {
        LinearLayoutManager lm = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRvResource.setLayoutManager(lm);
        mAdapter = new RVResourceAdapter(getContext());
        mAdapter.setOnItemClickListener(new OnItemClickListener<MainResource>() {
            @Override
            public void onItemClickListener(View v, int position, MainResource data) {
                checkData(data);
            }
        });
    }

    private void checkData(MainResource data) {
        switch (data.getType()) {
            case TYPE_URL:
                Intent intent = new Intent(getContext(), WebActivity.class);
                intent.putExtra(WebActivity.INTENT_TITLE, data.getTitle());
                intent.putExtra(WebActivity.INTENT_URL, data.getUrl());
                startActivity(intent);
                break;
            case TYPE_RXJAVA:
                startActivity(new Intent(getContext(), ReRxJavaActivity.class).putExtra("title", data.getTitle()));
                break;
        }
    }

    @Override
    protected void loadData() {
        ArrayList<MainResource> datas = new ArrayList<>();

        datas.add(new MainResource(R.mipmap.ic_launcher, "在线阅读", "", TYPE_ONLINE_READER));
        datas.add(new MainResource(R.mipmap.ic_launcher, "在线测试", "", TYPE_ONLINE_TEST));
        datas.add(new MainResource(R.mipmap.ic_launcher, "RxJava", "", TYPE_RXJAVA));
        datas.add(new MainResource(R.mipmap.ic_launcher, "3333333", "", ""));
        datas.add(new MainResource(R.mipmap.ic_launcher, "4444444", "", ""));
        mAdapter.setDatas(datas);
        mRvResource.setAdapter(mAdapter);
    }
}
