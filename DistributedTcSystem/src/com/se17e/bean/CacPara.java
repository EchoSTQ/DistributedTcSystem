package com.se17e.bean;

public class CacPara {
	private int mode = 1;	//Ĭ��������
	
	private int speed = 2; //Ĭ�����з�
	
	private int tempHighLimit = 25;	//Ĭ���������25��
	private int tempLowLimit = 18;	//Ĭ���������18��
	
	private int defaultTargetTemp = 25; 	//Ĭ��Ŀ���¶�25��
	
	private int FeeRateH;	//Ĭ����߷��ʣ��߷磩1��/Ԫ
	private int FeeRateM;	//Ĭ���еȷ��ʣ��з磩2��/Ԫ
	private int FeeRateL;	//Ĭ����ͷ��ʣ��ͷ磩3��/Ԫ
	
	public CacPara() {
		super();
	}
	
	public CacPara(int mode, int speed, int tempHighLimit, int tempLowLimit, int defaultTargetTemp, int feeRateH,
			int feeRateM, int feeRateL) {
		super();
		this.mode = mode;
		this.speed = speed;
		this.tempHighLimit = tempHighLimit;
		this.tempLowLimit = tempLowLimit;
		this.defaultTargetTemp = defaultTargetTemp;
		FeeRateH = feeRateH;
		FeeRateM = feeRateM;
		FeeRateL = feeRateL;
	}
	
	public int getMode() {
		return mode;
	}
	public void setMode(int mode) {
		this.mode = mode;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getTempHighLimit() {
		return tempHighLimit;
	}
	public void setTempHighLimit(int tempHighLimit) {
		this.tempHighLimit = tempHighLimit;
	}
	public int getTempLowLimit() {
		return tempLowLimit;
	}
	public void setTempLowLimit(int tempLowLimit) {
		this.tempLowLimit = tempLowLimit;
	}
	public int getDefaultTargetTemp() {
		return defaultTargetTemp;
	}
	public void setDefaultTargetTemp(int defaultTargetTemp) {
		this.defaultTargetTemp = defaultTargetTemp;
	}
	public int getFeeRateH() {
		return FeeRateH;
	}
	public void setFeeRateH(int feeRateH) {
		FeeRateH = feeRateH;
	}
	public int getFeeRateM() {
		return FeeRateM;
	}
	public void setFeeRateM(int feeRateM) {
		FeeRateM = feeRateM;
	}
	public int getFeeRateL() {
		return FeeRateL;
	}
	public void setFeeRateL(int feeRateL) {
		FeeRateL = feeRateL;
	}

}
