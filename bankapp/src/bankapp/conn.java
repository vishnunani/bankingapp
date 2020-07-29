package bankapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conn {
	static Connection con;
	static String url;
	public static Connection getConnection() throws ClassNotFoundException {
	String user="root"; String password="root";
	 url="jdbc:mysql://localhost:3306/bankingapp";
	try {
		Class.forName("com.mysql.jdbc.Driver");//Specifying the JDBC Driver
		con = DriverManager.getConnection(url, user, password);//Establishing Database Connection
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return con;
}}
