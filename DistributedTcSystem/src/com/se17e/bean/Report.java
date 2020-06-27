package com.se17e.bean;

/**
 * Created by WenJiachen on 2020/6/26.
 */
//������
public class Report {


    public static final int DAY = 1;

    public static final int WEEK = 2;

    public static final int MONTH = 3;

    public static final int YEAR = 4;

    private int type=DAY;	//1���� 2���ܱ� 3���±� 4���걨
    private int switchTimes=0;	//���ؿյ�����
    private long serviceTime=0;	//ʹ��ʱ�� ��λ������
    private int totalFee=0;		//���ʱ�����ܷ���
    private int	tempChangeTimes=0;	//�¶ȸı����
    private int speedChangeTimes=0;	//���ٸı����
    private int scheduleTimes=0;		//�����ȴ���
    private int checkNum=0;			//��ʱ������굥��

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
