package com.se17e.service;

import com.se17e.bean.Bill;
import com.se17e.bean.RoomID;
import com.se17e.bean.TempChange;
import com.se17e.bean.WindChange;
import com.se17e.dao.impl.CustomerDaoImpl;
import com.se17e.dao.inter.CustomerDaoInter;

public class CustomerService {
//    private static RoomID room = new RoomID();
//    private static CustomerDaoInter dao = new CustomerDaoImpl();//持久化对象
//
//    public static void setRoomID(RoomID roomI) {//房间对象由系统注册生成，提供该方法给system传递生成的RoomID对象
//        room = roomI;
//    }
//
//    public static RoomID getRoom() {//供用户其他业务逻辑和servlet使用房间号对象
//        return room;
//    }
//
//    public static boolean setTemp(TempChange temp) {//将用户温度发送至持久化层
//        return dao.setTargetTemp(temp, room.getRoomID());
//    }
//
//    public static TempChange getTemp() {//将用户温度发送至控制层
//        return dao.getTargetTemp(room.getRoomID());
//    }
//
//    public static boolean setWind(WindChange wind) {//将用户风速发送至持久化层
//        return dao.setTargetWind(wind, room.getRoomID());
//    }
//
//    public static WindChange getWind() {//将用户风速发送至控制层
//        return dao.getTargetWind(room.getRoomID());
//    }
//
//    public static Bill getBill(String roomID) {//将用户账单发送至控制层
//        return dao.getBill(room.getRoomID());
//    }
}
