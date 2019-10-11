package com.Login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserLoginDetailsDao {

	public static Connection connect() throws ClassNotFoundException, SQLException, IOException {
		Connection obj = null;
		Class.forName("com.mysql.jdbc.Driver");
		String dataUrl = "jdbc:mysql://localhost:3306/lookevents";

		return obj = DriverManager.getConnection(dataUrl, "root", "Atul@12345");
	}

	public static int insert(UserLoginDetails ULD)
			throws ClassNotFoundException, SQLException, NumberFormatException, IOException {

		Connection con = connect();

		String s = "insert into userlogindetails values(?,?,?,?,?,default)";
		PreparedStatement ps = con.prepareStatement(s);
		ps.setString(1, ULD.getFirstName());
		ps.setString(2, ULD.getLastName());
		ps.setString(3, ULD.getEmail());
		ps.setString(4, ULD.getPassword());
		ps.setString(5, ULD.getConfirm_Password());
		//ps.setInt(6, ULD.getUserid());
		int i = ps.executeUpdate();
		return i;

	}

	public static int delete(UserLoginDetails ULD)
			throws ClassNotFoundException, SQLException, NumberFormatException, IOException {
		Connection con = connect();

		PreparedStatement ps = con.prepareStatement("delete from userlogindetails where Email=?");
		ps.setString(1, ULD.getEmail());
		int i = ps.executeUpdate();
		return i;
	}

	public static List<UserLoginDetails> display() throws ClassNotFoundException, SQLException, IOException {
		Connection con = connect();
		List<UserLoginDetails> list = new ArrayList<UserLoginDetails>();

		PreparedStatement ps = con.prepareStatement("Select * from userlogindetails");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			UserLoginDetails c = new UserLoginDetails();
			c.setFirstName(rs.getString(1));
			c.setLastName(rs.getString(2));
			c.setEmail(rs.getString(3));
			c.setPassword(rs.getString(4));
			c.setConfirm_Password(rs.getString(5));
			list.add(c);
		}
		ps.close();
		con.close();

		return list;
	}
}
