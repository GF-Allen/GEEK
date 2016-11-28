package com.alenbeyond.runoob.activity;

import android.net.Uri;
import android.os.Environment;
import android.support.annotation.Nullable;

import com.alenbeyond.runoob.R;
import com.alenbeyond.runoob.activity.base.BaseActivity;
import com.alenbeyond.runoob.utils.UiUtils;
import com.github.barteksc.pdfviewer.PDFView;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.FileCallback;
import com.orhanobut.logger.Logger;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

public class TestActivity extends BaseActivity {

    public static final String url = "http://study.anycodes.cn/index.php?mod=document&op=pdfviewer&path=NmY2M29zQUI0YkV2WW1LRC93cjV5cXd3TlBiZ1FSNnBsZkE1S2FaUEhXUXk=";

    @BindView(R.id.pdfView)
    PDFView pdfView;

    @Override
    public void initWidget() {
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
    }

    @Override
    protected void loadData() {
        OkHttpUtils.get(url)
                .tag(this)
                .execute(new FileCallback(Environment.getExternalStorageDirectory().getAbsolutePath(), "123.pdf") {
                    @Override
                    public void onSuccess(File file, Call call, Response response) {
                        Logger.d(file.getAbsolutePath().toString());
                        pdfView.fromFile(file)
                                .swipeHorizontal(false)
                                .enableDoubletap(true)
                                .defaultPage(0)
                                .enableAnnotationRendering(false)
                                .password(null)
                                .scrollHandle(null)
                                .load();
                    }

                    @Override
                    public void downloadProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                        UiUtils.showToast(TestActivity.this, "进度:" + progress);
                    }
                });
    }
}
