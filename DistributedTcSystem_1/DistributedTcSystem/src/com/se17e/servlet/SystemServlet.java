package com.se17e.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SystemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if("LoginOut".equals(method)){ //�˳�ϵͳ
			loginOut(request, response);
		} else if("toAdminView".equalsIgnoreCase(method)){ //������Ա����
			request.getRequestDispatcher("/WEB-INF/view/admin/admin.jsp").forward(request, response);
		} else if("toStudentView".equals(method)){ //���û�����
			request.getRequestDispatcher("/WEB-INF/view/student/customer.jsp").forward(request, response);
		} else if("toTeacherView".equals(method)){ //��ǰ̨����
			request.getRequestDispatcher("/WEB-INF/view/teacher/receptionist.jsp").forward(request, response);
		} 
//		else if("toAdminPersonalView".equals(method)){ //��ϵͳ����Աϵͳ���ý���
//			request.getRequestDispatcher("/WEB-INF/view/admin/adminPersonal.jsp").forward(request, response);
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void loginOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�˳�ϵͳʱ���ϵͳ��¼���û�
		request.getSession().removeAttribute("user");
		String contextPath = request.getContextPath();
		//ת������¼����
		response.sendRedirect(contextPath+"/index.jsp");
	}

}
