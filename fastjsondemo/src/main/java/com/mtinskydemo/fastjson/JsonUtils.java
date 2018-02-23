package com.mtinskydemo.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;

/**
 * 参考http://blog.csdn.net/flysun3344/article/details/54707965
 */
public class JsonUtils {
    private static final SerializerFeature[] features = {SerializerFeature.WriteMapNullValue, // 输出空置字段
            // SerializerFeature.WriteNullListAsEmpty,// list字段如果为null，输出为[]，而不是null
            // SerializerFeature.WriteNullNumberAsZero,// 数值字段如果为null，输出为0，而不是null
            // SerializerFeature.WriteNullBooleanAsFalse,// Boolean字段如果为null，输出为false，而不是null
            // SerializerFeature.WriteNullStringAsEmpty,// 字符类型字段如果为null，输出为""，而不是null
            SerializerFeature.WriteDateUseDateFormat // 日期格式化yyyy-MM-dd HH:mm:ss
    };

    /**
     * 转为json字符串，支持bean、list、map
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        return JSON.toJSONString(object, features);
    }

    /**
     * 转为json字符串，支持bean、list、map
     * @param object
     * @return
     */
    public static String toJson(Object object,SerializerFeature... features) {
        return JSON.toJSONString(object, features);
    }

    /**
     * json字符串反序列化为bean
     * @param text json字符串
     * @return
     */
    public static <T> T parseObject(String text,Class<T> clazz) {
        return JSON.parseObject(text, clazz);
    }

    /**
     * 泛型的反序列化，例如Map<String, Object> map1 = JSON.parseObject(text, new TypeReference<Map<String, Object>>(){});
     * @param text json字符串
     * @return
     */
    public static <T> T parseObject(String text,TypeReference<T> typeReference) {
        return JSON.parseObject(text, typeReference);
    }

    /**
     * json字符串反序列化为list 例如List<Map> list1 = parseArray(text, Map.class);
     * @param text json字符串
     * @return
     */
    public static <T> List<T> parseArray(String text, Class<T> clazz) {
        return JSON.parseArray(text, clazz);
    }

    /*下面是执行tojson时一些特性的使用*/
    //日期格式化（未指定该特性时，Date会转换为long类型的unix时间戳）
    public static String toJsonWithNormalDateFormat(Object object) {
        return JSON.toJSONString(object, SerializerFeature.WriteDateUseDateFormat);
    }
    //日期格式化，并且指定格式。例如format的值可为"yyyy-MM-dd HH:mm:ss.SSS"。（未指定该特性时，Date会转换为long类型的unix时间戳）
    public static String toJsonWithDateFormat(Object object,String format) {
        return JSON.toJSONStringWithDateFormat(object, format);
    }
    //使用单引号，默认是双引号
    public static String toJsonWithSingleQuote(Object object) {
        return JSON.toJSONString(object, SerializerFeature.UseSingleQuotes);
    }
    //格式化输出显示
    public static String toJsonWithPrettyFormat(Object object) {
        return JSON.toJSONString(object, SerializerFeature.PrettyFormat);
    }
    //输出类信息，例如{"@type":"User","age":18,"userName":"李四"}中的@type
    public static String toJsonWriteClassName(Object object) {
        return JSON.toJSONString(object, SerializerFeature.WriteClassName);
    }

}
