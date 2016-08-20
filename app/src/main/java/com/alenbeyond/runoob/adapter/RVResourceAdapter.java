package com.alenbeyond.runoob.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.alenbeyond.runoob.R;
import com.alenbeyond.runoob.adapter.holder.RvResourceViewHolder;
import com.alenbeyond.runoob.greendao.bean.MainResource;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by AlenBeyond on 2016/8/20.
 */
public class RVResourceAdapter extends BaseRecyclerAdapter<MainResource, RvResourceViewHolder> {

    public RVResourceAdapter(Context context) {
        super(context);
    }

    public RVResourceAdapter(List<MainResource> datas, Context context) {
        super(datas, context);
    }

    @Override
    public RvResourceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = View.inflate(context, R.layout.adapter_item_resource, parent);
        View view = mInflater.inflate(R.layout.adapter_item_resource, parent, false);
        return new RvResourceViewHolder(view);
    }

    @Override
    public void onBindViewData(RvResourceViewHolder holder, int position) {
        MainResource data = datas.get(position);
        holder.tvTitle.setText(data.getTitle());
        Glide.with(context).load(data.getDrawableID()).asBitmap().into(holder.ivIcon);
    }

}
