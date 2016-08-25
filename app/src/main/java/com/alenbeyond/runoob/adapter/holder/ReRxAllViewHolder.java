package com.alenbeyond.runoob.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alenbeyond.runoob.R;

import butterknife.BindView;

/**
 * Created by Alen on 2016/8/25.
 */
public class ReRxAllViewHolder extends BaseViewHolder {

    @BindView(R.id.tv_title)
    public TextView tvTitle;
    @BindView(R.id.tv_des)
    public TextView tvDes;
    @BindView(R.id.tv_type)
    public TextView tvType;
    @BindView(R.id.iv_image)
    public ImageView ivImage;

    public ReRxAllViewHolder(View itemView) {
        super(itemView);
    }
}
