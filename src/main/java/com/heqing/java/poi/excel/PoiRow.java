package com.heqing.java.poi.excel;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author heqing
 */
@Data
public class PoiRow implements Serializable {

    private int num;
    private List<String> cellList;

}
