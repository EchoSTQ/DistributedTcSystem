package com.se17e.bean;

public class TempChange {

    private int CurrentTemp = 25;//��ǰ�ĵ�����ʼĬ��25��
    private int TargetTemp = 25;//Ŀ���¶ȣ���ʼĬ��25��

    public TempChange() {
        super();
    }

    public int getCurrentTemp() {//��ȡ��ǰ�¶�
        return CurrentTemp;
    }

    public void setCurrentTemp(int CurrentTemp) {//���õ�ǰ�¶�
        this.CurrentTemp = CurrentTemp;
    }

    public int getTargetTemp() {//��ȡĿ���¶�
        return TargetTemp;
    }

    public void setTargetTemp(int TargetTemp) {//����Ŀ���¶�
        this.TargetTemp = TargetTemp;
    }
}
