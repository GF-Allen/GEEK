package com.alenbeyond.runoob.activity;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.alenbeyond.runoob.R;
import com.alenbeyond.runoob.activity.base.BaseActivity;
import com.alenbeyond.runoob.fragment.OnlineCodingFragment;
import com.alenbeyond.runoob.fragment.RunoobFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tabs)
    public TabLayout mTabs;
    @BindView(R.id.navigation_view)
    NavigationView mNavigationView;
    private RunoobFragment runoobFragment;
    private Fragment currentFragment;//当前显示的
    private OnlineCodingFragment onlineCodingFragment;

    @Override
    public void initWidget() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mToolbar.setTitle(getResources().getString(R.string.nav_runoob));
        setSupportActionBar(mToolbar);
        //绑定toolbar的按钮
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar,
                R.string.drawer_open, R.string.drawer_close);
        mDrawerToggle.syncState();//初始化状态
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        //设置导航栏NavigationView的点击事件
        mNavigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void loadData() {
        runoobFragment = new RunoobFragment(this);
        switchFragment(null, runoobFragment);
        mNavigationView.getMenu().findItem(R.id.nav_runoob).setChecked(true);
//        DaoSession daoSession = App.daoMaster.newSession();
//        RunoobCategoryDao categoryDao = daoSession.getRunoobCategoryDao();
//        List<RunoobCategory> categories = categoryDao.queryBuilder().list();
//
//        mVpCategory.setAdapter(new VPCategoryAdapter(MainActivity.this, categories));
//        mTabs.setupWithViewPager(mVpCategory);
////        ApiManager.getObCategory(new MyObserver<List<RunoobCategory>>() {
////            @Override
////            public void onNext(List<RunoobCategory> categories) {
////                mVpCategory.setAdapter(new VPCategoryAdapter(MainActivity.this, categories));
////                mTabs.setupWithViewPager(mVpCategory);
////            }
////        });
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

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_runoob:
                mTabs.setVisibility(View.VISIBLE);
                if (runoobFragment == null) {
                    runoobFragment = new RunoobFragment(this);
                }
                switchFragment(currentFragment, runoobFragment);
                mToolbar.setTitle(getResources().getString(R.string.nav_runoob));
                item.setChecked(true);
                break;
            case R.id.nav_online_coding:
                mTabs.setVisibility(View.GONE);
                if (onlineCodingFragment == null) {
                    onlineCodingFragment = new OnlineCodingFragment();
                }
                switchFragment(currentFragment, onlineCodingFragment);
                mToolbar.setTitle(getResources().getString(R.string.nav_online_coding));
                item.setChecked(true);
                break;
        }
        return false;
    }

    /**
     * 切换页面的重载，优化了fragment的切换
     */
    public void switchFragment(Fragment from, Fragment to) {
        if (to == null)
            return;
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        if (from != null) {
            transaction.hide(from);
        }
        if (!to.isAdded()) {
            transaction.add(R.id.fl_content, to, to.getClass().getSimpleName()).commit();
        } else {
            transaction.show(to).commit();
        }
        currentFragment = to;
        mDrawerLayout.closeDrawers();
    }
}
