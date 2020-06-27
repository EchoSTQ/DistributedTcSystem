package com.se17e.dao.impl;

import java.util.Date;
import java.text.SimpleDateFormat;
import com.se17e.bean.Room;
import com.se17e.bean.Bill;
import com.se17e.bean.TempChange;
import com.se17e.bean.WindChange;
import com.se17e.dao.inter.CustomerDaoInter;
import com.se17e.util.DBUtil;
import com.se17e.servlet.LoginServlet;

public class CustomerDaoImpl implements CustomerDaoInter {

    @Override
    public boolean updateRoom(Room room) {//������ͣ/����
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String Date = "'" + df.format(new Date()) + "'";
            String IDnumber = "'" + room.getIDnumber() + "'";
            String sql = "insert into " +  LoginServlet.roomiid +
                    "(IDnumber,SWITCH,TARGET_TEMP,TARGET_SPEED,CURRENT_TEMP,CURRENT_SPEED,DATE,MODE) " +
                    "values(" +
                    IDnumber + "," +
                    room.getSwitch() + "," +
                    room.getTargetTemp() + "," +
                    room.getTargetSpeed() + "," +
                    room.getCurrentTemp() + "," +
                    room.getCurrentSpeed() + "," +
                    Date + "," +
                    room.getMode() + ");";
            int result = DBUtil.executeUpdate(sql, new Object[]{});
            return result == 1;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public TempChange getTargetTemp(String roomID) {
        TempChange temp = new TempChange();//�����ĳ־û���ôʵ�֣�ֻ�践��һ��TargetTemp����
        return temp;
    }

    public boolean setTargetTemp(TempChange temp, String roomID) {
        return true;
    }

    public boolean setTargetWind(WindChange wind, String roomID) {
        try {
            //�����û�Ŀ����٣�idΪ�û������
            //sql��ѯ��������������
            String sql = "update cacpara set targetwind = ? where id = " + roomID + ";";
            int result = DBUtil.executeUpdate(sql, new Object[]{wind.getTargetWind(),});

            return result == 1;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public WindChange getTargetWind(String roomID) {
        WindChange wind = new WindChange();//�����ĳ־û���ôʵ�֣�ֻ�践��һ��TargetWind����
        return wind;
    }

    public Bill getBill(String roomID) {
        Bill bill = new Bill();//�����ĳ־û���ôʵ�֣�ֻ�践��һ��Bill����
        return bill;
    }
}
