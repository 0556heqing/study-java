package com.heqing.java.designpattern.create.abstractfactory;

import com.heqing.java.designpattern.create.abstractfactory.model.Chip;
import com.heqing.java.designpattern.create.abstractfactory.model.OperatingSystem;

/**
 * @author heqing
 * @date 2021/12/22 14:45
 */
public interface MobilePhoneFactory {

    OperatingSystem createSystem();

    Chip createChip();

    void make();
}
