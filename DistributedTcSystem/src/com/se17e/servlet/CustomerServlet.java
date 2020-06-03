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
            //返回初始化消息
            response.getWriter().write(msg);
        } else if(method.equalsIgnoreCase("SetTemp")){
            //设置web全局上下文，与temp.jsp共享目标温度
            String targetTemp = request.getParameter("TargetTemp");
            getServletContext().setAttribute("targetTemp", targetTemp);

            //设置目标温度
            int TargetTemp = Integer.parseInt(request.getParameter("TargetTemp"));
            TempChange temp = new TempChange();
            temp.setTargetTemp(TargetTemp);
            String msg = CustomerService.setTemp(temp)? "setSuccess":"setError";

            response.getWriter().write(msg);
        } else if(method.equalsIgnoreCase("SetWind")){
            //设置web全局上下文，与wind.jsp共享目标风速
            String targetWind = request.getParameter("TargetWind");
            getServletContext().setAttribute("targetWind", targetWind);

            //设置目标风速
            int TargetWind = Integer.parseInt(request.getParameter("TargetWind"));
            WindChange wind = new WindChange();
            wind.setTargetWind(TargetWind);
            String msg = CustomerService.setWind(wind)? "setSuccess":"setError";
//            msg = "setSuccess";
            response.getWriter().write(msg);
        } else if(method.equalsIgnoreCase("QueryBill")) {
            //设置web全局上下文，与bill.jsp共享房间号
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
