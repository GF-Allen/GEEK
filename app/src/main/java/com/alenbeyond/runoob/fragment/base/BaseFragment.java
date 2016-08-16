package com.alenbeyond.runoob.fragment.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alenbeyond.runoob.utils.NetUtils;
import com.alenbeyond.runoob.utils.UiUtils;

import butterknife.ButterKnife;

/**
 * Created by Alen on 2016/8/16.
 */
public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = setContentView();
        ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    protected abstract View setContentView();

    /**
     * 初始化View
     *
     * @return
     */
    protected void initView() {

    }

    /**
     * 初始化数据
     */
    protected void initData() {
        if (NetUtils.isOnline(getContext())) {
            loadData();
        } else {
            Snackbar.make(UiUtils.getRootView(getActivity()), "请检查网络", Snackbar.LENGTH_INDEFINITE).setAction("重试", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    initData();
                }
            }).show();
        }
    }

    /**
     * 加载数据
     */
    protected void loadData() {

    }
}
