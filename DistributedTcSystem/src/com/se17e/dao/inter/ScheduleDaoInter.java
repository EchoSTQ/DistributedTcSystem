package com.se17e.dao.inter;

public interface ScheduleDaoInter {
	//��ʼ��������к͵ȴ����У���������ݿ�WaitingQueue���ServedQueue��
	public int initQueue(String sql, Object[] params);
}
