package com.mtinsky.Utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleUtils {

    private static final String UTF_8 = "UTF-8";

    /**
     * 生成32位的GUID，已去除分隔的"-"字符
     * @return 32位的GUID
     */
    public static String get32sid() {
        return UUID.randomUUID().toString().trim().replaceAll("-", "");
    }

    /**
     * 字节数组转16进制表示的字符串
     * @param bytes 需要转换的字节数组
     * @return 16进制表示的字符串
     */
    private static String byte2hex(final byte[] bytes) {
        String retString = new String();

        for(int i=0; i<bytes.length; i++){
            String hexStr = Integer.toHexString(bytes[i] & 0xff);//TODO 0xff的作用
            if(1 == hexStr.length()){
                retString = retString + "0" + hexStr;
            }else{
                retString = retString + hexStr;
            }
        }
        return retString;
    }

    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    /**
     * 将Date对象转为时间字符串，格式为"yyyy-MM-dd HH:mm:ss"
     * @param date
     * @return
     */
    public static String convertDateToString(Date date) {
        return df.get().format(date);
    }

    /**
     * 将格式为"yyyy-MM-dd HH:mm:ss"的时间字符串转为Date对象
     * @param str
     * @return
     * @throws ParseException
     */
    public static Date convertStringToDate(String str) throws ParseException {
        return df.get().parse(str);
    }

    /**
     * 根据指定的时间字符串及最大时间间隔，判断在线状态，时间字符串的格式为yyyy-MM-dd HH:mm:ss
     * @param time 需要判断的时间
     * @param nowDate 当前时间
     * @param exp 最大离线时间间隔 ，单位秒
     * @return 1为在线 2为离线
     * @throws ParseException
     */
    public static int getStatusByTime(String time,Date nowDate,long exp) throws ParseException {
        if(time!=null && !"".equals(time)) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = df.parse(time);
            if(nowDate.getTime()-date.getTime()<=exp) {
                return 1;
            }
        }
        return 2;
    }

    /**
     * 返回截取后的字符串，从第一个字符串截取，截取num个字符串，如果message为null则返回null
     * @param message 需要截断的字符串
     * @param num 需要的字符串个数
     * @return
     *
     */
    public static String substring(String message,int num) {
        if(message==null) {
            return null;
        }
        int length = message.length();
        if(length<num) {
            return message;
        } else {
            return message.substring(0,num);
        }
    }

}
