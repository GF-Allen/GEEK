package com.alen.runoob.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by AlenBeyond on 2016/5/24.
 */
public class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<BaseRecyclerAdapter.BaseViewHolder> {

    protected List<T> datas;
    protected Context context;

    public BaseRecyclerAdapter(Context context) {
        this.context = context;
    }

    /**
     * 设置数据
     * @param datas
     */
    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public static class BaseViewHolder extends RecyclerView.ViewHolder {

        public BaseViewHolder(View itemView) {
            super(itemView);
        }
    }
}
