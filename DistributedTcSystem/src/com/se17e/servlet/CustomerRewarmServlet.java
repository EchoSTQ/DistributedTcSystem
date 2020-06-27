package com.se17e.servlet;

import com.se17e.servlet.CustomerServlet;

import javax.servlet.http.HttpServlet;

public class CustomerRewarmServlet extends HttpServlet {
    public void init() {//监控当前温度和目标温度是否相等，若相等，每分钟变化1度
        Thread t1 = new Thread() {
            public void run() {
                try {
                    sleep(60 * 1000);
                    while(true) {
                        sleep(60 * 1000);
                        if(CustomerServlet.subOrNot) {//判断是否可以回温
                            int i = CustomerServlet.room.getCurrentTemp();
                            if(i > CustomerServlet.room.getInitTemp()) {//降温
                                CustomerServlet.room.setCurrentTemp(i - 1);
                            }else if(i < CustomerServlet.room.getInitTemp()) {//升温
                                CustomerServlet.room.setCurrentTemp(i + 1);
                            }else {//不变

                            }

                        }
//                        System.out.println("sleep");
                    }
                }catch(Exception e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();
    }
}