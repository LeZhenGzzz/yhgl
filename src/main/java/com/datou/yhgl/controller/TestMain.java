package com.datou.yhgl.controller;


import com.alibaba.fastjson.JSONArray;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TestMain {
    public static void main(String[] args) {

        System.out.println(LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"))*1000);
        BigDecimal bigDecimal = new BigDecimal(100.00);
        String s = bigDecimal.toString();
        BigDecimal divide1 = getBigDecimalMultiply(s,"2");
        String s1 = divide1.toString();
        System.out.println(s1);


        //字段格式化格式yyyy-MM-dd;yyyy/MM/dd;yyyy年MM月dd日
        System.out.println(formatToString(LocalDate.now(), "yyyy-MM-dd"));
        System.out.println(formatToString(LocalDate.now(), "yyyy/MM/dd"));
        System.out.println(formatToString(LocalDate.now(), "yyyy年MM月dd日"));
        List<Object> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        List<String> strings = list.stream().map(x -> x + "").collect(Collectors.toList());
        System.out.println(strings);
        String json="[133924358864064512]";
        ArrayList<String> arr = new ArrayList<>();
        JSONArray info = JSONArray.parseArray(json);
        for(int i = 0; i < info.size(); ++i) {
            arr.add(info.get(i).toString());
        }
        BigDecimal first = new BigDecimal(7625.1);
        BigDecimal last = new BigDecimal(12);
        BigDecimal divide = divide(first, last);
        System.out.println(divide);
    }

    private static BigDecimal getBigDecimalMultiply(String number1,String number2) {
        BigDecimal a = new BigDecimal(number1);
        BigDecimal b = new BigDecimal(number2);
        BigDecimal multiply = a.multiply(b);
        return multiply;
    }

    public static String formatToString(LocalDate localDate, String format){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        return localDate.format(dateTimeFormatter);
    }
    public static BigDecimal divide(BigDecimal first, BigDecimal last) {
        if (first == null) {
            first = new BigDecimal(0);
        }
        if (last == null) {
            last = new BigDecimal(0);
        }
        if (last.compareTo(BigDecimal.ZERO)==0){
            return new BigDecimal(0);
        }
        return first.divide(last,2,BigDecimal.ROUND_HALF_UP).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

}
