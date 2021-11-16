package com.heqing.java.annotation;

import org.apache.commons.lang.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * @author heqing
 */
public class RegexUtils {

    public static boolean matches(String str, String regex) {
        if (null != str && !"".equals(str)) {
            return str.matches(regex);
        } else {
            return false;
        }
    }

    /**
     * 判断是否时手机号
     * @param phoneNumber 手机号
     * @return
     */
    public static boolean isPhoneNumber(String phoneNumber) {
        String regex = "^1\\d{10}$";
        return matches(phoneNumber, regex);
    }

    /**
     * 判断是否是电子邮件
     * @param email 电子邮件
     * @return
     */
    public static boolean isEmail(String email) {
        String regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
        return matches(email, regex);
    }

    /**
     * 判断是否是网络ip地址
     * @param ip 网络ip地址
     * @return
     */
    public static boolean isIp(String ip) {
        String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
        return matches(ip, regex);
    }

    /**
     * 是否是身份证号码
     * @param cardNum 身份证号码
     * @return
     */
    public static boolean isIdentityCard(String cardNum) {
        String regex = "(\\d{17}[0-9a-zA-Z])|(\\d{14}[0-9a-zA-Z])";
        return matches(cardNum, regex);
    }

    private static String[] parsePatterns = {"yyyy-MM-dd","yyyy年MM月dd日","yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
            "yyyy/MM/dd","yyyy/MM/dd HH:mm:ss","yyyy/MM/dd HH:mm", "yyyyMMdd"};

    /**
     * 是否为日期
     * @param date 日期
     * @return
     */
    public static boolean isDate(String date) {
        if (null != date && !"".equals(date)) {
            try {
                Date d = DateUtils.parseDate(date, parsePatterns);
                if(d != null) {
                    return true;
                } else {
                    return false;
                }
            } catch (ParseException e) {
                return false;
            }
        } else {
            return false;
        }
    }

    private static boolean isChineseByCahr(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        return ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION;
    }

    /**
     * 是否都是汉字
     * @param strName 字符串
     * @return
     */
    public static boolean isChinese(String strName) {
        boolean isChinese = true;
        char[] ch = strName.toCharArray();
        for(int i = 0; i < ch.length; ++i) {
            char c = ch[i];
            if (!isChineseByCahr(c)) {
                isChinese = false;
                break;
            }
        }
        return isChinese;
    }

    /**
     * 是否存在特殊字符
     * @param text 文本
     * @return
     */
    public static boolean hasSpecialChar(String text) {
        boolean isSpecial = false;
        String[] ch = text.split("");
        for(int i = 0; i < ch.length; ++i) {
            String regex = "[ _`~!@#$%^&*()+=|{}':;',<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
            if(matches(ch[i], regex)) {
                isSpecial = true;
                break;
            }
        }
        return isSpecial;
    }

}
