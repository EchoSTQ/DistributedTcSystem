package com.se17e.service;

import com.se17e.bean.Bill;
import com.se17e.bean.RoomID;
import com.se17e.bean.TempChange;
import com.se17e.bean.WindChange;
import com.se17e.dao.impl.CustomerDaoImpl;
import com.se17e.dao.inter.CustomerDaoInter;

public class CustomerService {
    private static RoomID room = new RoomID();
    private static CustomerDaoInter dao = new CustomerDaoImpl();//�־û�����

    public static void setRoomID(RoomID roomI) {//���������ϵͳע�����ɣ��ṩ�÷�����system�������ɵ�RoomID����
        room = roomI;
    }

    public static RoomID getRoom() {//���û�����ҵ���߼���servletʹ�÷���Ŷ���
        return room;
    }

    public static boolean setTemp(TempChange temp) {//���û��¶ȷ������־û���
        return dao.setTargetTemp(temp, room.getRoomID());
    }

    public static TempChange getTemp() {//���û��¶ȷ��������Ʋ�
        return dao.getTargetTemp(room.getRoomID());
    }

    public static boolean setWind(WindChange wind) {//���û����ٷ������־û���
        return dao.setTargetWind(wind, room.getRoomID());
    }

    public static WindChange getWind() {//���û����ٷ��������Ʋ�
        return dao.getTargetWind(room.getRoomID());
    }

    public static Bill getBill(String roomID) {//���û��˵����������Ʋ�
        return dao.getBill(room.getRoomID());
    }
}
