package com.ithiema.test;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConverterTest implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        DateFormat sdf = null;


        try {
            if (StringUtils.isEmpty(source)) {
                throw  new NullPointerException("please systemIn");
            }
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = sdf.parse(source);
            return date;
        } catch (Exception e) {
        throw new RuntimeException("输入有误");
        }
    }
}
