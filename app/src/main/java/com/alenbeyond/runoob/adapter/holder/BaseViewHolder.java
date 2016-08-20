package com.alenbeyond.runoob.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by AlenBeyond on 2016/8/20.
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {

    public View mRootView;

    public BaseViewHolder(View itemView) {
        super(itemView);
        mRootView = itemView;
        ButterKnife.bind(this, mRootView);
    }
}
