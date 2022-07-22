package com.heqing.java.designpattern.behavioral.state;

/**
 * @author heqing
 * @date 2021/12/24 17:11
 */
public class Flow {

    /**
     * 流程状态 0：发起申请 1:驳回 2.上级领导通过 3.hr通过
     */
    private int status;

    private String message;
    private int day;

    private Node node;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
        this.node.nodeHandle(this);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void start() {
        this.setStatus(0);
        this.setNode(new LeadNode());
    }
}
