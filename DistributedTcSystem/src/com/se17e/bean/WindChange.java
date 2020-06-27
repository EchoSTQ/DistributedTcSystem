package com.se17e.bean;

public class WindChange {

    //风速用0，1，2分别代表低，中，高
    private int CurrentWind = 0;//当前风速
    private int TargetWind = 0;//目标风速

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
