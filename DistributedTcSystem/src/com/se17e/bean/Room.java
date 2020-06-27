package com.se17e.bean;

import javax.persistence.Id;

public class Room {
    public static String RoomID = "room";
    private static int initTemp = 0;
    private String IDnumber = "IDnumber";
    private int Switch = 0;
    private int TargetTemp = 25;
    private int TargetSpeed = 1;
    private int CurrentTemp = 25;
    private int CurrentSpeed = 1;
    private String Date = "";
    private int Mode = 0;

    public Room() {
        super();
    }

    public void setInitTemp(int initTemp) {
        this.initTemp = initTemp;
    }

    public int getInitTemp() {
        return this.initTemp;
    }

    public void setIDnumber(String IDnumber) {
        this.IDnumber = IDnumber;
    }

    public String getIDnumber() {
        return this.IDnumber;
    }

    public void setSwitch(int Switch) {
        this.Switch = Switch;
    }

    public int getSwitch() {
        return this.Switch;
    }

    public void setTargetTemp(int TargetTemp) {
        this.TargetTemp = TargetTemp;
    }

    public int getTargetTemp() {
        return this.TargetTemp;
    }

    public void setTargetSpeed(int TargetSpeed) {
        this.TargetSpeed = TargetSpeed;
    }

    public int getTargetSpeed() {
        return this.TargetSpeed;
    }

    public void setCurrentTemp(int CurrentTemp) {
        this.CurrentTemp = CurrentTemp;
    }

    public int getCurrentTemp() {
        return this.CurrentTemp;
    }

    public void setCurrentSpeed(int CurrentSpeed) {
        this.CurrentSpeed = CurrentSpeed;
    }

    public int getCurrentSpeed() {
        return this.CurrentSpeed;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getDate() {
        return this.Date;
    }

    public void setMode(int Mode) {
        this.Mode = Mode;
    }

    public int getMode() {
        return this.Mode;
    }
}
