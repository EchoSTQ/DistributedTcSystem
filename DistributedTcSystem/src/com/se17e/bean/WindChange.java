package com.se17e.bean;

public class WindChange {

    private int CurrentWind = 25;//��ǰ���٣���ʼ��Ϊ��
    private int TargetWind = 25;//Ŀ����٣���ʼ��Ϊ��

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

    public void setTargetWind(int TargetWind) {//����Ŀ���¶�
        this.TargetWind = TargetWind;
    }
}
