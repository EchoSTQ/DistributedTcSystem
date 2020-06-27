package com.se17e.dao.inter;

import com.se17e.bean.CacPara;
import com.se17e.bean.RcPara;

public interface AdminDaoInter {
	public boolean setCentralAcPara(CacPara cacPara);

	public RcPara checkRoomState(String sql, Object[] params, String roomID);
}
