package com.se17e.bean;

public class TempChange {

    private int TargetTemp = 25;    //目标温度，初始默认25度

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
