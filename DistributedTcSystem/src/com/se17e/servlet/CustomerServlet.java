package com.se17e.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.se17e.bean.TempChange;
import com.se17e.service.SchedulingService;
import com.se17e.service.ServedService;
import com.se17e.service.CustomerService;

public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if(method.equalsIgnoreCase("PowerOn")) {
            //�������ȶ���ͷ������
            boolean initSche = SchedulingService.init();
            boolean initServed = ServedService.init();
            //���ȶ����г�ʼ���ȴ����кͷ������
            String msg = (initSche == true && initServed == true) ? "initSuccess":"initError";

            //���س�ʼ����Ϣ
            response.getWriter().write(msg);
        } else if(method.equalsIgnoreCase("SetTemp")){
            int TargetTemp = Integer.parseInt(request.getParameter("TargetTemp"));
            TempChange temp = new TempChange(TargetTemp);

            //��ν���ȡ���ķ���Ŵ��ݵ���
            String msg = CustomerService.setTemp(temp, "roomID")? "setSuccess":"setError";

            msg = "setSuccess";
            response.getWriter().write(msg);
        } else if(method.equalsIgnoreCase("SetWind")){
            String msg = "setSuccess";
            response.getWriter().write(msg);
        } else if(method.equalsIgnoreCase("QueryBill")) {
            String msg = "success";
            String room = request.getParameter("roomID");
            getServletContext().setAttribute("room", room);
            response.getWriter().write(msg);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
