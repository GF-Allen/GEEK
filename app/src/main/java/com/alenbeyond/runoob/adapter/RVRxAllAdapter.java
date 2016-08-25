package com.alenbeyond.runoob.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.alenbeyond.runoob.R;
import com.alenbeyond.runoob.adapter.holder.ReRxAllViewHolder;
import com.alenbeyond.runoob.resource.rxjava.bean.AllOperators;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Alen on 2016/8/25.
 */
public class RVRxAllAdapter extends BaseRecyclerAdapter<AllOperators, ReRxAllViewHolder> {
    public RVRxAllAdapter(Context context) {
        super(context);
    }

    public RVRxAllAdapter(List<AllOperators> datas, Context context) {
        super(datas, context);
    }

    @Override
    public ReRxAllViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.adapter_item_alloperators, parent, false);
        return new ReRxAllViewHolder(view);
    }

    @Override
    public void onBindViewData(ReRxAllViewHolder holder, int position) {
        AllOperators allOperators = datas.get(position);
        holder.tvTitle.setText(allOperators.getName());
        holder.tvType.setText(allOperators.getThread());
        holder.tvDes.setText(allOperators.getDesc());
        Glide.with(context).load(allOperators.getImg()).asBitmap()
                .placeholder(R.mipmap.rx_java).into(holder.ivImage);
    }
}
