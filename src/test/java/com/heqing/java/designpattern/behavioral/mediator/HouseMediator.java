package com.heqing.java.designpattern.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author heqing
 * @date 2021/12/24 14:40
 */
public class HouseMediator implements Mediator {

    public HouseMediator() {
        System.out.println("我是资深房产中介");
    }

    List<Buyer> buyerList = new ArrayList<>();
    List<Seller> sellerList = new ArrayList<>();

    public void addBuyer(Buyer buyer) {
        buyerList.add(buyer);
    }

    public void addSeller(Seller seller) {
        sellerList.add(seller);
    }

    public void sendMsg(Person person, String msg) {
        if(person instanceof Buyer) {
            for (Seller seller : sellerList) {
                seller.receive(person.getName() + msg);
            }
        } else if(person instanceof Seller) {
            for(Buyer buyer : buyerList) {
                buyer.receive(person.getName() + msg);
            }
        }
    }
}
