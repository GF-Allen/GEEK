package com.alenbeyond.runoob.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.alenbeyond.runoob.R;
import com.alenbeyond.runoob.adapter.holder.RvReactNativeViewHolder;
import com.alenbeyond.runoob.greendao.bean.RNApiSub;

import java.util.List;

/**
 * Created by Alen on 2016/9/2.
 */
public class RVReactNativeAdapter extends BaseRecyclerAdapter<RNApiSub, RvReactNativeViewHolder> {
    public RVReactNativeAdapter(Context context) {
        super(context);
    }

    public RVReactNativeAdapter(List<RNApiSub> datas, Context context) {
        super(datas, context);
    }

    @Override
    public RvReactNativeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.adapter_item_chapter, parent, false);
        return new RvReactNativeViewHolder(view);
    }

    @Override
    public void onBindViewData(RvReactNativeViewHolder holder, int position) {
        holder.tvTitle.setText(datas.get(position).getName());
    }
}
