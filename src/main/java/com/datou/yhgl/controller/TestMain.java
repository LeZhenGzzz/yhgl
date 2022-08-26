package com.datou.yhgl.controller;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Validator;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.datou.yhgl.entity.KnowledgeType;
import com.datou.yhgl.entity.TblCategory;
import com.datou.yhgl.entity.User;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.io.File;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.*;
import java.util.stream.Collectors;

public class TestMain {
    public static void main(String[] args) {
        ArrayList<Long> longs = CollUtil.newArrayList(1L, 2L);
        String s = JSON.toJSONString(longs);
        System.out.println(s);
        ArrayList<User> usersOld = CollUtil.newArrayList();
        User user1 = new User(1L, 1L,"name1", 1, "642818795@qq.com", "16602127200");
        User user2 = new User(2L, 2L,"name1", 2, "642818795@qq.com", "16602127200");
        User user3 = new User(3L, 3L,"name3", 3, "642818795@qq.com", "16602127200");
        usersOld.add(user1);
        usersOld.add(user2);
        usersOld.add(user3);
        ArrayList<Integer> integers = CollUtil.newArrayList(1, 3);
        List<User> collect = usersOld.stream().filter(user -> !integers.contains(user.getAge())).collect(Collectors.toList());
        // 集合中对象属性转map
        Map<Long, String> map = usersOld.stream().collect(Collectors.toMap(User :: getUserId, User :: getName));
        System.out.println(map);

    }

    private List<KnowledgeType> createDefaultData() {
        List<KnowledgeType> res = CollUtil.newArrayList();
        res.add(createKnowledgeType(1L, 10086L, 0L, "规章制度", 1, 1 ));
        res.add(createKnowledgeType(11L, 10086L, 1L, "企业制度", 2, 1 ));
        res.add(createKnowledgeType(12L, 10086L, 1L, "管理办法", 2, 2));
        res.add(createKnowledgeType(13L, 10086L, 1L, "标准文件", 2, 3 ));
        res.add(createKnowledgeType(14L, 10086L, 1L, "流程指引", 2, 4));
        res.add(createKnowledgeType(2L, 10086L, 0L, "案例经验", 1, 2));
        res.add(createKnowledgeType(21L, 10086L, 2L, "经验心得", 2, 1 ));
        res.add(createKnowledgeType(22L, 10086L, 2L, "案例总结", 2, 2));
        res.add(createKnowledgeType(23L, 10086L, 2L, "方法技能", 2, 3 ));
        res.add(createKnowledgeType(24L, 10086L, 2L, "岗位知识", 2, 4));
        res.add(createKnowledgeType(3L, 10086L, 0L, "外部信息", 1, 3));
        res.add(createKnowledgeType(31L, 10086L, 3L, "政策法规", 2, 1));
        res.add(createKnowledgeType(32L, 10086L, 3L, "行业咨询", 2, 2));
        res.add(createKnowledgeType(33L, 10086L, 3L, "技术前言", 2, 3));
        res.add(createKnowledgeType(34L, 10086L, 3L, "竞争情报", 2, 4));
        return res;
    }
    private KnowledgeType createKnowledgeType(Long id, Long tenantId, Long parentId, String name, Integer level, Integer sort) {
        KnowledgeType knowledgeType = new KnowledgeType();
        knowledgeType.setId(id);
        knowledgeType.setTenantId(tenantId);
        knowledgeType.setParentId(parentId);
        knowledgeType.setName(name);
        knowledgeType.setLevel(level);
        knowledgeType.setSort(sort);
        knowledgeType.setCreateAt(LocalDateTime.now());
        knowledgeType.setUpdateAt(LocalDateTime.now());
        knowledgeType.setIsDeleted("N");
        knowledgeType.setIsDefault("Y");
        return knowledgeType;
    }

    private static void ListIntersection() {
        ArrayList<User> usersOld = CollUtil.newArrayList();
        User user1 = new User(1L, 1L,"name1", 1, "642818795@qq.com", "16602127200");
        User user2 = new User(2L, 2L,"name2", 2, "642818795@qq.com", "16602127200");
        User user3 = new User(3L, 3L,"name3", 3, "642818795@qq.com", "16602127200");
        usersOld.add(user1);
        usersOld.add(user2);
        usersOld.add(user3);
        ArrayList<User> usersNew = CollUtil.newArrayList();

        User user4 = new User(4L, 4L,"name4", 4, "642818795@qq.com", "16602127200");
        User user5 = new User(5L, 5L,"name5", 5, "642818795@qq.com", "16602127200");
        User user6 = new User(3L, 3L,"name6", 6, "642818795@qq.com", "16602127200");
        usersNew.add(user4);
        usersNew.add(user5);
        usersNew.add(user6);
        // 交集
        List<User> intersectA = usersOld
                .stream() //获取第一个集合的Stream1
                .filter(  //取出Stream1中符合条件的元素组成新的Stream2，lambda表达式1返回值为true时为符合条件
                        a ->  //lambda表达式1，a为lambda表达式1的参数，是Stream1中的每个元素
                                usersNew.stream() //获取第二个集合的Stream3
                                        .map(User::getUserId) //将第二个集合每个元素的id属性取出来，映射成新的一个Stream4
                                        .anyMatch( //返回值（boolean）：Stream4中是否至少有一个元素使lambda表达式2返回值为true
                                                id -> //lambda表达式2，id为lambda表达式2的参数，是Stream4中的每个元素
                                                        Objects.equals(a.getUserId(), id) //判断id的值是否相等
                                        )
                )
                .collect(Collectors.toList()); //将Stream2转换为List


// 差集
        List<User> difference1 = usersNew.stream().filter(b -> intersectA.stream().map(User::getUserId).noneMatch(id ->
                Objects.equals(b.getUserId(), id))).collect(Collectors.toList());
        System.out.println(difference1);

        List<User> difference2 = usersOld.stream().filter(b -> intersectA.stream().map(User::getUserId).noneMatch(id ->
                Objects.equals(b.getUserId(), id))).collect(Collectors.toList());
        System.out.println(difference2);


        List<Obj> list1 = new ArrayList<>();
        List<Obj> list2 = new ArrayList<>();
        list1.add(new Obj(123456, "aaa"));
        list1.add(new Obj(1234567, "bbb"));

        list2.add(new Obj(1234567, "bbb"));
        list2.add(new Obj(12345678, "ccc"));

        //并集
        List<Obj> union = new ArrayList<>(CollectionUtils.union(list1, list2));
        System.out.println("并集:"+union);
        //交集
        List<Obj> objs = new ArrayList<>(CollectionUtils.intersection(list1, list2));
        System.out.println("交集:"+objs);
        //差集的补集
        List<Obj> disjunction = new ArrayList<>(CollectionUtils.disjunction(list1, objs));
        List<Obj> disjunction2 = new ArrayList<>(CollectionUtils.disjunction(list2, objs));
        System.out.println("差集的补集1:"+disjunction);
        System.out.println("差集的补集2:"+disjunction2);
    }

    private static long getDurationdays( LocalDateTime nowTime, LocalDateTime endTime) {
        Duration duration = Duration.between(nowTime,endTime);//时间差
        long durationdays = duration.toDays(); //相差的天数
        return durationdays;
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
