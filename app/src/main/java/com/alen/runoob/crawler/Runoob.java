package com.alen.runoob.crawler;

import com.alen.runoob.greendao.bean.RunoobCategory;
import com.alen.runoob.greendao.bean.RunoobChapter;
import com.alen.runoob.greendao.bean.RunoobItem;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 获取菜鸟教程的相关项
 * Created by AlenBeyond on 2016/5/23.
 */
public class Runoob {

    public static final String RootUrl = "http://www.runoob.com";

    /**
     * 获取每个大类中小类别
     *
     * @return
     */
    public static ArrayList<RunoobCategory> getCategorys() {
        ArrayList<RunoobCategory> codeList = null;

        try {
            Document doc = Jsoup.connect(RootUrl).get();
            codeList = new ArrayList<RunoobCategory>();
            Elements middles = doc.getElementsByClass("middle-column-home");
            for (Element cates : middles) {
                Elements codes = cates.getElementsByClass("codelist-desktop");
                for (Element element : codes) {
                    Elements code = element.getElementsByTag("h2");
                    String t_cate_title = code.text();
                    Elements items = element.getElementsByClass("item-1");
                    ArrayList<RunoobItem> c_Runoob_Items = new ArrayList<>();
                    for (Element item : items) {
                        Elements item_title = item.getElementsByTag("h4");
                        String t_item_title = item_title.text();
                        String t_item_link = item.attr("abs:href");
                        String t_item_des = item.getElementsByTag("strong").text();
                        String t_item_image = item.getElementsByTag("img").get(0).attr("src");
                        RunoobItem runoobItem1 = new RunoobItem(t_item_title, t_item_image, t_item_link, t_item_des);
                        c_Runoob_Items.add(runoobItem1);
                    }
                    codeList.add(new RunoobCategory(t_cate_title, c_Runoob_Items));
                }
            }
            return codeList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取章节
     */
    public static ArrayList<RunoobChapter> getChapter(String url) {
        try {
            ArrayList<RunoobChapter> runoobChapters = new ArrayList<>();
            Document doc = Jsoup.connect(url).get();
            Elements tops = doc.getElementsByAttributeValue("target", "_top");
            for (Element top : tops) {
                String title = top.text();
                String link = top.attr("abs:href");//获取绝对路径
                runoobChapters.add(new RunoobChapter(title, link));
            }
            return runoobChapters;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
