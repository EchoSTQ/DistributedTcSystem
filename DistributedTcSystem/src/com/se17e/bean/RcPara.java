package com.se17e.bean;

/**
 * Created by WenJiachen on 2020/6/25.
 */
public class RcPara {
    private int id;

    private String mode;

    private String speed;

    private String tem;

    public RcPara() {
        super();
    }
    public RcPara(int id, String mode, String speed, String tem) {
        this.id = id;
        this.mode = mode;
        this.speed = speed;
        this.tem = tem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getTem() {
        return tem;
    }

    public void setTem(String tem) {
        this.tem = tem;
    }
}
