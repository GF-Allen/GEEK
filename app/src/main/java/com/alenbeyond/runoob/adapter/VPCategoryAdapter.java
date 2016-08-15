package com.alenbeyond.runoob.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.alenbeyond.runoob.R;
import com.alenbeyond.runoob.activity.ChapterActivity;
import com.alenbeyond.runoob.greendao.bean.RunoobCategory;
import com.alenbeyond.runoob.greendao.bean.RunoobItem;
import com.alenbeyond.runoob.listenter.OnItemClickListener;
import com.alenbeyond.runoob.utils.CircularAnim;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by AlenBeyond on 2016/5/24.
 */
public class VPCategoryAdapter extends PagerAdapter {

    private Activity context;
    private List<RunoobCategory> datas;

    public VPCategoryAdapter(Activity context, List<RunoobCategory> datas) {
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
        final List<RunoobItem> runoobItems = datas.get(position).getRunoobItem();
        v.setLayoutManager(new GridLayoutManager(context, 1));
        RVCategoryAdapter adapter = new RVCategoryAdapter(runoobItems, context);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                String link = runoobItems.get(position).getLink();
                String title = runoobItems.get(position).getTitle();
                Long id = runoobItems.get(position).getId();
                Intent intent = new Intent(context, ChapterActivity.class);
                intent.putExtra("url", link);
                intent.putExtra("title", title);
                intent.putExtra("id", id);
                CircularAnim.startActivity(context, intent, v, R.color.colorPrimary);
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
