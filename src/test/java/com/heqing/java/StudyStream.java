package com.heqing.java;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * 学习 流
 */
public class StudyStream {

    List<String> strList = new ArrayList<>();

    @BeforeEach
    public void setValue() {
        strList = Arrays.asList("he", "", "qing", "hq", null, "heqing", "hq");
    }

    @Test
    public void testStream() {
        System.out.println("原始字符串: " + strList);

        // filter : 筛选
        List<String> filtered = strList.stream().filter(string -> string != null && !string.isEmpty()).collect(toList());
        System.out.println("filter 筛选非空字符串: " + filtered);

        // limit : 截断
        filtered = strList.stream().limit(2).collect(toList());
        System.out.println("limit 截断（只取前2个）: " + filtered);

        // skip : 跳过
        filtered = strList.stream().skip(2).collect(toList());
        System.out.println("skip 跳过前2个: " + filtered);

        // distinct : 去重
        filtered = strList.stream().distinct().collect(toList());
        System.out.println("distinct 去重: " + filtered);

        // map : 映射,对流中每一个元素应用函数
        filtered = strList.stream().map(str -> str==null ? "0" : str.length()+"").collect(toList());
        System.out.println("map 转化(获取字符串长度): " + filtered);

        // sorted ： 排序
        filtered = strList.stream().map(str -> str==null ? "0" : str.length()+"").sorted().collect(toList());
        System.out.println("sorted 正向排序: " + filtered);

        // sorted(Comparator.reverseOrder()) ：倒排序
        filtered = strList.stream().map(str -> str==null ? "0" : str.length()+"").sorted(Comparator.reverseOrder()).collect(toList());
        System.out.println("reverseOrder 逆向排序: " + filtered);

        // joining : 连接字符串
        String shortMenu = strList.stream().filter(string -> string != null).collect(joining(", "));
        System.out.println("joining 连接字符串：" + shortMenu);

        // flatMap : 扁平化
        List<String> flatMap =
                strList.stream()
                        .filter(string -> string != null && !string.isEmpty())
                        .map(w -> w.split(""))
                        .flatMap(Arrays::stream)
                        .distinct()
                        .collect(toList());
        System.out.println("flatMap 流的扁平化: " + flatMap);

        // anyMatch : 是否有一个元素能符合判断条件
        if(strList.stream().filter(string -> string != null).anyMatch(str -> "hq".equals(str))){
            System.out.println("anyMatch 有匹配的元素");
        } else {
            System.out.println("anyMatch 没有匹配的元素");
        }

        // allMatch : 是否所有元素能符合判断条件
        if(strList.stream().filter(string -> string != null).allMatch(str -> "hq".equals(str))){
            System.out.println("allMatch 所有元素都匹配");
        } else {
            System.out.println("allMatch 不是所有元素都匹配");
        }

        // noneMatch : 是否没有元素能符合判断条件
        if(strList.stream().filter(string -> string != null).noneMatch(str -> "hq".equals(str))){
            System.out.println("noneMatch 没有元素匹配");
        } else {
            System.out.println("noneMatch 有元素匹配");
        }

        // findAny ： 获取集合中任意一个元素
        String any = strList.stream().filter(string -> string != null).findAny().get();
        System.out.println("findAny 获取集合中任意一个元素: " + any);

        // findFirst : 查找第一个元素
        String first = strList.stream().filter(string -> string != null).findFirst().get();
        System.out.println("findFirst 获取集合中第一个元素: " + first);
    }

    @Test
    public void test() {
        // 数值构建流
        Stream<String> stream = Stream.of("heqing ", "love ", "shiyan ");
        stream.map(String::toUpperCase).forEach(System.out::println);
        System.out.println("----------------------------");

        // 数组构建流
        int[] numbers = {2, 3, 5, 7, 11, 13};
        Arrays.stream(numbers).forEach(System.out::println);
        System.out.println("----------------------------");

        // iterate 接受一个初始值，还有一个依次应用在每个产生的新值上的Lambda（UnaryOperator<t>类型）
        Stream.iterate(0, n -> n + 2).limit(5).forEach(System.out::println);
        // generate 接受一个IntSupplier
        Stream.generate(Math::random).limit(5).forEach(System.out::println);
    }

    @Test
    public void testString() {
        long count = strList.stream().filter(string -> string.isEmpty()).count();
        System.out.println("空字符串数量为: " + count);

        count = strList.stream().filter(string -> string.length() == 2).count();
        System.out.println("字符串长度为‘2’的数量为: " + count);

        List<String> filtered = strList.stream().filter(string -> !string.isEmpty()).collect(toList());
        System.out.println("筛选后的列表: " + filtered);

        String mergedString = strList.stream().filter(string -> !string.isEmpty()).collect(joining(", "));
        System.out.println("合并字符串: " + mergedString);

        count = strList.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println("并行处理 - 空字符串数量为: " + count);
    }

    @Test
    public void testInteger() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 4, 2);

        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(toList());
        System.out.println("集合数的平方并去重 : " + squaresList);

        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("最大数 : " + stats.getMax());
        System.out.println("最小数 : " + stats.getMin());
        System.out.println("求和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
        System.out.println("集合中数量 : " + stats.getCount());
    }

}
