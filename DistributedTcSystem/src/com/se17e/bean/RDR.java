package com.se17e.bean;

import java.util.Date;

public class RDR
{
    private int Room_id; //�����

    private Date request_time; //��ʼ�ͷ�ʱ��

    private Date endService_time; //�����ͷ�ʱ��

    private float duration; //�ͷ�ʱ��

    private int FanSpeed; //����

    private double fee_rate; //����

    private double fee; //����

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public int getRoom_id() {
        return Room_id;
    }

    public void setRoom_id(int room_id) {
        Room_id = room_id;
    }

    public int getFanSpeed() {
        return FanSpeed;
    }

    public void setFanSpeed(int fanSpeed) {
        FanSpeed = fanSpeed;
    }

    public double getFee_rate() {
        return fee_rate;
    }

    public void setFee_rate(double fee_rate) {
        this.fee_rate = fee_rate;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public Date getRequest_time() {
        return request_time;
    }

    public void setRequest_time(Date request_time) { this.request_time = request_time; }

    public Date getEndService_time() {
        return endService_time;
    }

    public void setEndService_time(Date endService_time) {
        this.endService_time = endService_time;
    }
}
