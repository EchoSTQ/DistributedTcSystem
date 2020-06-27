package com.se17e.bean;

public class Bill {
    private double Duration;//使用时间
    private double Fee;//总费用
    private int Charge;//电荷数

    public Bill() {
        super();
    }

    public double getDuration() {
        return this.Duration;
    }

    public void setDuration(double Duration) {
        this.Duration = Duration;
    }

    public double getFee() {
        return this.Fee;
    }

    public void setFee(double Fee) {
        this.Fee = Fee;
    }

    public int getCharge() {
        return this.Charge;
    }

    public void setCharge(int Charge) {
        this.Charge = Charge;
    }
}
