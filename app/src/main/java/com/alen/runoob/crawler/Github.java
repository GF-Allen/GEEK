package com.alen.runoob.crawler;

import com.alen.runoob.greendao.bean.GithubCollect;
import com.orhanobut.logger.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alen on 2016/8/12.
 */
public class Github {

    public static final String ROOTURL = "https://github.com/XiqingLiu/CollectSourceCode";

    public static final String RAWURL = "https://raw.githubusercontent.com/XiqingLiu/CollectSourceCode/master/";


    /**
     * 获取https://github.com/XiqingLiu/CollectSourceCode项目里的MD文件
     *
     * @return
     */
    public static List<GithubCollect> getCollectMD() {
        ArrayList<GithubCollect> infos = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(ROOTURL).get();
            Elements files = doc.getElementsByClass("files");
            if (files != null) {
                Elements items = files.get(0).getElementsByClass("js-navigation-item");
                for (Element elemnt : items) {
                    Element content = elemnt.getElementsByClass("content").get(0);
                    String title = content.text();
                    if ("README.md".equals(title)) continue;
                    String url = RAWURL + title;
                    Logger.d(title + ":" + url);
                    infos.add(new GithubCollect(title, url));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return infos;
    }
}
