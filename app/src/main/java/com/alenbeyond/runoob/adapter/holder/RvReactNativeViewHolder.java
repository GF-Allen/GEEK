package com.alenbeyond.runoob.adapter.holder;

import android.view.View;
import android.widget.TextView;

import com.alenbeyond.runoob.R;

import butterknife.BindView;

/**
 * Created by Alen on 2016/9/2.
 */
public class RvReactNativeViewHolder extends BaseViewHolder {

    @BindView(R.id.tv_title)
    public TextView tvTitle;

    public RvReactNativeViewHolder(View itemView) {
        super(itemView);
    }
}
