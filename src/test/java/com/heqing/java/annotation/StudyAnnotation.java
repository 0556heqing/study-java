package com.heqing.java.annotation;

import com.heqing.java.annotation.model.Engineer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudyAnnotation {

    Engineer person = new Engineer();

    @BeforeEach
    public void setPerson() {
        person.setId("1");
        person.setEnglishName("hxb");
        person.setName("贺小白");
        person.setBirthday("2021-07-07");
        person.setCard("340826199009305200");
        person.setEmail("975656343@qq.com");
        person.setPhone("13061750000");
        person.setNetIp("127.0.0.1");
        person.setPostcode("246512");
    }

    @Test
    public void testAnnotation() {
        System.out.println("---> 校验开始！");
        FieldValidate.valid(person);
        System.out.println("---> 校验结束！");
    }
}
