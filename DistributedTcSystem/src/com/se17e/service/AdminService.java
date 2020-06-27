package com.se17e.service;

import com.se17e.bean.CacPara;
import com.se17e.bean.RcPara;
import com.se17e.dao.impl.AdminDaoImpl;
import com.se17e.dao.inter.AdminDaoInter;

public class AdminService {
	public static boolean setCacPara(CacPara cacPara) {
		AdminDaoInter dao = new AdminDaoImpl();
		
		return dao.setCentralAcPara(cacPara);
	}

	public static RcPara getRoomState(String roomID){
		AdminDaoInter dao = new AdminDaoImpl();
		String sql = "select * from room" + roomID + " where SWITCH = 3;";
		RcPara rc = dao.checkRoomState(sql, new Object[]{}, roomID);
		return rc;
	}
}
