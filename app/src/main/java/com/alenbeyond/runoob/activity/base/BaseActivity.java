package com.alenbeyond.runoob.activity.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alenbeyond.runoob.R;
import com.alenbeyond.runoob.utils.NetUtils;
import com.alenbeyond.runoob.utils.UiUtils;
import com.alenbeyond.runoob.utils.ViewUtils;

/**
 * Created by AlenBeyond on 2016/5/23.
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            // 创建TextView,为了设置StatusBar的颜色
            TextView textView = new TextView(this);
            LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewUtils.getStatusBarHeight(this));
            textView.setBackgroundResource(R.color.colorPrimary);
            textView.setLayoutParams(lParams);
            // 获得根视图并把TextView加进去。
            ViewGroup view = (ViewGroup) getWindow().getDecorView();
            view.addView(textView);
        }
        initWidget();
        setListener();
        initData();
    }

    public <T extends View> T findView(@IdRes int id) {
        return (T) findViewById(id);
    }

    /**
     * 初始化组件
     **/
    public abstract void initWidget();

    /**
     * 设置监听事件
     **/
    public void setListener() {

    }

    /**
     * 初始化数据
     **/
    public void initData() {
        if (NetUtils.isOnline(this)) {
            loadData();
        } else {
            Snackbar.make(UiUtils.getRootView(this), "请检查网络", Snackbar.LENGTH_INDEFINITE).setAction("重试", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    initData();
                }
            }).show();
        }
    }

    /**
     * 加载数据
     */
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        widgetClick(v);
    }

    /**
     * 控件的点击事件处理
     *
     * @param v
     */
    public void widgetClick(View v) {
    }
}
