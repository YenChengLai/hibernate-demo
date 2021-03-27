package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pwd = "hbstudent";

		try (Connection conn = DriverManager.getConnection(jdbcUrl, user, pwd);) {
			System.out.println("Connecting to mySQL database");
			System.out.println("Connected successful");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
