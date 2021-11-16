package com.heqing.java.annotation.model;

import com.heqing.java.annotation.RegexType;
import com.heqing.java.annotation.StringFieldAnnotation;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author heqing
 */
@NoArgsConstructor
@Data
@ToString
public class Engineer extends Person {

    @StringFieldAnnotation(regexType = RegexType.IP, description = "网络ip")
    private String netIp;
}
