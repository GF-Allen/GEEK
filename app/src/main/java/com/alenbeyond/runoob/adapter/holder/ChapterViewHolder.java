package com.alenbeyond.runoob.adapter.holder;

import android.view.View;
import android.widget.TextView;

import com.alenbeyond.runoob.R;

import butterknife.BindView;

/**
 * Created by AlenBeyond on 2016/8/20.
 */
public class ChapterViewHolder extends BaseViewHolder {

    @BindView(R.id.tv_title)
    public TextView tvTitle;

    public ChapterViewHolder(View itemView) {
        super(itemView);
    }
}
