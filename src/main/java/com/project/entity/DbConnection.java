package com.project.entity;

import java.sql.*;

public class DbConnection {
	/*
	public static void main(String[] args) {
		System.out.println(new DbConnection().getConnection());
	}
	*/
	public Connection getConnection(){
		Connection cn=null;
			try {
				//Class.forName("com.mysql.cj.jdbc.Driver");
				cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydemo","root","1234");
				cn.setAutoCommit(true);
				System.out.println("Connection 成功");
			} catch (SQLException e) {
				System.out.println("SQL Error " + e.getMessage());
				e.printStackTrace();
			}
			
		return cn;
	}

}
