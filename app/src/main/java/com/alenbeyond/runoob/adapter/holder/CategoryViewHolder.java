package com.alenbeyond.runoob.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alenbeyond.runoob.R;

import butterknife.BindView;

/**
 * Created by AlenBeyond on 2016/8/20.
 */
public class CategoryViewHolder extends BaseViewHolder {

    @BindView(R.id.tv_title)
    public TextView tvTitle;
    @BindView(R.id.iv_image)
    public ImageView ivImage;
    @BindView(R.id.tv_des)
    public TextView tvDes;

    public CategoryViewHolder(View itemView) {
        super(itemView);
    }
}
