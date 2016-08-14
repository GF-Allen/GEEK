package com.alen.runoob.activity;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.alen.runoob.App;
import com.alen.runoob.R;
import com.alen.runoob.activity.base.BaseActivity;
import com.alen.runoob.adapter.RVChapterAdapter;
import com.alen.runoob.greendao.bean.RunoobChapter;
import com.alen.runoob.greendao.gen.DaoSession;
import com.alen.runoob.greendao.gen.RunoobChapterDao;
import com.alen.runoob.listenter.OnItemClickListener;
import com.alen.runoob.rx.ApiManager;
import com.alen.runoob.rx.MyObserver;
import com.alen.runoob.utils.CircularAnim;
import com.orhanobut.logger.Logger;

import java.util.List;

public class ChapterActivity extends BaseActivity {

    private Toolbar toolbar;
    private RecyclerView rvChapter;
    private long id;
    private RunoobChapterDao chapterDao;

    @Override
    public void initWidget() {
        setContentView(R.layout.activity_chapter);
        toolbar = findView(R.id.toolbar);
        rvChapter = findView(R.id.rv_chapter);
    }

    @Override
    protected void loadServer() {
        DaoSession daoSession = App.daoMaster.newSession();
        chapterDao = daoSession.getRunoobChapterDao();
        String url = getIntent().getStringExtra("url");
        id = getIntent().getLongExtra("id", -1);

        List<RunoobChapter> runoobChapters = chapterDao.queryBuilder()
                .where(RunoobChapterDao.Properties.ItemId.eq(id)).orderAsc(RunoobChapterDao.Properties.Id).list();
        Logger.d(runoobChapters);
        if (runoobChapters.size() != 0) {
            setData(runoobChapters);
        } else {
            ApiManager.getObChapter(url, new MyObserver<List<RunoobChapter>>() {
                @Override
                public void onNext(final List<RunoobChapter> runoobChapters) {
                    saveCache(runoobChapters);
                    setData(runoobChapters);
                }
            });
        }
    }

    private void setData(final List<RunoobChapter> runoobChapters) {
        rvChapter.setLayoutManager(new GridLayoutManager(ChapterActivity.this, 1));
        RVChapterAdapter adapter = new RVChapterAdapter(ChapterActivity.this, runoobChapters);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                String link = runoobChapters.get(position).getLink();
                String title = runoobChapters.get(position).getTitle();
                Intent intent = new Intent(ChapterActivity.this, DetailActivity.class);
                intent.putExtra("url", link);
                intent.putExtra("title", title);
                Logger.d(title + ":" + link);
                CircularAnim.startActivity(ChapterActivity.this, intent, v, R.color.colorPrimary);
            }
        });
        rvChapter.setAdapter(adapter);
    }

    private void saveCache(final List<RunoobChapter> runoobChapters) {
        new Thread() {
            @Override
            public void run() {
                for (RunoobChapter runoobChapter : runoobChapters) {
                    runoobChapter.setItemId(id);
                    chapterDao.insert(runoobChapter);
                }
            }
        }.start();
    }

    @Override
    public void initData() {
        String title = getIntent().getStringExtra("title");
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        super.initData();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
