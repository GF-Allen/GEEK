package com.alenbeyond.runoob.crawler;

import com.alenbeyond.runoob.greendao.bean.AnyCodesPDF;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AlenBeyond on 2016/8/17.
 */
public class Anycodes {
    public static final String ROOT_URL = "http://luntan.anycodes.cn/mobcent/app/web/index.php";

    /**
     * 获取PDF资源
     *
     * @return
     */
    public static List<AnyCodesPDF> getPDFResource(String url, int page) {
        //http://study.anycodes.cn/index.php?mod=folder&sid=18oOe3&page=1 默认一次返回20条
        String reqUrl = url + "&page=" + page;
        ArrayList<AnyCodesPDF> lists = new ArrayList<>();
        try {
            Document document = Jsoup.connect(reqUrl).get();
            Elements list = document.getElementsByClass("list");
            Elements items = list.get(0).getElementsByClass("item");
            if (items.size() == 0) {
                return null;
            }
            for (int i = 0; i < items.size(); i++) {
                String type = items.get(i).getElementsByClass("type").get(0).text();
                if (type.contains("PDF")) {
                    String title = items.get(i).getElementsByClass("name-text").get(0).text();
                    String path = items.get(i).attr("data-dpath");
                    String size = items.get(i).getElementsByClass("size").get(0).text();
                    AnyCodesPDF anyCodesPDF = new AnyCodesPDF(title, path, size);
                    lists.add(anyCodesPDF);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        List<AnyCodesPDF> pdfs = getPDFResource(url, ++page);
        if (pdfs == null) {
            return lists;
        }
        lists.addAll(pdfs);
        return lists;
    }
}
