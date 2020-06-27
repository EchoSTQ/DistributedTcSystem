package com.se17e.bean;

import java.util.Date;

public class RDR
{
    private int Room_id; //房间号

    private Date request_time; //开始送风时间

    private Date endService_time; //结束送风时间

    private float duration; //送风时长

    private int FanSpeed; //风速

    private double fee_rate; //费率

    private double fee; //费用

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
