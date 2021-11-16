package com.heqing.java.annotation;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Arrays;

import static com.heqing.java.annotation.RegexType.NUMBER;

/**
 * @author heqing
 */

public class FieldValidate {

    private static Logger log = LoggerFactory.getLogger(FieldValidate.class);

    public static void valid(Object object) {
        // 获取对象的基本信息
        Class<? extends Object> clazz = object.getClass();
        // 获取对象及父类的属性信息
        Field[] fields = new Field[]{};
        fields = recurseSuper(clazz, fields);

        Arrays.asList(fields).stream().distinct().forEach(field -> {
            // 允许访问属性私有变量
            field.setAccessible(true);
            // 验证属性值是否正常
            validate(object, field);
            // 设置不允许
            field.setAccessible(false);
        });
    }

    private static Field[] recurseSuper(Class<? extends Object> clazz,  Field[] fields) {
        if (clazz != null) {
            // 获取当前 对象的属性信息
            fields = (Field[]) ArrayUtils.addAll(fields, clazz.getDeclaredFields());
        }
        // 是否存在父对象
        if (clazz.getSuperclass() != null) {
            // 获取父对象的属性信息
            fields = recurseSuper(clazz.getSuperclass(), fields);
        }
        return fields;
    }

    public static void validate(Object object, Field field) {
        // 判断哪个注解
        if(field.isAnnotationPresent(StringFieldAnnotation.class)) {
            validateStringField(object, field);
        }
    }

    static void validateStringField(Object object, Field field) {
        String string  = "class java.lang.String";
        if (!string.equals(field.getGenericType().toString())) {
            log.warn("类：{} 属性：{} 不是String类型，不应该使用该注解 ", object.getClass().getName(), field.getName());
            return;
        }

        // 获取属性值
        Object value = null;
        try {
            value = field.get(object);
        } catch (Exception var6) {
            var6.printStackTrace();
            log.error("reflect error:" + var6.getMessage(), var6);
        }
        // 获取类名
        String className = object.getClass().getName();
        // 获取字段名
        String fieldName = field.getName();

        // 获取注解属性
        StringFieldAnnotation stringField = field.getDeclaredAnnotation(StringFieldAnnotation.class);
        if(stringField != null) {
            checkStringField(stringField, className, fieldName, value);
        }
    }

    private static void checkStringField(StringFieldAnnotation stringField, String className, String fieldName, Object value) {
        if (!stringField.nullAble() && value == null) {
            log.error("类：{} 属性：{} 参数未传入", className, fieldName);
        } else if (!stringField.blackAble() && (value == null || StringUtils.isBlank(value.toString()))) {
            log.error("类：{} 属性：{}  值不能为null或空字符串", className, fieldName);
        } else if(value !=null && StringUtils.isNotBlank(value.toString())) {
            if(stringField.regexType() == NUMBER) {
                if (!NumberUtils.isNumber(value.toString())) {
                    log.error("类：{} 属性：{}  不是数字，传入值：{}", className, fieldName, value.toString());
                } else if (stringField.max() != 0 && Double.valueOf(value.toString()) > stringField.max()) {
                    log.error("类：{} 属性：{}  值不能大于 {}，传入值：{}", className, fieldName, stringField.max(), value.toString());
                } else if (stringField.min() != 0 && Long.valueOf(value.toString()) < stringField.min()) {
                    log.error("类：{} 属性：{}  值不能小于 {}，传入值：{}", className, fieldName, stringField.min(), value.toString());
                }
            } else {
                if (stringField.max() != 0 && value.toString().length() > stringField.max()) {
                    log.error("类：{} 属性：{}  长度不能超过 {}，传入值：{}", className, fieldName, stringField.max(), value.toString());
                } else if (stringField.min() != 0 && value.toString().length() < stringField.min()) {
                    log.error("类：{} 属性：{}  长度不能小于 {}，传入值：{}", className, fieldName, stringField.min(), value.toString());
                }
                switch (stringField.regexType()) {
                    case IDENTITY_CARD :
                        if (!RegexUtils.isIdentityCard(value.toString())) {
                            log.error("类：{} 属性：{}  不是身份证号码，传入值：{}", className, fieldName, value.toString());
                        }
                        break;
                    case PHONE_NUMBER :
                        if (!RegexUtils.isPhoneNumber(value.toString())) {
                            log.error("类：{} 属性：{}  不是电话号码，传入值：{}", className, fieldName, value.toString());
                        }
                        break;
                    case EMAIL :
                        if (!RegexUtils.isEmail(value.toString())) {
                            log.error("类：{} 属性：{}  不是电子邮件，传入值：{}", className, fieldName, value.toString());
                        }
                        break;
                    case IP :
                        if (!RegexUtils.isIp(value.toString())) {
                            log.error("类：{} 属性：{}  不是网络IP，传入值：{}", className, fieldName, value.toString());
                        }
                        break;
                    case DATE :
                        if (!RegexUtils.isDate(value.toString())) {
                            log.error("类：{} 属性：{}  不是日期，传入值：{}", className, fieldName, value.toString());
                        }
                        break;
                    case CHINESE :
                        if (!RegexUtils.isChinese(value.toString())) {
                            log.error("类：{} 属性：{}  只能是中文字符，传入值：{}", className, fieldName, value.toString());
                        }
                        break;
                    case SPECIAL_CHAR :
                        if (RegexUtils.hasSpecialChar(value.toString())) {
                            log.error("类：{} 属性：{}  不能含有特殊字符，传入值：{}", className, fieldName, value.toString());
                        }
                        break;
                    default:
                        break;
                }
                if (StringUtils.isNotBlank(stringField.regexExpression()) && !RegexUtils.matches(value.toString(), stringField.regexExpression())) {
                    log.error("类：{} 属性：{}  格式不正确，传入值：{}， 正则格式为：{}", className, fieldName, value.toString(), stringField.regexExpression());
                }
            }
        }
    }
}
