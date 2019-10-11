package com.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;

public class UserLoginDetailsDao1 {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn;
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lookevents", "root", "Atul@12345");
		return conn;
	}

	public static int insertdetails(UserLoginDetails e) throws ClassNotFoundException, SQLException {

		Connection con = UserLoginDetailsDao1.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into userlogindetails values(?,?,?,?,?)");
		ps.setString(1, e.getFirstName());
		ps.setString(2, e.getLastName());
		ps.setString(3, e.getEmail());
		ps.setString(4, e.getPassword());
		ps.setString(5, e.getConfirm_Password());

		Integer rs = ps.executeUpdate();
		return rs;
	}
}

/*
 * public static List<UserLoginDetails> getAllRecords() throws
 * ClassNotFoundException, SQLException { List<UserLoginDetails> list = new
 * ArrayList<UserLoginDetails>();
 * 
 * Connection con = getConnection(); PreparedStatement ps =
 * con.prepareStatement("select * from userlogindetails "); ResultSet rs =
 * ps.executeQuery(); while (rs.next()) { UserLoginDetails e = new
 * UserLoginDetails(); e.setId(rs.getInt("id"));
 * e.setName(rs.getString("name")); e.setSal(rs.getInt("sal"));
 * e.setEmail(rs.getString("email")); list.add(e); } return list; }
 * 
 * public static Employee getRecordById(int id) throws ClassNotFoundException,
 * SQLException { Employee e = null;
 * 
 * Connection con = getConnection(); PreparedStatement ps =
 * con.prepareStatement("select * from employee where id=?"); ps.setInt(1, id);
 * ResultSet rs = ps.executeQuery(); while (rs.next()) { e = new Employee();
 * e.setId(rs.getInt("id")); e.setName(rs.getString("name"));
 * e.setSal(rs.getInt("sal")); e.setEmail(rs.getString("email")); }
 * 
 * return e; }
 * 
 * public static int update(Employee e) throws ClassNotFoundException,
 * SQLException {
 * 
 * Connection con = getConnection(); PreparedStatement ps =
 * con.prepareStatement("update employee set name=?,sal=?,email=? where id=?");
 * ps.setString(1, e.getName()); ps.setInt(2, e.getSal()); ps.setString(3,
 * e.getEmail()); ps.setInt(4, e.getId()); int status = ps.executeUpdate();
 * return status; }
 * 
 * public static int delete(Employee e) throws ClassNotFoundException,
 * SQLException {
 * 
 * Connection con = getConnection(); PreparedStatement ps =
 * con.prepareStatement("delete from employee where id=?"); ps.setInt(1,
 * e.getId()); int status = ps.executeUpdate();
 * 
 * return status; } }
 */