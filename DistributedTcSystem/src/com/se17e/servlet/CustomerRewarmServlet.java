package com.se17e.servlet;

import com.se17e.servlet.CustomerServlet;

import javax.servlet.http.HttpServlet;

public class CustomerRewarmServlet extends HttpServlet {
    public void init() {//��ص�ǰ�¶Ⱥ�Ŀ���¶��Ƿ���ȣ�����ȣ�ÿ���ӱ仯1��
        Thread t1 = new Thread() {
            public void run() {
                try {
                    sleep(60 * 1000);
                    while(true) {
                        sleep(60 * 1000);
                        if(CustomerServlet.subOrNot) {//�ж��Ƿ���Ի���
                            int i = CustomerServlet.room.getCurrentTemp();
                            if(i > CustomerServlet.room.getInitTemp()) {//����
                                CustomerServlet.room.setCurrentTemp(i - 1);
                            }else if(i < CustomerServlet.room.getInitTemp()) {//����
                                CustomerServlet.room.setCurrentTemp(i + 1);
                            }else {//����

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