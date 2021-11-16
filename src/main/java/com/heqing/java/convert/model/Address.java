package com.heqing.java.convert.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author heqing
 */
@NoArgsConstructor
@Data
@ToString
public class Address {

    private String provice;
    private String city;
    private String area;

}
