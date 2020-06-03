package com.se17e.bean;

public class WindChange {

    private int CurrentWind = 25;//当前风速，初始化为？
    private int TargetWind = 25;//目标风速，初始化为？

    public WindChange() {
        super();
    }

    public int getCurrentWind() {
        return CurrentWind;
    }

    public void setCurrentWind(int CurrentWind) {
        this.CurrentWind = CurrentWind;
    }

    public int getTargetWind() {
        return TargetWind;
    }

    public void setTargetWind(int TargetWind) {//设置目标温度
        this.TargetWind = TargetWind;
    }
}
