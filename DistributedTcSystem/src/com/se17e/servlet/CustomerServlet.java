package com.se17e.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.se17e.bean.Room;
import com.se17e.bean.TempChange;
import com.se17e.bean.WindChange;
import com.se17e.util.DBUtil;

public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static Room room;
    static int ij = 0;//�ж��Ƿ��ʼ����������
    static boolean subOrNot = false;//�жϵ�ǰ�Ƿ���Ҫ����
    static double degree = 0;//��¼�õ����
    static double cost = 0;//��¼�ܷ���

    public void init() {
        room  = new Room();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(ij == 0) {//��ʼ����������
            if(LoginServlet.roomiid == "room1") {
                room.setInitTemp(32);
            }else if(LoginServlet.roomiid == "room2") {
                room.setInitTemp(28);
            }else if(LoginServlet.roomiid == "room3") {
                room.setInitTemp(30);
            }else if(LoginServlet.roomiid == "room4") {
                room.setInitTemp(29);
            }else if(LoginServlet.roomiid == "room5") {
                room.setInitTemp(35);
            }
            ij = 1;
        }

        String method = request.getParameter("method");
        if(method.equalsIgnoreCase("PowerOn")) {//��������Դ
            room.RoomID = LoginServlet.roomiid;

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String Date = "'" + df.format(new Date()) + "'";
            String IDnumber = "'" + room.getIDnumber() + "'";
            String sql = "insert into " + LoginServlet.roomiid +
                    "(IDnumber,SWITCH,TARGET_TEMP,TARGET_SPEED,CURRENT_TEMP,CURRENT_SPEED,DATE,MODE) " +
                    "values(" +
                    IDnumber + "," +
                    1 + "," +
                    room.getTargetTemp() + "," +
                    room.getTargetSpeed() + "," +
                    room.getCurrentTemp() + "," +
                    room.getCurrentSpeed() + "," +
                    Date + "," +
                    room.getMode() + ");";

            DBUtil.executeUpdate(sql, new Object[]{});//д���¼���ݿ⣬����Ƿ�õ���Ӧ
            try {
                DBUtil.connection.close();;
                DBUtil.pstmt.close();
                DBUtil.rs.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }

            int i = 100000;
            while(i > 0) {
                i++;
            }

            String msg = "";
            int swi = -1;

            //power�Լ�ȥ���ݿ��ң�2/1/0����������/������Դ/�رյ�Դ
            sql = "select power from cacpara;";
            int onOff = -1;
            try {
                ResultSet rs = DBUtil.executeQuery(sql, new Object[]{});
                while(rs.next()) {
                    onOff = rs.getInt("power");
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

            if(onOff == 0 || onOff == 1) {//�ж�����յ��Ƿ��ܷ���
                msg = "initError";
            }else if(onOff == 2) {//����յ��ܷ���
                sql = "select * from " + LoginServlet.roomiid + " where DATE = (select max(DATE) from " + LoginServlet.roomiid +");";

//                sql = "select * from room1 where DATE = (select max(DATE) from room1);";

                while (swi != 3 && swi != 4) {//�жϷ���ɹ���ʧ��
                    try {
                        ResultSet rs = DBUtil.executeQuery(sql, new Object[]{});
                        while (rs.next()) {
                            swi = rs.getInt("SWITCH");
                        }
                        System.out.println("SWITCH:" + swi);
                        try {
                            DBUtil.connection.close();
                            ;
                            DBUtil.pstmt.close();
                            DBUtil.rs.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }

            if(swi == 3) {
                msg = "initSuccess";
            }else if(swi == 4) {
                msg = "initError";
            }

            response.getWriter().write(msg);

        } else if(method.equalsIgnoreCase("PowerOff")) {//����رյ�Դ
            room.RoomID = LoginServlet.roomiid;

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String Date = "'" + df.format(new Date()) + "'";
            String IDnumber = "'" + room.getIDnumber() + "'";
            String sql = "insert into " + LoginServlet.roomiid +
                    "(IDnumber,SWITCH,TARGET_TEMP,TARGET_SPEED,CURRENT_TEMP,CURRENT_SPEED,DATE,MODE) " +
                    "values(" +
                    IDnumber + "," +
                    0 + "," +
                    room.getTargetTemp() + "," +
                    room.getTargetSpeed() + "," +
                    room.getCurrentTemp() + "," +
                    room.getCurrentSpeed() + "," +
                    Date + "," +
                    room.getMode() + ");";

            DBUtil.executeUpdate(sql, new Object[]{});//д���¼���ݿ⣬����Ƿ�õ���Ӧ
            try {
                DBUtil.connection.close();;
                DBUtil.pstmt.close();
                DBUtil.rs.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }

            String msg = "";//���۷���ʲô���عرճɹ�

            response.getWriter().write(msg);
        } else if(method.equalsIgnoreCase("SetTemp")){//�������
            subOrNot = false;
            room.RoomID = LoginServlet.roomiid;
            //���û�ȡ��Ŀ���¶ȣ����������¶ȳɹ��󷵻��û�
            String targetTemp = request.getParameter("TargetTemp");
            getServletContext().setAttribute("currentTemp", room.getCurrentTemp());
            getServletContext().setAttribute("targetTemp", targetTemp);
            getServletContext().setAttribute("currentWind", room.getCurrentSpeed());

            int TargetTemp = Integer.parseInt(request.getParameter("TargetTemp"));
            TempChange temp = new TempChange();
            temp.setTargetTemp(TargetTemp);

            room.setTargetTemp(TargetTemp);

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String Date = "'" + df.format(new Date()) + "'";
            String IDnumber = "'" + room.getIDnumber() + "'";
            String sql = "insert into " + LoginServlet.roomiid +
                    "(IDnumber,SWITCH,TARGET_TEMP,TARGET_SPEED,CURRENT_TEMP,CURRENT_SPEED,DATE,MODE) " +
                    "values(" +
                    IDnumber + "," +
                    5 + "," +
                    TargetTemp + "," +
                    room.getTargetSpeed() + "," +
                    room.getCurrentTemp() + "," +
                    room.getCurrentSpeed() + "," +
                    Date + "," +
                    room.getMode() + ");";

            DBUtil.executeUpdate(sql, new Object[]{});//д���¼���ݿ⣬����Ƿ�õ���Ӧ
            try {
                DBUtil.connection.close();;
                DBUtil.pstmt.close();
                DBUtil.rs.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }

            int swi = -1;
//            sql = "select * from room1 where DATE = (select max(DATE) from room1)";
            sql = "select * from " + LoginServlet.roomiid + " where DATE = (select max(DATE) from " + LoginServlet.roomiid +");";
            while (swi != 3 && swi != 4) {//�жϷ���ɹ���ʧ��
                try {
                    ResultSet rs = DBUtil.executeQuery(sql, new Object[]{});
                    while (rs.next()) {
                        swi = rs.getInt("SWITCH");
                    }
                    System.out.println("SWITCH:" + swi);
                    try {
                        DBUtil.connection.close();
                        ;
                        DBUtil.pstmt.close();
                        DBUtil.rs.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            String msg = "";
            if(swi == 3) {//����ɹ�����ǰ�¶ȱ�Ϊ��һ�ε�Ŀ���¶�
                room.setCurrentTemp(TargetTemp);
                subOrNot = true;//�ﵽĿ���¶ȣ�ֹͣ���񣬿�ʼ����
                msg = "setSuccess";
            }else if(swi == 4) {
                msg = "setError";
            }

            //�ﵽĿ���¶ȣ�������ͣ����
            df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date = "'" + df.format(new Date()) + "'";
            IDnumber = "'" + room.getIDnumber() + "'";
            sql = "insert into " + LoginServlet.roomiid +
                    "(IDnumber,SWITCH,TARGET_TEMP,TARGET_SPEED,CURRENT_TEMP,CURRENT_SPEED,DATE,MODE) " +
                    "values(" +
                    IDnumber + "," +
                    2 + "," +
                    TargetTemp + "," +
                    room.getTargetSpeed() + "," +
                    room.getCurrentTemp() + "," +
                    room.getCurrentSpeed() + "," +
                    Date + "," +
                    room.getMode() + ");";

            DBUtil.executeUpdate(sql, new Object[]{});//д���¼���ݿ⣬����Ƿ�õ���Ӧ
            try {
                DBUtil.connection.close();;
                DBUtil.pstmt.close();
                DBUtil.rs.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }

            response.getWriter().write(msg);

        } else if(method.equalsIgnoreCase("SetWind")){
            //���û�ȡ��Ŀ����٣��������÷��ٳɹ��󷵻��û�
            String targetWind = request.getParameter("TargetWind");
            getServletContext().setAttribute("currentWind", room.getCurrentSpeed());
            getServletContext().setAttribute("targetWind", targetWind);
            getServletContext().setAttribute("currentT", room.getCurrentTemp());

            room.RoomID = LoginServlet.roomiid;

            int TargetWind = Integer.parseInt(request.getParameter("TargetWind"));;
            WindChange wind = new WindChange();
            wind.setTargetWind(TargetWind);

            room.setTargetTemp(TargetWind);

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String Date = "'" + df.format(new Date()) + "'";
            String IDnumber = "'" + room.getIDnumber() + "'";
            String sql = "insert into " + LoginServlet.roomiid +
                    "(IDnumber,SWITCH,TARGET_TEMP,TARGET_SPEED,CURRENT_TEMP,CURRENT_SPEED,DATE,MODE) " +
                    "values(" +
                    IDnumber + "," +
                    5 + "," +
                    room.getTargetTemp() + "," +
                    TargetWind + "," +
                    room.getCurrentTemp() + "," +
                    room.getCurrentSpeed() + "," +
                    Date + "," +
                    room.getMode() + ");";

            DBUtil.executeUpdate(sql, new Object[]{});//д���¼���ݿ⣬����Ƿ�õ���Ӧ
            try {
                DBUtil.connection.close();;
                DBUtil.pstmt.close();
                DBUtil.rs.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }

            int swi = -1;
            sql = "select * from " + LoginServlet.roomiid + " where DATE = (select max(DATE) from " + LoginServlet.roomiid +");";
            while (swi != 3 && swi != 4) {//�жϷ���ɹ���ʧ��
                try {
                    ResultSet rs = DBUtil.executeQuery(sql, new Object[]{});
                    while (rs.next()) {
                        swi = rs.getInt("SWITCH");
                    }
                    System.out.println("SWITCH:" + swi);
                    try {
                        DBUtil.connection.close();
                        DBUtil.pstmt.close();
                        DBUtil.rs.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            String msg = "";
            if(swi == 3) {//����ɹ�����ǰ���ٱ�Ϊ��һ�ε�Ŀ�����
                Thread t = new Thread() {//������Ҫ��ôﵽĿ����٣���ͣ
                    public void run() {//������/��һ����Ҫ1min
                        if(TargetWind == 0) {
                            degree = degree + 0.33;
                            cost = degree;
                        }else if(TargetWind == 1) {
                            degree = degree + 0.5;
                            cost = degree;
                        }else if(TargetWind == 2) {
                            degree = degree + 1;
                            cost = degree;
                        }
//                        if(Math.abs(TargetWind - room.getCurrentSpeed()) == 1 || Math.abs(TargetWind - room.getCurrentSpeed()) == 0) {
//                            if(TargetWind == 0) {
//                                degree = degree + 0.33;
//                                cost = cost + 0.33;
//                            }else if(TargetWind == 1) {
//                                degree = degree + 0.5;
//                                cost = cost + 0.5;
//                            }else if(TargetWind == 2) {
//                                degree = degree + 1;
//                                cost = cost + 1;
//                            }
//                        }else if(Math.abs(TargetWind - room.getCurrentSpeed()) == 2) {
//                            if(TargetWind == 0) {
//                                degree = degree + 0.67;
//                                cost = cost + 0.67;
//                            }else if(TargetWind == 1) {
//                                degree = degree + 1;
//                                cost = cost + 1;
//                            }else if(TargetWind == 2) {
//                                degree = degree + 2;
//                                cost = cost + 2;
//                            }
//                        }
                        getServletContext().setAttribute("degree", degree);
                        getServletContext().setAttribute("cost", cost);
                    }
                };
                t.start();
                room.setCurrentSpeed(TargetWind);
                msg = "setSuccess";
            }else if(swi == 4) {
                msg = "setError";
            }

            //������ͣ����
            df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date = "'" + df.format(new Date()) + "'";
            IDnumber = "'" + room.getIDnumber() + "'";
            sql = "insert into " + LoginServlet.roomiid +
                    "(IDnumber,SWITCH,TARGET_TEMP,TARGET_SPEED,CURRENT_TEMP,CURRENT_SPEED,DATE,MODE) " +
                    "values(" +
                    IDnumber + "," +
                    2 + "," +
                    room.getTargetTemp() + "," +
                    TargetWind + "," +
                    room.getCurrentTemp() + "," +
                    room.getCurrentSpeed() + "," +
                    Date + "," +
                    room.getMode() + ");";

            DBUtil.executeUpdate(sql, new Object[]{});//д���¼���ݿ⣬����Ƿ�õ���Ӧ
            try {
                DBUtil.connection.close();;
                DBUtil.pstmt.close();
                DBUtil.rs.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }

            response.getWriter().write(msg);
        } else if(method.equalsIgnoreCase("QueryBill")) {

            Thread t = new Thread() {//��ͣ���룬�Ա�������ʱ��
                public void run() {
                    try {
                        sleep(5 * 1000);
                    }catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();


            //���û�ȡ�ķ����
            String room = request.getParameter("roomID");
            getServletContext().setAttribute("room", room);
            getServletContext().setAttribute("duration", CustomerBillServlet.duration);

            String msg = "success";
            response.getWriter().write(msg);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}