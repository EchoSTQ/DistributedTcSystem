package com.se17e.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomerViewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if(method.equalsIgnoreCase("toPowerOnView")) {//�յ�����
            request.getRequestDispatcher("/WEB-INF/view/customer/powerOn.jsp").forward(request, response);
        } else if(method.equalsIgnoreCase("toSetTempView")){////�յ��¶���ҳ��
            request.getRequestDispatcher("/WEB-INF/view/customer/setTemp.jsp").forward(request, response);
        } else if(method.equalsIgnoreCase("toSetWindView")) {//�յ�������ҳ��
            request.getRequestDispatcher("/WEB-INF/view/customer/setWind.jsp").forward(request, response);
        } else if(method.equalsIgnoreCase("toQueryBillView")){//��ѯ�굥��ҳ��
            getServletContext().setAttribute("loginRoomID", LoginServlet.roomiid);
            request.getRequestDispatcher("/WEB-INF/view/customer/queryBill.jsp").forward(request, response);
        } else if(method.equalsIgnoreCase("toBillView")){//�굥ҳ��
            request.getRequestDispatcher("/WEB-INF/view/customer/bill.jsp").forward(request, response);
        } else if(method.equalsIgnoreCase("toTempView")){//�¶�ҳ��
            request.getRequestDispatcher("/WEB-INF/view/customer/temp.jsp").forward(request, response);
        } else if(method.equalsIgnoreCase("toWindView")){//����ҳ��
            request.getRequestDispatcher("/WEB-INF/view/customer/wind.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}