package com.heqing.java.annotation;

/**
 * @author heqing
 */
public enum RegexType {

    // 无格式
    NONE,

    // 必须为数字
    NUMBER,

    // 必须为身份证
    IDENTITY_CARD,

    // 必须为电话号码
    PHONE_NUMBER,

    // 必须为邮件地址格式
    EMAIL,

    // 必须为网络地址格式
    IP,

    // 必须为日期
    DATE,

    // 只能是有中文字符
    CHINESE,

    // 不能含有特殊字符
    SPECIAL_CHAR;

}
