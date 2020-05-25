package com.se17e.bean;

public class User {
	/**
	 * ����Ա�����û�
	 */
	public static final int USER_ADMIN = 1;
	
	/**
	 * �˿����û�
	 */
	public static final int USER_CUSTOMER = 2;
	
	/**
	 * ǰ̨�����û�
	 */
	public static final int USER_RECEPTIONIST = 3;
	
	private int id; //ID
	
	private String IDnumber; //���֤��
	
	private String password = "111111"; //���룺Ĭ��'111111'
	
	private String name; //�û�����
	
	public User() {
		super();
	}
	
	public User(String iDnumber, String password) {
		super();
		IDnumber = iDnumber;
		this.password = password;
	}

	private int type = USER_CUSTOMER; // �˻����ͣ�Ĭ��2Ϊ�˿ͣ�3Ϊ����Ա��2Ϊ�˿ͣ�1Ϊǰ̨

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIDnumber() {
		return IDnumber;
	}

	public void setIDnumber(String iDnumber) {
		IDnumber = iDnumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}
