package com.hugo.programmer.ssm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {
	public static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/ssm?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
	public static final String USER = "root";
	public static final String PASSWORD = "root";

	public static void main(String[] args) throws Exception {
		// 1.load mysql driver
		Class.forName(MYSQL_DRIVER);
		// 2.get connection
		Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
		// 3.create statement
		Statement statement = connection.createStatement();
		// 4.execute query
		ResultSet resultSet = statement.executeQuery("select * from tb_user");
		// 5.foreach result
		while (resultSet.next()) {
			System.out.println(resultSet.getString("name") + " age：" + resultSet.getInt("age"));
		}

	}
}
