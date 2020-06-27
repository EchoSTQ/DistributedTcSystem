package com.se17e.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


//ͨ�õ����ݲ�������
public class DBUtil {
	
	private static final String URL = "jdbc:mysql://localhost:3306/DTCS?useSSL=false&serverTimezone=GMT%2B8";
	private static final String USER = "root";
	private static final String PWD = "mysql";
	
	public static Connection connection = null;
	public static PreparedStatement pstmt = null;
	public static ResultSet rs = null;
	
	//��ȡ���Ӷ���
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(URL,USER,PWD);
		return connection;
	}
	
	//��ȡpstmt
	public static PreparedStatement createPreparedStatement(String sql, Object[] params) throws ClassNotFoundException, SQLException {
		pstmt = getConnection().prepareStatement(sql);
		
		if(params != null) {
			for(int i = 0; i < params.length; i++) {
				pstmt.setObject(i+1, params[i]);
			}
		}
		return pstmt;
	}
	
	//��ɾ��
	public static int executeUpdate(String sql, Object[] params) {
		
		try {
			pstmt = createPreparedStatement(sql, params);
			
			int count = pstmt.executeUpdate(); 
		
			return count;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return -1;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(connection != null) connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//��
	public static ResultSet executeQuery(String sql, Object[] params){
		
		try {
			pstmt = createPreparedStatement(sql, params);
			rs = pstmt.executeQuery();
			
			return rs;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
}
