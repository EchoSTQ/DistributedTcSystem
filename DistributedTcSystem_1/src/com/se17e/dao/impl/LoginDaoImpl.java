package com.se17e.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.se17e.bean.User;
import com.se17e.dao.inter.LoginDaoInter;
import com.se17e.util.DBUtil;

public class LoginDaoImpl implements LoginDaoInter{

	//���ҹ���Ա�Ƿ���ڣ����ؽ����һ����¼
	@Override
	public User getAdminObject(String sql, Object[] params) {
		
		//ʹ��user���ղ�ѯ���
		User user = null;
		ResultSet rs = null;
		
		try {
			rs = DBUtil.executeQuery(sql, params);
			
			rs.next();//��һ��debug,����д��һ��
			String idnumber = rs.getString("IDnumber");
			String pwd = rs.getString("password");
			
			user = new User(idnumber, pwd);
			
			return user;
			
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if(rs != null) rs.close();
				if(DBUtil.connection != null) DBUtil.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	//���ҹ˿��Ƿ����,����û�б�Ҫ�������
	@Override
	public User getCustomerObject(String sql, Object[] params) {
		return null;
	}

	//����ǰ̨�Ƿ����,����û�б�Ҫ�������
	@Override
	public User getReceptionistObject(String sql, Object[] params) {
		return null;
	}

}
