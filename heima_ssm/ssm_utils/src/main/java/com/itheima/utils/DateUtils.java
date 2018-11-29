package com.itheima.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class DateUtils {

    public static String date2String(Date date,String format){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        String s = simpleDateFormat.format(date);
        return s;
    }

    public static Date String2Date(String str,String patt) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patt);
        Date parse = simpleDateFormat.parse(str);
        return parse;

    }
}
