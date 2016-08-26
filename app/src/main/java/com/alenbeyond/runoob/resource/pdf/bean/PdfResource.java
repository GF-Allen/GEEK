package com.alenbeyond.runoob.resource.pdf.bean;

import java.util.List;

/**
 * Created by Alen on 2016/8/26.
 */
public class PdfResource {

    private String title;

    private List<ListsBean> lists;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ListsBean> getLists() {
        return lists;
    }

    public void setLists(List<ListsBean> lists) {
        this.lists = lists;
    }

    public static class ListsBean {
        private String title;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "ListsBean{" +
                    "title='" + title + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "PdfResource{" +
                "title='" + title + '\'' +
                ", lists=" + lists +
                '}';
    }
}
