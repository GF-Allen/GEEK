package com.alenbeyond.runoob.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.alenbeyond.runoob.R;
import com.alenbeyond.runoob.adapter.holder.CategoryViewHolder;
import com.alenbeyond.runoob.greendao.bean.RunoobItem;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by AlenBeyond on 2016/5/23.
 */
public class RVCategoryAdapter extends BaseRecyclerAdapter<RunoobItem, CategoryViewHolder> {

    public RVCategoryAdapter(List<RunoobItem> datas, Context context) {
        super(datas, context);
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.adapter_item_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewData(CategoryViewHolder holder, int position) {
        RunoobItem data = datas.get(position);
        holder.tvTitle.setText(data.getTitle());
        holder.tvDes.setText(data.getDes());
        Glide.with(context).load(data.getImage()).into(holder.ivImage);
    }
}
