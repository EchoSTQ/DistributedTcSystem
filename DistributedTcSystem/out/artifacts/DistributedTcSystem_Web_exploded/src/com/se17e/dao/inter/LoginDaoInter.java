package com.se17e.dao.inter;

import com.se17e.bean.User;

public interface LoginDaoInter {
	//���ҹ���Ա�Ƿ���ڣ����ؽ����һ����¼
	public User getAdminObject(String sql, Object[] params);
	
	//���ҹ˿��Ƿ����,����û�б�Ҫ�������
	public User getCustomerObject(String sql, Object[] params);
	
	//����ǰ̨�Ƿ����,����û�б�Ҫ�������
	public User getReceptionistObject(String sql, Object[] params);
}
