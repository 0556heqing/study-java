package com.heqing.java.java8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class StudyLambda {

    String active = "执行";
    List<String> strList = new ArrayList<>();

    @BeforeEach
    public void setValue() {
        strList = Arrays.asList("he", "", "qing", "hq", "heqing");
    }

    @Test
    public void testBasic() {
        // 替代匿名内部类
        new Thread(() -> System.out.println("It's a lambda function!")).start();
        System.out.println("-----------------------");

        // 使用lambda表达式对集合进行迭代
        strList.stream().forEach(System.out::println);
        System.out.println("-----------------------");
    }

    @Test
    public void testConsumer() {
        Consumer c1 = c -> System.out.println(c + " --> c1方法");
        Consumer c2 = c -> System.out.println(c + " --> c2方法");

        // 执行方法一
        c1.accept(active);
        System.out.println("-----------------------");

        // 顺序执行
        c1.andThen(c2).accept(active);
        System.out.println("-----------------------");

        // 连续执行
        c1.andThen(c2).andThen(c1).accept(active);
        System.out.println("-----------------------");
    }

    @Test
    public void testFunction() {
        Function<String, String> f1 = f -> {
            System.out.println(f + " --> f1方法");
            return "f1方法 执行成功";
        };
        Function<String, String> f2 = f -> {
            System.out.println(f + " --> f2方法");
            return "f2方法 执行成功";
        };

        // 执行方法一
        System.out.println(f1.apply(active));
        System.out.println("-----------------------");

        // 执行f1方法前，先执行f2方法，并且将f2的返回结果当作入参传给f1
        System.out.println(f1.compose(f2).apply(active));
        System.out.println("-----------------------");

        // 执行f1方法后，继续执行2方法，并且将f1的返回结果当作入参传给f2
        System.out.println(f1.andThen(f2).apply(active));
        System.out.println("-----------------------");

        // identity方法会返回一个不进行任何处理的Function，即输出与输入值相等；
        System.out.println(Function.identity().apply(active));
        System.out.println("-----------------------");
    }

    @Test
    public void testPredicate() {
        Predicate<String> p1 = p -> p.equals("hq");
        Predicate<String> p2 = p -> p.equals("test");

        // test : 值是否相等
        System.out.println("是否满足条件：" + p1.test("hq"));
        System.out.println("-----------------------");

        // negate: 用于对原来的Predicate做取反处理
        System.out.println("是否不满足所有条件：" + p1.negate().test("hq"));
        System.out.println("-----------------------");

        // and : 针对同一输入值，多个Predicate均返回True时返回True，否则返回False；
        System.out.println("是否满足所有条件：" + p1.and(p2).test("hq"));
        System.out.println("-----------------------");

        // or : 针对同一输入值，多个Predicate只要有一个返回True则返回True，否则返回False
        System.out.println("是否满足其中一个条件：" + p1.or(p1).test("hq"));
    }

}
