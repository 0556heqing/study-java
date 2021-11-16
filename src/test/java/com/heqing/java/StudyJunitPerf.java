package com.heqing.java;

import com.github.houbb.junitperf.core.annotation.JunitPerfConfig;
import com.github.houbb.junitperf.core.annotation.JunitPerfRequire;
import com.github.houbb.junitperf.core.report.impl.ConsoleReporter;
import com.github.houbb.junitperf.core.report.impl.HtmlReporter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudyJunitPerf {

    private static Logger log = LoggerFactory.getLogger(StudyJunitPerf.class);

    /**
     * JunitPerfConfig
     * threads : 执行时使用多少线程执行
     * warmUp : 准备时间（单位：毫秒）
     * duration : 执行时间。（单位：毫秒）
     *      默认值：默认为 1min，这里的执行时间不包含准备时间。
     * reporter : 报告输出形式
     *      HtmlReporter :  html存在 target 中
     *      ConsoleReporter : 命令行
     *
     *  配置：2个线程运行。准备时间1000ms,执行时间2000ms
     */
    @JunitPerfConfig(threads = 2, warmUp = 1000, duration = 2000,
            reporter = {HtmlReporter.class, ConsoleReporter.class})
    public void testJunitPerfConfig() {
            log.info("--- test ---");
    }

    /**
     * JunitPerfRequire
     * min : 最快的运行耗时（单位：毫秒）。如果超过该数视为失败
     * max : 最坏的运行耗时（单位：毫秒）。如果超过该数视为失败
     * average : 平均运行耗时（单位：毫秒）。如果超过该数视为失败
     * timesPerSecond : 每秒的最小执行次数。如果低于这个最小执行次数，则视为失败
     *
     * 配置：2个线程运行。准备时间1000ms,执行时间2000ms
     * 要求：最快不低于200ms，最慢不低于250ms，平均不低于225，每秒运行次数不低于5次， 20%的数据不低于220，50%的数据不低于230
     */
    @JunitPerfConfig(threads = 2, warmUp = 1_000, duration = 20_000, reporter = {HtmlReporter.class})
    @JunitPerfRequire(min = 200, max = 500, average = 3500, timesPerSecond = 1000, percentiles = {"20:120", "50:150"})
    public void testJunitPerfRequire() {
        log.info("--- test ---");
    }

}