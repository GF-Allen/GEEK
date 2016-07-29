package com.alen.runoob.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.widget.Toast;

import com.alen.runoob.R;
import com.alen.runoob.activity.base.BaseActivity;
import com.alen.runoob.adapter.VPCategoryAdapter;
import com.alen.runoob.bean.Category;
import com.alen.runoob.rx.ApiManager;
import com.alen.runoob.rx.MyObserver;

import java.util.List;

public class CategoryActivity extends BaseActivity {

    private Toolbar toolbar;
    private TabLayout tabs;
    private ViewPager vpCategory;

    @Override
    public void initWidget() {
        setContentView(R.layout.activity_category);
        toolbar = findView(R.id.toolbar);
        tabs = findView(R.id.tabs);
        vpCategory = findView(R.id.vp_category);

        toolbar.setTitle("IT教程");
        setSupportActionBar(toolbar);
    }

    @Override
    protected void loadServer() {
        ApiManager.getObCategory(new MyObserver<List<Category>>() {
            @Override
            public void onNext(List<Category> categories) {
                vpCategory.setAdapter(new VPCategoryAdapter(CategoryActivity.this, categories));
                tabs.setupWithViewPager(vpCategory);
            }
        });
    }

    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
