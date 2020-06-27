package com.se17e.dao.inter;

import com.se17e.bean.Room;
import com.se17e.bean.Bill;
import com.se17e.bean.TempChange;
import com.se17e.bean.WindChange;

public interface CustomerDaoInter {
    public boolean updateRoom(Room room);
    public boolean setTargetTemp(TempChange temp, String roomID);
    public TempChange getTargetTemp(String roomID);
    public boolean setTargetWind(WindChange wind, String roomID);
    public WindChange getTargetWind(String roomID);
    public Bill getBill(String roomID);
}