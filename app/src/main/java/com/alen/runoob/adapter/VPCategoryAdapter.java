package com.alen.runoob.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.alen.runoob.activity.ChapterActivity;
import com.alen.runoob.bean.Category;
import com.alen.runoob.listenter.OnItemClickListener;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeff on 2016/5/24.
 */
public class VPCategoryAdapter extends PagerAdapter {

    private Context context;
    private List<Category> datas;

    public VPCategoryAdapter(Context context, List<Category> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, int position) {

        RecyclerView v = new RecyclerView(context);
        v.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                switch (newState) {
                    case RecyclerView.SCROLL_STATE_IDLE:
                        Glide.with(context).onStart();
                        break;
                    case RecyclerView.SCROLL_STATE_DRAGGING:
                        Glide.with(context).onStop();
                        break;
                }
            }
        });
        final ArrayList<Category.Item> items = datas.get(position).getItem();
        v.setLayoutManager(new GridLayoutManager(context, 1));
        RVCategoryAdapter adapter = new RVCategoryAdapter(items, context);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                String link = items.get(position).getLink();
                String title = items.get(position).getTitle();
                Intent intent = new Intent(context, ChapterActivity.class);
                intent.putExtra("url", link);
                intent.putExtra("title", title);
                context.startActivity(intent);
            }
        });
        v.setAdapter(adapter);
        container.addView(v);

        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return datas.get(position).getTitle();
    }
}
