package com.alen.runoob.js;

/**
 * Created by Jeff on 2016/5/23.
 */
public class Js {

    public static final String getClass = "javascript:function getClass(tag,sClass) " +
            "{ var aEle=document.getElementsByTagName(tag); var aResult=[]; var i=0; " +
            "for(i<0;i<aEle.length;i++) { if(aEle[i].className==sClass) { aResult.push(aEle[i]); } };" +
            " return aResult; } ";

    public static final String hideDiv = "javascript:function hideDiv(bbb){\n" +
            "for(var i=0;i<bbb.length;i++){\n" +
            "bbb[i].style.display='none';\n" +
            "}\n" +
            "}";

    public static final String hide = "javascript:function hide(){" +
            "  hideDiv(getClass('div',\"previous-next-links\"));\n" +
            "  hideDiv(getClass('div',\"ad\"));\n" +
            "  hideDiv(getClass('div',\"container logo-search\"));\n" +
            "  hideDiv(getClass('div',\"article-heading-ad\"));\n" +
            "  hideDiv(getClass('div',\"container navigation\"));\n" +
            "  hideDiv(getClass('div',\"previous-next-links\"));\n" +
            "  hideDiv(getClass('div',\"sidebar-box ad-box ad-box-large\"));\n" +
            "  hideDiv(getClass('div',\"fivecol last right-column\"));\n" +
            "  hideDiv(getClass('div',\"fixed-btn\"));" +
            "  hideDiv(getClass('div',\"mar-t50\"));" +
            "  hideDiv(getClass('label',\"pull-right\"));" +
            "}";
}
