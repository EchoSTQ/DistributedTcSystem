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
            //创建调度对象和服务对象
            boolean initSche = SchedulingService.init();
            boolean initServed = ServedService.init();
            //调度对象中初始化等待队列和服务队列
            String msg = (initSche == true && initServed == true) ? "initSuccess":"initError";

            //返回初始化消息
            response.getWriter().write(msg);
        } else if(method.equalsIgnoreCase("SetTemp")){
            String targetTemp = request.getParameter("TargetTemp");
            getServletContext().setAttribute("targetTemp", targetTemp);

            int TargetTemp = Integer.parseInt(request.getParameter("TargetTemp"));
            TempChange temp = new TempChange(TargetTemp);

            //如何将获取到的房间号传递到这
            String msg = CustomerService.setTemp(temp, "roomID")? "setSuccess":"setError";
            msg = "setSuccess";


            response.getWriter().write(msg);
        } else if(method.equalsIgnoreCase("SetWind")){
            String targetWind = request.getParameter("TargetWind");
            getServletContext().setAttribute("targetWind", targetWind);
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
