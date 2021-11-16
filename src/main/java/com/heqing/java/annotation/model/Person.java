package com.heqing.java.annotation.model;

import com.heqing.java.annotation.RegexType;
import com.heqing.java.annotation.StringFieldAnnotation;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author heqing
 */
@NoArgsConstructor
@Data
@ToString
public class Person implements Serializable {

    @StringFieldAnnotation(blackAble = false, regexType = RegexType.NUMBER, min = 1, max = 50, description = "用户id")
    private String id;

    @StringFieldAnnotation(regexType = RegexType.SPECIAL_CHAR, min = 1, max = 50, description = "英文名")
    private String englishName;

    @StringFieldAnnotation(nullAble = false, regexType = RegexType.CHINESE, description = "姓名")
    private String name;

    @StringFieldAnnotation(regexType = RegexType.IDENTITY_CARD, description = "身份证")
    private String card;

    @StringFieldAnnotation(regexType = RegexType.DATE, description = "生日")
    private String birthday;

    @StringFieldAnnotation(regexType = RegexType.EMAIL, max = 50, description = "电子邮件")
    private String email;

    @StringFieldAnnotation(regexType = RegexType.PHONE_NUMBER, description = "电话号码")
    private String phone;

    @StringFieldAnnotation(regexExpression = "[0-9]*", description = "邮编")
    private String postcode;
}
