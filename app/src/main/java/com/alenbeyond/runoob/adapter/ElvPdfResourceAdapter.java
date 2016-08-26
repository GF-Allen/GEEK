package com.alenbeyond.runoob.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.alenbeyond.runoob.resource.pdf.bean.PdfResource;

import java.util.List;
import java.util.Map;

/**
 * Created by Alen on 2016/8/26.
 */
public class ElvPdfResourceAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<PdfResource> groups;
    private Map<Integer, List<PdfResource.ListsBean>> childs;

    public ElvPdfResourceAdapter(Context context, List<PdfResource> groups, Map<Integer, List<PdfResource.ListsBean>> childs) {
        this.context = context;
        this.groups = groups;
        this.childs = childs;
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return childs.get(i).size();
    }

    @Override
    public Object getGroup(int i) {
        return groups.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return childs.get(i).get(i1).getTitle();
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
