package com.se17e.dao.impl;

import com.se17e.bean.CacPara;
import com.se17e.bean.RcPara;
import com.se17e.bean.User;
import com.se17e.dao.inter.AdminDaoInter;
import com.se17e.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDaoInter{

	@Override
	public boolean setCentralAcPara(CacPara cacPara) {
		try {
			String sql = "update cacpara set mode=?,speed=?,temphighlimit=?,"
					+ "templowlimit=?,defaulttargettemp=?,feerateh=?,"
					+ "feeratem=?,feeratel=? where id=1;";
			int result = DBUtil.executeUpdate(sql, new Object[]{cacPara.getMode(),cacPara.getSpeed(),
					cacPara.getTempHighLimit(),cacPara.getTempHighLimit(),cacPara.getDefaultTargetTemp(),
					cacPara.getFeeRateH(),cacPara.getFeeRateM(),cacPara.getFeeRateL(),});
			
			return result == 1;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public RcPara checkRoomState(String sql, Object[] params, String roomID){
		//使用user接收查询结果
		RcPara rcPara;
		ResultSet rs = null;

		try {
			rs = DBUtil.executeQuery(sql, params);

			String targetTemp = "", targetSpeed = "", mode = "";
			while(rs.next()){
				targetTemp = rs.getString("TARGET_TEMP");
				targetSpeed = rs.getString("TARGET_SPEED");
				mode = rs.getString("MODE");
			}
			if(mode == ""){
				mode = "关机";
			}
			rcPara = new RcPara(Integer.parseInt(roomID),mode,targetSpeed,targetTemp);

			return rcPara;

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

	
}
