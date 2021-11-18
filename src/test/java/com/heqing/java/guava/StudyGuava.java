package com.heqing.java.guava;

import com.github.houbb.junitperf.core.annotation.JunitPerfConfig;
import com.github.houbb.junitperf.core.report.impl.ConsoleReporter;
import com.github.houbb.junitperf.core.report.impl.HtmlReporter;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.*;
import com.google.common.util.concurrent.RateLimiter;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author heqing
 * @date 2021/11/18 14:23
 */
public class StudyGuava {

    /**
     * Optional
     *
     * isPresent()：如果Optional包含非null的引用（引用存在），返回true
     * get() ：如果Optional为NULL将触发异常
     * or(defaultvalue) ：包含的引用缺失(null)，返回默认的值，否则返回本身
     * orNull()：包含的引用缺失，返回null
     * asSet()：如果引用存在，返回只有单一元素的集合；若为NULl返回空集合
     */
    @Test
    public void testOptional() {
        // 创建允许null值的Optional
        Optional<Integer> possible = Optional.ofNullable(5);
        // 包含的引用非null的（引用存在），返回true
        if(possible.isPresent()){
            System.out.println(possible.get());
        }else{
            System.out.println("possible is null");
        }

        String nullValue = null;
        String optional = Optional.ofNullable(nullValue).orElse("hq");
        System.out.println(optional);
        String nonNullOptional = Optional.ofNullable("heqing").orElse("hq");
        System.out.println(nonNullOptional);
    }

    /**
     * 先决条件 Preconditions
     *
     * checkArgument(boolean)	检查boolean是否为true，用来检查传递给方法的参数	IllegalArgumentException
     * checkNotNull(T)	检查value是否为null，该方法直接返回value，因此可以内嵌使用checkNotNull	NullPointerException
     * checkState(boolean)	用来检查对象的某些状态。	IllegalStateException
     * checkElementIndex(int index, int size)	检查index作为索引值对某个列表、字符串或数组是否有效。index>=0 && index<size	IndexOutOfBoundsException
     * checkPositionIndex(int index, int size)	检查index作为位置值对某个列表、字符串或数组是否有效。index>=0 && index<=size	IndexOutOfBoundsException
     * checkPositionIndexes(int start, int end, int size)	检查[start, end]表示的位置范围对某个列表、字符串或数组是否有效	IndexOutOfBoundsException
     */
    @Test
    public void testPreconditions() {
        int i = 1, j = 0;
        Preconditions.checkArgument(i >= 0);
        Preconditions.checkArgument(i >= 0, "Argument was expected nonnegative");
//        Preconditions.checkArgument(i < j, "Expected i < j, but %s > %s", i, j);

        StudyGuava guava = null;
        Preconditions.checkNotNull(guava, "Class must not be null");
    }

    /**
     * 连接器 Joiner
     *
     * on(String)：静态工厂方法，生成一个新的 Joiner 对象，参数为连接符
     * skipNulls()：如果元素为空，则跳过
     * useForNull(String)：如果元素为空，则用这个字符串代替
     * join(数组/链表)：要连接的数组/链表
     * appendTo(String,数组/链表)：在第一个参数后面新加上 拼接后的字符串
     * withKeyValueSeparator(String)：得到 MapJoiner，连接Map的键、值
     */
    @Test
    public void testJoiner(){
        List<String> list1 = Arrays.asList("aa", "bb", "cc");
        System.out.println(Joiner.on("-").join(list1));

        List<String> list2 = Arrays.asList("aa", "bb", "cc", null, "dd", "", "ee");
        System.out.println(Joiner.on("-").skipNulls().join(list2));
        System.out.println(Joiner.on("-").useForNull("nn").join(list2));

        Map map = ImmutableMap.of("k1", "v1", "k2", "v2");
        System.out.println(Joiner.on("--").withKeyValueSeparator("=").join(map));
    }

    /**
     * Splitter 能将一个字符串按照分隔符生成字符串集合，是 Joiner的反向操作。
     *
     * on(String)：静态工厂方法，生成一个新的 Splitter 对象，参数为连接符
     * trimResults()：结果去除子串中的空格
     * omitEmptyStrings()：去除null的子串
     * split(String)：拆分字符串
     * withKeyValueSeparator(String)：得到 MapSplitter，拆分成Map的键、值。注意，这个对被拆分字符串格式有严格要求，否则会抛出异常
     */
    @Test
    public void testSplitter(){
        String string = " ,a,b,";
        System.out.println(Splitter.on(",").split(string));
        System.out.println(Splitter.on(",").trimResults().split(string));
        System.out.println(Splitter.on(",").omitEmptyStrings().split(string));
        System.out.println(Splitter.on(",").trimResults().omitEmptyStrings().split(string));

        // 根据长度拆分
        string = "heqing";
        System.out.println(Splitter.fixedLength(2).split(string));

        // 拆分成Map
        System.out.println(Splitter.on("#").withKeyValueSeparator(":").split("1:2#3:4"));
    }

    /**
     * Strings 类主要提供了对字符串的一些操作
     *
     * nullToEmpty(String string) ：null字符串转空字符串
     * emptyToNull(String string)：空字符串转null字符串
     * isNullOrEmpty(String string)：判断字符串为null或空字符串
     * padStart(String string, int minLength, char padChar)：如果string的长度小于minLeng，在string前添加padChar，直到字符串长度为minLeng。
     * padEnd(String string, int minLength, char padChar)：和padStart类似，不过是在尾部添加新字符串
     * commonPrefix(CharSequence a, CharSequence b)：返回共同的前缀
     * commonSuffix(CharSequence a, CharSequence b)：返回共同的后缀
     */
    @Test
    public void testStrings(){
        System.out.println("nullToEmpty" + "->" + Strings.nullToEmpty(null));
        System.out.println("emptyToNull" + "->" + Strings.emptyToNull(""));
        System.out.println("isNullOrEmpty" + "->" + Strings.isNullOrEmpty(""));
        System.out.println("padStart" + "->" + Strings.padStart("hq", 5, 'A'));
        System.out.println("padEnd" + "->" + Strings.padEnd("hq", 5, 'B'));
        String bb = "abc123def";
        String cc = "abc789def";
        System.out.println(Strings.commonPrefix(bb, cc));
        System.out.println(Strings.commonSuffix(bb, cc));
    }

    /**
     * Multiset
     *
     * count(E)	给定元素在Multiset中的计数
     * elementSet()	Multiset中不重复元素的集合，类型为Set
     * entrySet()	和Map的entrySet类似，返回Set<Multiset.Entry>，其中包含的Entry支持getElement()和getCount()方法
     * add(E, int)	增加给定元素在Multiset中的计数
     * remove(E, int)	减少给定元素在Multiset中的计数
     * setCount(E, int)	设置给定元素在Multiset中的计数，不可以为负数
     * size()	返回集合元素的总个数（包括重复的元素）
     */
    @Test
    public void testMultiset() {
        List<String> words = Arrays.asList("aa", "bb", "cc", "aa");
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            Integer count = counts.get(word);
            if (count == null) {
                counts.put(word, 1);
            } else {
                counts.put(word, count + 1);
            }
        }
        System.out.println(counts.get("aa"));

        Multiset<String> multiset = HashMultiset.create();
        for (String word : words) {
            multiset.add(word);
        }
        System.out.println(multiset.count("aa"));
    }

    /**
     * Multimap 是一键对多值的HashMap，类似于 Map<K, List> 的数据结构
     *
     * asMap：为Multimap<K, V>提供Map<K,Collection>形式的视图
     * entries：返回所有”键-单个值映射”，包括重复键。Collection<Map.Entry<K, V>>类型
     * keySet：返回所有不同的键，Set类型
     * keys：用Multiset表示Multimap中的所有键，每个键重复出现的次数等于它映射的值的个数。可以从这个Multiset中移除元素，但不能做添加操作；移除操作会反映到底层的Multimap
     * values：用一个”扁平”的Collection包含Multimap中的所有值，包括重复键
     */
    @Test
    public void testMultimap() {
        Multimap<String, String> multimap = ArrayListMultimap.create();
        multimap.put("name", "Jack");
        multimap.put("name", "Jack");
        multimap.put("name", "Tom");
        multimap.put("age", "10");
        multimap.put("age", "12");
        System.out.println(multimap.asMap());
        System.out.println(multimap.keySet() + " -- " + multimap.keys());
        System.out.println(multimap.values());
        System.out.println(multimap.get("name").size());
    }

    /**
     * Map只提供”键-值“的映射，而BiMap则同时提供了”键-值“和”值-键“的映射关系。常用方法：
     *
     * put(K key, V value)：添加新的键、值。如果值和已有键重复，会抛出异常
     * forcePut(K key, V value)：添加新的键、值。如果值和已有键重复，会覆盖原来的键、值
     * inverse()：得到”值-键“的BitMap对象
     */
    @Test
    public void testBiMap() {
        BiMap<String,String> biMap= HashBiMap.create();
        biMap.put("sina","sina.com");
        biMap.put("qq","qq.com");
        biMap.put("sina","sina.cn"); //会覆盖原来的value
        System.out.println(biMap.inverse().get("qq.com"));

        //biMap.put("tecent","qq.com"); //抛出异常
        biMap.forcePut("tecent","qq.com"); //强制替换key
        System.out.println(biMap.get("qq")); //通过value找key
        System.out.println(biMap.inverse().get("qq.com"));
        System.out.println(biMap.inverse().get("sina.com"));
        System.out.println(biMap.inverse().inverse()==biMap);
    }

    RateLimiter limiter = RateLimiter.create(100.0d);

    @JunitPerfConfig(threads = 10, warmUp = 100, duration = 200,
            reporter = {HtmlReporter.class, ConsoleReporter.class})
    public void testRateLimiter() {
        if (limiter != null && limiter.tryAcquire()) {
            System.out.println(" - 被限流");
        } else {
            System.out.println(" - 没有限流");
        }
    }
}
