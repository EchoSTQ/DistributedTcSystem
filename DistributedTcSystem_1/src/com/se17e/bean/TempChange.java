package com.se17e.bean;

public class TempChange {

    private int TargetTemp = 25;    //Ŀ���¶ȣ���ʼĬ��25��

    public TempChange() {
        super();
    }

    public TempChange(int TargetTemp) {
        super();
        this.TargetTemp = TargetTemp;
    }

    public int getTargetTemp() {
        return TargetTemp;
    }
}
