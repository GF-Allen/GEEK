package com.alenbeyond.runoob.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AlenBeyond on 2016/9/3.
 */
public class SuJin {

    public static final String ROOT_URL = "http://isujin.com/";

    public static List<SuJinHome> getSuJinHome(int page) {
        List<SuJinHome> datas = new ArrayList<>();

        try {
            Document doc = Jsoup.connect(ROOT_URL + "page/" + page).get();
            Elements posts = doc.getElementsByClass("post");
            for (Element post : posts) {
                Element cover = post.getElementsByClass("cover").get(0);
                String image = cover.attr("src").split("src=")[1];
                Element anElse = post.getElementsByClass("else").get(0);
                Elements elements = anElse.getAllElements();
                String date = elements.get(1).text();
                Element posttitle = elements.get(2).getElementsByClass("posttitle").get(0);
                String url = posttitle.attr("abs:href");
                String title = posttitle.text();
                String des = elements.get(4).text();
                String letter = elements.get(6).text();
                String view = elements.get(7).text();
                String like = elements.get(10).text();
                SuJinHome suJinHome = new SuJinHome();
                suJinHome.setDate(date);
                suJinHome.setDes(des);
                suJinHome.setImage(image);
                suJinHome.setLetter(Integer.parseInt(letter));
                suJinHome.setLike(Integer.parseInt(like));
                suJinHome.setTitle(title);
                suJinHome.setUrl(url);
                suJinHome.setView(Integer.parseInt(view));
                datas.add(suJinHome);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return datas;
    }

    public static SuJinDes getSujinDes(String url) {

        try {
            Document doc = Jsoup.connect(url).get();
            String title = doc.getElementsByClass("title").text();
            String stuff = doc.select("div.stuff span").get(0).text();
            String html = doc.getElementsByClass("content").get(0).getElementsByTag("p").html();
            Element jg = doc.getElementById("jg");
            Elements zoom = jg.getElementsByClass("zoom");
            List<String> images = new ArrayList<>();
            for (Element jpg : zoom) {
                String image = jpg.attr("abs:href");
                images.add(image);
            }
            String music = doc.getElementsByClass("wp-audio-shortcode").text();
            SuJinDes suJinDes = new SuJinDes();
            suJinDes.setTitle(title);
            suJinDes.setContent(html.split("<a")[0]);
            suJinDes.setStuff(stuff);
            suJinDes.setImages(images);
            suJinDes.setMusic(music);
            return suJinDes;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
