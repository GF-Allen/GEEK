package com.alenbeyond.runoob.resource.pdf.data;

import com.alenbeyond.runoob.resource.pdf.bean.PdfResource;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

/**
 * Created by Alen on 2016/8/26.
 */
public class PdfResourceUtils {
    public static ArrayList<PdfResource> getPdfData() {
        Gson gson = new Gson();
        ArrayList<PdfResource> data = gson.fromJson(PdfResourceData.PDF_RESOURCE_DATA, new TypeToken<ArrayList<PdfResource>>() {
        }.getType());
        return data;
    }
}
