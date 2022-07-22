package com.heqing.java.designpattern.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author heqing
 * @date 2021/12/23 18:30
 */
public class Flyweight {

    private static Flyweight computerRoom = new Flyweight();

    private Flyweight() {}

    public static Flyweight getComputerRoom() {
        return computerRoom;
    }

    private static Map<Integer, Computer> computerMap = new HashMap<>();

    //享元工厂
    public Computer getComputer(Integer code, String studentName) {
        Computer computer = null;

        if(computerMap.containsKey(code)) {
            computer = computerMap.get(code);
        } else {
            computer = new Desktop();
            computer.setStudentName(studentName);
            computerMap.put(code, computer);
        }

        return computer;
    }

    public void removeComputer(Integer code) {
        computerMap.remove(code);
    }
}
