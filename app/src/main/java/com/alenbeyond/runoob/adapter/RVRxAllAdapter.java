package com.alenbeyond.runoob.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.View;
import android.view.ViewGroup;

import com.alenbeyond.runoob.R;
import com.alenbeyond.runoob.adapter.holder.ReRxAllViewHolder;
import com.alenbeyond.runoob.resource.rxjava.bean.AllOperators;
import com.alenbeyond.runoob.utils.BitmapUtils;
import com.alenbeyond.runoob.utils.UiUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

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
    public void onBindViewData(final ReRxAllViewHolder holder, int position) {
        AllOperators allOperators = datas.get(position);
        holder.tvTitle.setText(allOperators.getName());
        holder.tvType.setText(allOperators.getThread());
        holder.tvDes.setText(allOperators.getDesc());
//        Glide.with(context).load(allOperators.getImg()).asBitmap()
//                .placeholder(R.mipmap.rx_java).into(holder.ivImage);
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.rx_java);
        Drawable drawable = BitmapUtils.createCornerDrawable(context, bitmap, UiUtils.dip2px(context, 5));
        Glide.with(context).load(allOperators.getImg()).asBitmap().placeholder(drawable).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                Drawable drawable = BitmapUtils.createCornerDrawable(context, resource, UiUtils.dip2px(context, 5));
                holder.ivImage.setImageDrawable(drawable);
            }
        });
//        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.rx_java);
//        RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(context.getResources(), bitmap);
//        drawable.setCircular(true);
//        holder.ivImage.setImageDrawable(drawable);
    }
}
