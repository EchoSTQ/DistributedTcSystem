package com.se17e.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.se17e.bean.TempChange;
import com.se17e.bean.WindChange;
import com.se17e.service.CustomerService;

public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if(method.equalsIgnoreCase("PowerOn")) {
            String msg = "initSuccess";
            //���س�ʼ����Ϣ
            response.getWriter().write(msg);
        } else if(method.equalsIgnoreCase("SetTemp")){
            //����webȫ�������ģ���temp.jsp����Ŀ���¶�
            String targetTemp = request.getParameter("TargetTemp");
            getServletContext().setAttribute("targetTemp", targetTemp);

            //����Ŀ���¶�
            int TargetTemp = Integer.parseInt(request.getParameter("TargetTemp"));
            TempChange temp = new TempChange();
            temp.setTargetTemp(TargetTemp);
            String msg = CustomerService.setTemp(temp)? "setSuccess":"setError";

            response.getWriter().write(msg);
        } else if(method.equalsIgnoreCase("SetWind")){
            //����webȫ�������ģ���wind.jsp����Ŀ�����
            String targetWind = request.getParameter("TargetWind");
            getServletContext().setAttribute("targetWind", targetWind);

            //����Ŀ�����
            int TargetWind = Integer.parseInt(request.getParameter("TargetWind"));
            WindChange wind = new WindChange();
            wind.setTargetWind(TargetWind);
            String msg = CustomerService.setWind(wind)? "setSuccess":"setError";
//            msg = "setSuccess";
            response.getWriter().write(msg);
        } else if(method.equalsIgnoreCase("QueryBill")) {
            //����webȫ�������ģ���bill.jsp�������
            String room = request.getParameter("roomID");
            getServletContext().setAttribute("room", room);

            String msg = "success";
            response.getWriter().write(msg);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
