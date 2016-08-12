package com.alen.runoob.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alen.runoob.R;
import com.alen.runoob.greendao.bean.RunoobItem;
import com.alen.runoob.listenter.OnItemClickListener;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Jeff on 2016/5/23.
 */
public class RVCategoryAdapter extends RecyclerView.Adapter<RVCategoryAdapter.ViewHolder> {

    private List<RunoobItem> datas;
    private Context context;

    public RVCategoryAdapter(List<RunoobItem> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.adapter_item_category, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        RunoobItem data = datas.get(position);
        holder.tvTitle.setText(data.getTitle());
        holder.tvDes.setText(data.getDes());
        Glide.with(context).load(data.getImage()).into(holder.ivImage);
        if (onItemClickListener != null) {
            holder.rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClickListener(v, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    private OnItemClickListener onItemClickListener;

    /**
     * 设置Item点击事件
     *
     * @param onItemClickListener
     */
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        public View rootView;

        public TextView tvTitle;
        public ImageView ivImage;
        public TextView tvDes;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            ivImage = (ImageView) itemView.findViewById(R.id.iv_image);
            tvDes = (TextView) itemView.findViewById(R.id.tv_des);
            rootView = itemView;
        }
    }
}
