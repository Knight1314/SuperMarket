package com.knight.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class DBUtils {
	private static String DRIVER = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/superMarket";
	private static String USER = "root";
	private static String PASS = "root";

	private static Connection connection;

	private static void init() {
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException e) {
			System.out.println("未找到驱动类");
		} catch (SQLException e) {
			System.out.println("无法获取数据库连接");
		}
	}

	public static Connection getConnection() {
		if (connection == null) {
			init();
		}
		return connection;
	}

	@Test
	public void test() {
		System.out.println(getConnection());
	}
}
