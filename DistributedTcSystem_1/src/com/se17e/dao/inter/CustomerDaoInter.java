package com.se17e.dao.inter;

import com.se17e.bean.TempChange;

public interface CustomerDaoInter {
	public boolean setTargetTemp(TempChange temp, String roomID);
}