package com.se17e.bean;

public class TempChange {

    private int CurrentTemp = 25;//当前文档，初始默认25度
    private int TargetTemp = 25;//目标温度，初始默认25度

    public TempChange() {
        super();
    }

    public int getCurrentTemp() {//获取当前温度
        return CurrentTemp;
    }

    public void setCurrentTemp(int CurrentTemp) {//设置当前温度
        this.CurrentTemp = CurrentTemp;
    }

    public int getTargetTemp() {//获取目标温度
        return TargetTemp;
    }

    public void setTargetTemp(int TargetTemp) {//设置目标温度
        this.TargetTemp = TargetTemp;
    }
}
