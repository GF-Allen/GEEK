package com.alenbeyond.runoob.activity;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ExpandableListView;

import com.alenbeyond.runoob.R;
import com.alenbeyond.runoob.activity.base.BaseActivity;
import com.alenbeyond.runoob.resource.pdf.bean.PdfResource;
import com.alenbeyond.runoob.rx.ApiManager;
import com.alenbeyond.runoob.rx.MyObserver;
import com.orhanobut.logger.Logger;
import com.zaihuishou.expandablerecycleradapter.adapter.BaseExpandableAdapter;
import com.zaihuishou.expandablerecycleradapter.model.ExpandableListItem;
import com.zaihuishou.expandablerecycleradapter.viewholder.AbstractAdapterItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PdfResourceActivity extends BaseActivity {

    @BindView(R.id.elv_pdf_resource)
    ExpandableListView elvPdfResource;

    private String title;

    @Override
    protected void getIntentData() {
        title = getIntent().getStringExtra("title");
    }

    @Override
    public void initWidget() {
        setContentView(R.layout.activity_pdf_resource);
        ButterKnife.bind(this);
        setStatusTranslucent();
        initToolBar(title, true);
    }

    @Override
    protected void loadData() {
        ApiManager.getObPdfResources(new MyObserver<List<PdfResource>>() {
            @Override
            public void onNext(List<PdfResource> pdfResources) {
                Logger.d(pdfResources);
            }
        });
    }
}
