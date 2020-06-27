package com.se17e.bean;

/**
 * Created by WenJiachen on 2020/6/26.
 */
//报表用
public class Report {


    public static final int DAY = 1;

    public static final int WEEK = 2;

    public static final int MONTH = 3;

    public static final int YEAR = 4;

    private int type=DAY;	//1：日 2：周报 3：月报 4：年报
    private int switchTimes=0;	//开关空调次数
    private long serviceTime=0;	//使用时间 单位：分钟
    private int totalFee=0;		//这段时间内总费用
    private int	tempChangeTimes=0;	//温度改变次数
    private int speedChangeTimes=0;	//风速改变次数
    private int scheduleTimes=0;		//被调度次数
    private int checkNum=0;			//该时间段内详单数

    public int getType() {
        return  type;
    }
    public int getSwitchTimes() {
        return  switchTimes;
    }
    public long getServiceTime() {
        return  serviceTime;
    }
    public int getTotalFee() {
        return   totalFee;
    }
    public int getTempChangeTimes() {
        return  tempChangeTimes;
    }
    public int getSpeedChangeTimes() {
        return  speedChangeTimes;
    }
    public int getScheduleTimes() {
        return  scheduleTimes;
    }
    public int getCheckNum() {
        return  checkNum;
    }

    public void setType(int num) {
        type=num;
    }
    public void setSwitchTimes(int num) {
        switchTimes=num;
    }
    public void setTotalFee(int num) {
        totalFee=num;
    }
    public void setSpeedChangeTimes(int num) {
        speedChangeTimes=num;
    }
    public void setScheduleTimes(int num) {
        scheduleTimes=num;
    }
    public void setServiceTime(long num) {
        serviceTime=num;
    }
    public void setTempChangeTimes(int num) {
        tempChangeTimes=num;
    }
    public void setCheckNum(int num) {
        checkNum=num;
    }



}
