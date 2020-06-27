package com.se17e.servlet;

/**
 * Created by WenJiachen on 2020/6/26.
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import com.se17e.bean.CacPara;
//import com.se17e.service.SchedulingService;
//import com.se17e.service.ServedService;

import com.se17e.service.List_CheckService;

import com.se17e.bean.Report;
//import com.se17e.bean.User;

import com.se17e.bean.globalVariables;

public class CheckServelet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //	QueryReport(request, response);
        //获取时间字符串
        //	String date = request.getParameter("date"); //"2020.1.1"

        //获取登录类型
        //	int type = Integer.parseInt(request.getParameter("type"));

        //	String msg =QueryReport(date,type);


        String msgs = QueryReport(request,response);
        //String date = request.getParameter("date");
        response.getWriter().write(msgs);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public String QueryReport(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String date = request.getParameter("date");
        int type = Integer.parseInt(request.getParameter("type"));
        //返回消息
        String msg = "";
        List_CheckService query=new List_CheckService();
        Report[] ret=query.Get_daily_imformation(date,type);

        globalVariables G=new globalVariables();
        int roomNum=G.roomNum;

        //*作为一条数据的开头,每条数据各个值以逗号隔开，便于生成表格
        String numTostring;

        for(int i=0;i<roomNum;i++) {
            msg+='*';

            numTostring=String.valueOf(ret[i].getSwitchTimes());
            msg=msg+numTostring+",";

            numTostring=String.valueOf(ret[i].getServiceTime());
            msg=msg+numTostring+"mins,";

            numTostring=String.valueOf(ret[i].getTotalFee());
            msg=msg+numTostring+",";

            numTostring=String.valueOf(ret[i].getTempChangeTimes());
            msg=msg+numTostring+",";

            numTostring=String.valueOf(ret[i].getSpeedChangeTimes());
            msg=msg+numTostring+",";

            numTostring=String.valueOf(ret[i].getScheduleTimes());
            msg=msg+numTostring+",";
            //msg=msg+numTostring;
            numTostring=String.valueOf(ret[i].getCheckNum()); //end
            msg+=numTostring;
        }

        //	System.out.print(msg);

        //	response.getWriter().write(msg);


        return msg;
    }
}