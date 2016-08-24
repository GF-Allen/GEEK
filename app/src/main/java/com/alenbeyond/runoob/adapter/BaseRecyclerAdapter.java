package com.alenbeyond.runoob.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alenbeyond.runoob.adapter.holder.BaseViewHolder;
import com.alenbeyond.runoob.listenter.OnItemClickListener;

import java.util.List;

/**
 * Created by AlenBeyond on 2016/5/24.
 */
public abstract class BaseRecyclerAdapter<T, B extends BaseViewHolder> extends RecyclerView.Adapter<BaseViewHolder> {

    protected List<T> datas;
    protected Context context;
    protected LayoutInflater mInflater;

    public BaseRecyclerAdapter(Context context) {
        this.context = context;
        init();
    }

    public BaseRecyclerAdapter(List<T> datas, Context context) {
        this.datas = datas;
        this.context = context;
        init();
    }

    private void init() {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * 设置数据
     *
     * @param datas
     */
    public void setDatas(List<T> datas) {
        this.datas = datas;
        this.notifyDataSetChanged();
    }

    @Override
    public abstract B onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(BaseViewHolder holder, final int position) {
        if (datas == null) {
            new Throwable("请设置数据");
        }
        if (onItemClickListener != null) {
            holder.mRootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClickListener(view, position, datas.get(position));
                }
            });
        }
        onBindViewData((B) holder, position);
    }

    public abstract void onBindViewData(B holder, int position);

    @Override
    public int getItemCount() {
        return datas.size();
    }

    protected OnItemClickListener<T> onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
