package com.heqing.java;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudyLog4j {

    private static Logger log = LoggerFactory.getLogger(StudyLog4j.class);

    @Test
    public void testLog4j() {
        log.debug("----> debug");
        log.info("----> info");
        log.warn("----> warn");
        log.error("----> error");
    }

}
