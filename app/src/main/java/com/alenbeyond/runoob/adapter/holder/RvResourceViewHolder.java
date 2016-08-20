package com.alenbeyond.runoob.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alenbeyond.runoob.R;

import butterknife.BindView;

/**
 * Created by AlenBeyond on 2016/8/20.
 */
public class RvResourceViewHolder extends BaseViewHolder {

    @BindView(R.id.iv_icon)
    public ImageView ivIcon;
    @BindView(R.id.tv_title)
    public TextView tvTitle;

    public RvResourceViewHolder(View itemView) {
        super(itemView);
    }
}
