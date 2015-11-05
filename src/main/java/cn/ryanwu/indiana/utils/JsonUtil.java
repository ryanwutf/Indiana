package cn.ryanwu.indiana.utils;

import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JsonUtil {

    private static final SerializerFeature[] DEFAULT_SERIALIZER_FEATURES = new SerializerFeature[] {
                    SerializerFeature.DisableCircularReferenceDetect,//
                    SerializerFeature.WriteDateUseDateFormat };

    public static String toJsonString(Object o) {
        return JSON.toJSONString(o, DEFAULT_SERIALIZER_FEATURES);
    }

    public static void writeJsonString(Object o, Writer writer) {
        JSON.writeJSONStringTo(o, writer, DEFAULT_SERIALIZER_FEATURES);
    }

    public static <T> List<T> toJavaList(JSONArray array, Class<T> clazz) {
        int size = array.size();
        List<T> list = new ArrayList<T>(size);
        for (int i = 0; i < size; i++) {
            list.add(JSON.toJavaObject(array.getJSONObject(i), clazz));
        }
        return list;
    }
    
    public static <T> T fromJsonString(String string, Class<T> clazz){
        return JSON.toJavaObject((JSON)JSON.parse(string), clazz);
    }
    
}
