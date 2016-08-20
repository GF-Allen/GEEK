package com.alenbeyond.runoob.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.alenbeyond.runoob.R;
import com.alenbeyond.runoob.adapter.holder.ChapterViewHolder;
import com.alenbeyond.runoob.greendao.bean.RunoobChapter;

import java.util.List;

/**
 * Created by AlenBeyond on 2016/5/24.
 */
public class RVChapterAdapter extends BaseRecyclerAdapter<RunoobChapter,ChapterViewHolder> {

    public RVChapterAdapter(List<RunoobChapter> datas,Context context) {
        super(datas,context);
    }

    @Override
    public ChapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.adapter_item_chapter, parent, false);

        return new ChapterViewHolder(view);
    }

    @Override
    public void onBindViewData(ChapterViewHolder holder, int position) {
        holder.tvTitle.setText(datas.get(position).getTitle());
    }

}
