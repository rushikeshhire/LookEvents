package com.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLoginDao {
	public static boolean validate(String Email, String Password) {

		boolean status = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/lookevents", "root",
					"Atul@12345");

			PreparedStatement ps = con1.prepareStatement("select * from userlogindetails where Email=? and Password=?");
			ps.setString(1, Email);
			ps.setString(2, Password);

			ResultSet rs = ps.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
}
