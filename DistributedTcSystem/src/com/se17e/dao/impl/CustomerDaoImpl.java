package com.se17e.dao.impl;

import com.se17e.bean.TempChange;
import com.se17e.dao.inter.CustomerDaoInter;
import com.se17e.util.DBUtil;

public class CustomerDaoImpl implements CustomerDaoInter {

	@Override
	public boolean setTargetTemp(TempChange temp, String roomID) {
		try {
			//�����û�Ŀ���¶ȣ�idΪ�û������
			//sql��ѯ��������������
			String sql = "update cacpara set targettemp = ? where id = " + roomID + ";";
			int result = DBUtil.executeUpdate(sql, new Object[]{temp.getTargetTemp(),});
			
			return result == 1;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
