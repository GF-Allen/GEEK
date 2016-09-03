package com.alenbeyond.runoob.fragment;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.alenbeyond.runoob.App;
import com.alenbeyond.runoob.R;
import com.alenbeyond.runoob.activity.MainActivity;
import com.alenbeyond.runoob.adapter.VPReactNativeAdapter;
import com.alenbeyond.runoob.fragment.base.BaseFragment;
import com.alenbeyond.runoob.greendao.bean.RNApiGroup;
import com.alenbeyond.runoob.greendao.gen.DaoSession;
import com.alenbeyond.runoob.greendao.gen.RNApiGroupDao;

import java.util.List;

import butterknife.BindView;

/**
 * Created by AlenBeyond on 2016/9/3.
 */
public class ReactFragment extends BaseFragment {

    @BindView(R.id.vp_react_native)
    ViewPager vpReactNative;

    @Override
    protected View setContentView() {
        return View.inflate(getContext(), R.layout.fragment_react, null);
    }

    @Override
    protected void loadData() {
        DaoSession daoSession = App.daoMaster.newSession();
        RNApiGroupDao rnApiGroupDao = daoSession.getRNApiGroupDao();
        List<RNApiGroup> datas = rnApiGroupDao.queryBuilder().list();
        vpReactNative.setAdapter(new VPReactNativeAdapter(getContext(), datas));
        setupTabs();
    }

    public void setupTabs() {
        MainActivity m = (MainActivity) getActivity();
        m.mTabs.removeAllTabs();
        m.mTabs.setupWithViewPager(vpReactNative);
    }
}
