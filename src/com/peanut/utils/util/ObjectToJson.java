package com.peanut.utils.util;

import net.sf.json.JSONArray;

import java.util.List;

public class ObjectToJson {
    public static String toJson(Object object){
        JSONArray jsonArray = JSONArray.fromObject(object);
        return jsonArray.toString();
    }
}
