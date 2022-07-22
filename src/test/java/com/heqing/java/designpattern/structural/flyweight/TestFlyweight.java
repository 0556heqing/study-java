package com.heqing.java.designpattern.structural.flyweight;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 享元模式是一种结构型设计模式。
 * 运用共享技术有效地支持大量细粒度的对象
 *
 * @author heqing
 * @date 2021/12/23 16:51
 */
public class TestFlyweight {

    @Test
    public void testFlyweight() {
        // 学校只有一个机房
        Flyweight computerRoom = Flyweight.getComputerRoom();
        // 机房里只有两台机器（1，2）
        List<Integer> computerCodeList = Arrays.asList(1, 2);
        // 有3位同学
        List<String> studentNameList = Arrays.asList("A同学", "B同学", "C同学");

        // 3位同学都去机房上机
        for(String studentName : studentNameList) {
            Boolean isSuccess = false;
            for(Integer computerCode : computerCodeList) {
                Computer computer = computerRoom.getComputer(computerCode, studentName);
                // 是否成功获取电脑
                isSuccess = isGetComputer(computerCode, studentName, computer);
                if(isSuccess) {
                    break;
                }
            }
            if(isSuccess) {
                continue;
            }
        }


        for(int i=0; i<5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("--------等待了一会--------");
            if(i == 2) {
                System.out.println("--------2号机下线了--------");
                computerRoom.removeComputer(2);
            }

            Boolean isSuccess = false;
            String studentName = "C同学";
            for(Integer computerCode : computerCodeList) {
                Computer computer = computerRoom.getComputer(computerCode, studentName);
                isSuccess = isGetComputer(computerCode, studentName, computer);
                if(isSuccess) {
                    break;
                }
            }
            if(isSuccess) {
                break;
            }
        }
    }

    private Boolean isGetComputer(Integer computerCode, String studentName, Computer computer) {
        Boolean isSuccess = false;
        StringBuilder str = new StringBuilder();
        str.append(studentName);
        if(computer == null) {
            str.append("没获取到电脑" + computerCode);
        } else {
            if(studentName.equals(computer.getStudentName())) {
                str.append("获取到电脑" + computerCode);
                isSuccess = true;
            } else {
                str.append("想获取的" + computerCode + "电脑被" + computer.getStudentName() + "使用了，需要等待");
            }
        }
        System.out.println(str.toString());
        return isSuccess;
    }
}
