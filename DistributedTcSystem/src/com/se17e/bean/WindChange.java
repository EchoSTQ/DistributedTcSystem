package com.se17e.bean;

public class WindChange {

    //������0��1��2�ֱ����ͣ��У���
    private int CurrentWind = 0;//��ǰ����
    private int TargetWind = 0;//Ŀ�����

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
