package com.se17e.servlet;

import com.se17e.servlet.CustomerServlet;
import com.se17e.util.DBUtil;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class CustomerBillServlet extends HttpServlet {
    static int duration = 0;
    public void init() {//��ص�ǰ�¶Ⱥ�Ŀ���¶��Ƿ���ȣ�����ȣ�ÿ���ӱ仯1��
        Thread t1 = new Thread() {
            public void run() {
                while(true) {
                    try {
                        sleep(60 * 1000);//ʱ��ƬΪ1min������������������bug
                        String startSQL = "(select DATE from " + LoginServlet.roomiid + " where ID = (select min(ID) from " + LoginServlet.roomiid + "))";
                        String endSQL = "(select DATE from " + LoginServlet.roomiid + " where ID = (select max(ID) from " + LoginServlet.roomiid + "))";
                        String sql = "select " + "timestampdiff(second," + startSQL + "," + endSQL + ") as duration";
                        try {
                            ResultSet rs = DBUtil.executeQuery(sql, new Object[]{});
                            while(rs.next()) {
//                            Date time = rs.getDate("DATE");
                                duration = rs.getInt("duration");
//                                System.out.println(duration);
                            }
                            try {
                                DBUtil.connection.close();;
                                DBUtil.pstmt.close();
                                DBUtil.rs.close();
                            }catch(SQLException e) {
                                e.printStackTrace();
                            }
                        }catch(SQLException e) {
                            e.printStackTrace();
                        }
                    }catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();
    }
}
