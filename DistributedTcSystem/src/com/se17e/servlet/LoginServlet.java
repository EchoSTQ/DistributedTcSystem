package com.se17e.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.se17e.bean.User;
import com.se17e.service.LoginService;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LoginService service = new LoginService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		login(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//��ȡ�û���������֤��
		String IDnumber = request.getParameter("IDnumber");
		//��ȡ�û����������
		String pwd = request.getParameter("password");
		//��ȡ�û��������֤��
		//String vcode = request.getParameter("vcode");
		//��ȡ��¼����
		int type = Integer.parseInt(request.getParameter("type"));
		
		//������Ϣ
		String msg = "";
		
		//��ȡsession�е���֤��
//		String sVcode = (String) request.getSession().getAttribute("vcode");
//		if(!sVcode.equalsIgnoreCase(vcode)){//���ж���֤���Ƿ���ȷ
//			msg = "vcodeError";
//		} else{	//�ж��û����������Ƿ���ȷ
		
		//��װ�˻�������
		User user = new User();
		user.setIDnumber(IDnumber);
		user.setPassword(pwd);
		user.setType(type);
		
		//��ѯ����Ա�Ƿ���ڣ���������������Աҳ��
		if(type == 3) {
			User loginUser = service.checkAdmin(user);
			if(loginUser == null) {
				msg = "loginError";
			}else {	//��ȷ
				msg = "admin";
				//�����û������浽session��
				request.getSession().setAttribute("user", loginUser);
			}
		}else if(type == 2) {
			User loginUser = service.checkCustomer(user);
			if(loginUser == null) {
				msg = "loginError";
			}else {	//��ȷ
				msg = "customer";
				//�����û������浽session��
				request.getSession().setAttribute("user", loginUser);
			}
		}else {
			User loginUser = service.checkReceptionist(user);
			if(loginUser == null) {
				msg = "loginError";
			}else {	//��ȷ
				msg = "receptionlist";
				//�����û������浽session��
				request.getSession().setAttribute("user", loginUser);
			}
		}
		//���ص�¼��Ϣ
		response.getWriter().write(msg);
//		}
	}

}
