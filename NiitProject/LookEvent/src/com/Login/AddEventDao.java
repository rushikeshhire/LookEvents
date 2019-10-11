package com.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AddEventDao {
	public static Connection getConnection(){  
        Connection con=null;  
        try{  
        	Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:Mysql://localhost:3306/lookevents","root","Atul@12345");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
	    public static int save(AddEvent rc){  
	        int status=0;  
	        try{  
	            Connection con=AddEventDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
                        "insert into addevent values (?,?,?,?,?,?,?,?,?)");  
	            //prepared statement is a interface which is used to execute a query and pass parameters at run time
	            ps.setString(1,rc.getEventName());  
	            ps.setString(2,rc.getEventON());
				ps.setString(3,rc.getEventHCN());
	            ps.setString(4,rc.getEmailOrg());  
	            ps.setString(5,rc.getEventcode());  
				ps.setString(6,rc.getNumberOfSeats());
				ps.setString(7,rc.getEventCPS());
				ps.setString(8,rc.getEventAddress());
				ps.setString(9,rc.getEventDate());
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	/*
	 * public static int update(RegisterCust rc){ int status=0; try{ Connection
	 * con=RegisterCustDao.getConnection(); PreparedStatement
	 * ps=con.prepareStatement(
	 * "update logindetails set u_name=?,Password=?,RepeatPassword=?,Email_id=? where Reg_id=?"
	 * ); ps.setString(1,rc.getU_name()); ps.setString(2,rc.getPassword());
	 * ps.setString(3,rc.getRepeatPassword()); ps.setString(4,rc.getEmail_id());
	 * ps.setInt(5,rc.getReg_id());
	 * 
	 * status=ps.executeUpdate();
	 * 
	 * con.close(); }catch(Exception ex){ex.printStackTrace();}
	 * 
	 * return status; }
	 */

	/*
	 * public static int delete(int Reg_id){ int status=0; try{ Connection
	 * con=RegisterCustDao.getConnection(); PreparedStatement
	 * ps=con.prepareStatement("delete from logindetails where =?");
	 * ps.setInt(1,Reg_id); status=ps.executeUpdate();
	 * 
	 * con.close(); }catch(Exception e){e.printStackTrace();}
	 * 
	 * return status; } public static RegisterCust getEmployeeById(int Reg_id){
	 * RegisterCust r=new RegisterCust();
	 * 
	 * try{ Connection con=RegisterCustDao.getConnection(); PreparedStatement
	 * ps=con.prepareStatement("select * from logindetails where Reg_id=?");
	 * ps.setInt(1,Reg_id); ResultSet rs=ps.executeQuery(); if(rs.next()){
	 * r.setReg_id(rs.getInt(1)); r.setU_name(rs.getString(2));
	 * r.setPassword(rs.getString(3)); r.setRepeatPassword(rs.getString(4));
	 * r.setEmail_id(rs.getString(5)); } con.close(); }catch(Exception
	 * ex){ex.printStackTrace();}
	 * 
	 * return r; }
	 */  
	    public static List<AddEvent> getAllEmployees(){  
	        List<AddEvent> list=new ArrayList<AddEvent>();  
	          
	        try{  
	            Connection con=AddEventDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from addevent");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	    	    	AddEvent r=new AddEvent();  
	    	    	r.setEventName(rs.getString(1));  
	                r.setEventON(rs.getString(2));  
	                r.setEventHCN(rs.getString(3));  
	                r.setEmailOrg(rs.getString(4));
	                r.setEventcode(rs.getString(5));
					r.setNumberOfSeats(rs.getString(6));
					r.setEventCPS(rs.getString(7));
					r.setEventAddress(rs.getString(8));
					r.setEventDate(rs.getString(9));
	                list.add(r);  
	            }  
	            
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    } 
}
