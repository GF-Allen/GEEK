package com.alen.runoob.runoob;

import com.alen.runoob.bean.Category;
import com.alen.runoob.bean.Chapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 获取菜鸟教程的相关项
 * Created by Jeff on 2016/5/23.
 */
public class Runoob {

    public static final String RootUrl = "http://www.runoob.com";

    /**
     * 获取每个大类中小类别
     *
     * @return
     */
    public static ArrayList<Category> getCategorys() {
        ArrayList<Category> codeList = null;

        try {
            Document doc = Jsoup.connect("http://www.runoob.com/").get();
            codeList = new ArrayList<Category>();
            Elements middles = doc.getElementsByClass("middle-column-home");
            for (Element cates : middles) {
                Elements codes = cates.getElementsByClass("codelist-desktop");
                for (Element element : codes) {
                    Elements code = element.getElementsByTag("h2");
                    String t_cate_title = code.text();
                    Elements items = element.getElementsByClass("item-1");
                    ArrayList<Category.Item> c_Items = new ArrayList<>();
                    for (Element item : items) {
                        Elements item_title = item.getElementsByTag("h4");
                        String t_item_title = item_title.text();
                        String t_item_link = item.attr("href");
                        String t_item_des = item.getElementsByTag("strong").text();
                        String t_item_image = item.getElementsByTag("img").get(0).attr("src");
                        c_Items.add(new Category.Item(t_item_title, t_item_image, t_item_link, t_item_des));
                    }
                    codeList.add(new Category(t_cate_title, c_Items));
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
    public static ArrayList<Chapter> getChapter(String url) {
        try {
            ArrayList<Chapter> chapters = new ArrayList<>();
            Document doc = Jsoup.connect(url).get();
            Elements tops = doc.getElementsByAttributeValue("target", "_top");
            for (Element top : tops) {
                String title = top.text();
                String link = top.attr("href");
                //处理格式问题
                String start = link.substring(0, 1);
                if (!link.contains("http://")) {
                    if ("/".equals(start)) {
                        link = RootUrl + link;
                    } else {
                        link = RootUrl + "/" + link;
                    }
                }
                chapters.add(new Chapter(title, link));
            }
            return chapters;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
