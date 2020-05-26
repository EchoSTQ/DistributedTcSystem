package com.se17e.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomerFunServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if("toBillView".equalsIgnoreCase(method)){ //��ת���굥ҳ��
			request.getRequestDispatcher("/WEB-INF/view/customer/bill.jsp").forward(request, response);
		} else if("toTempView".equalsIgnoreCase(method)){
			request.getRequestDispatcher("/WEB-INF/view/customer/temp.jsp").forward(request, response);
		} else if("toWindView".equalsIgnoreCase(method)){
			request.getRequestDispatcher("/WEB-INF/view/customer/wind.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
