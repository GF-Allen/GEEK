package com.alenbeyond.runoob.crawler;

import com.alenbeyond.runoob.greendao.bean.RNApiGroup;
import com.alenbeyond.runoob.greendao.bean.RNApiSub;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alen on 2016/9/2.
 */
public class ReactNative {

    private static final String TAG = "ReactNative";

    public static final String ROOT_URL = "http://reactnative.cn/docs/0.31/getting-started.html";

    public static List<RNApiGroup> getApiGroup() {
        ArrayList<RNApiGroup> datas = new ArrayList<>();
        try {
            Document document = Jsoup.connect(ROOT_URL).get();
            Element apiGroupsUl = document.getElementsByAttributeValue("data-reactid", "94").get(0);
            Elements apiGroups = apiGroupsUl.getElementsByClass("apiGroup");
            for (int i = 0; i < apiGroups.size(); i++) {
                Element apiGroup = apiGroups.get(i);
                String reactId = apiGroup.attr("data-reactid");
                String name = apiGroup.text().split(" ")[0];
                if ("社区资源".equals(name)) {
                    continue;
                }
                datas.add(new RNApiGroup(Integer.parseInt(reactId), name));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datas;
    }

    public static List<RNApiSub> getApiSub(String groupId) {
        ArrayList<RNApiSub> datas = new ArrayList<>();
        try {
            Document document = Jsoup.connect(ROOT_URL).get();
            Element apiGroup = document.getElementsByAttributeValue("data-reactid", groupId).get(0);
            Element apiSub = apiGroup.getElementsByClass("apiSub").get(0);
            Elements lis = apiSub.getElementsByAttributeValue("target", "_self");
            for (int i = 0; i < lis.size(); i++) {
                Element element = lis.get(i);
                String reactId = element.attr("data-reactid");
                String name = element.text();
                String url = element.attr("abs:href");
                datas.add(new RNApiSub(Integer.parseInt(reactId), name, url, Long.parseLong(groupId)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datas;
    }
}
