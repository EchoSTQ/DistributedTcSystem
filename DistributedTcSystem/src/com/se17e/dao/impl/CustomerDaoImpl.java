package com.se17e.dao.impl;

import com.se17e.bean.Bill;
import com.se17e.bean.TempChange;
import com.se17e.bean.WindChange;
import com.se17e.dao.inter.CustomerDaoInter;
import com.se17e.util.DBUtil;

public class CustomerDaoImpl implements CustomerDaoInter {

	@Override
	public boolean setTargetTemp(TempChange temp, String roomID) {
		try {
			//更新用户目标温度，id为用户房间号
			//sql查询语句里变量名待定
			String sql = "update cacpara set targettemp = ? where id = " + roomID + ";";
			int result = DBUtil.executeUpdate(sql, new Object[]{temp.getTargetTemp(),});
			
			return result == 1;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public TempChange getTargetTemp(String roomID) {
		TempChange temp = new TempChange();//不关心持久化怎么实现，只需返回一个TargetTemp即可
		return temp;
	}

	public boolean setTargetWind(WindChange wind, String roomID) {
		try {
			//更新用户目标风速，id为用户房间号
			//sql查询语句里变量名待定
			String sql = "update cacpara set targetwind = ? where id = " + roomID + ";";
			int result = DBUtil.executeUpdate(sql, new Object[]{wind.getTargetWind(),});

			return result == 1;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public WindChange getTargetWind(String roomID) {
		WindChange wind = new WindChange();//不关心持久化怎么实现，只需返回一个TargetWind即可
		return wind;
	}

	public Bill getBill(String roomID) {
		Bill bill = new Bill();//不关心持久化怎么实现，只需返回一个Bill即可
		return bill;
	}
}
