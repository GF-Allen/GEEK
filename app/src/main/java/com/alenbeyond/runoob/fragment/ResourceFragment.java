package com.alenbeyond.runoob.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alenbeyond.runoob.R;
import com.alenbeyond.runoob.adapter.RVResourceAdapter;
import com.alenbeyond.runoob.fragment.base.BaseFragment;
import com.alenbeyond.runoob.greendao.bean.MainResource;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by AlenBeyond on 2016/8/17.
 */
public class ResourceFragment extends BaseFragment {

    @BindView(R.id.rv_resource)
    RecyclerView mRvResource;

    @Override
    protected View setContentView() {
        return View.inflate(getContext(), R.layout.fragment_resource, null);
    }

    @Override
    protected void initView() {
        LinearLayoutManager lm = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRvResource.setLayoutManager(lm);
    }

    @Override
    protected void loadData() {
        ArrayList<MainResource> datas = new ArrayList<>();
        datas.add(new MainResource(R.mipmap.ic_launcher, "在线阅读"));
        datas.add(new MainResource(R.mipmap.ic_launcher, "1111111"));
        datas.add(new MainResource(R.mipmap.ic_launcher, "2222222"));
        datas.add(new MainResource(R.mipmap.ic_launcher, "3333333"));
        datas.add(new MainResource(R.mipmap.ic_launcher, "4444444"));
        RVResourceAdapter adapter = new RVResourceAdapter(datas, getContext());
        mRvResource.setAdapter(adapter);
    }
}
