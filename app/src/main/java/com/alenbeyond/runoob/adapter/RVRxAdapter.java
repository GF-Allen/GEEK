package com.alenbeyond.runoob.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.alenbeyond.runoob.R;
import com.alenbeyond.runoob.adapter.holder.ReRxViewHolder;
import com.alenbeyond.runoob.resource.rxjava.bean.Operators;

import java.util.List;

/**
 * Created by Alen on 2016/8/25.
 */
public class RVRxAdapter extends BaseRecyclerAdapter<Operators, ReRxViewHolder> {
    public RVRxAdapter(Context context) {
        super(context);
    }

    public RVRxAdapter(List<Operators> datas, Context context) {
        super(datas, context);
    }

    @Override
    public ReRxViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.adapter_item_chapter, parent, false);
        return new ReRxViewHolder(view);
    }

    @Override
    public void onBindViewData(ReRxViewHolder holder, int position) {
        holder.tvTitle.setText(datas.get(position).getName());
    }
}
