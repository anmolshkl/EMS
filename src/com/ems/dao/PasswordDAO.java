package com.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ems.db.DBConnection;

public class PasswordDAO {
	public boolean updatePassword(int empId,String newPass,String oldPass)  {
		Connection con=null;
		int rows=0;
		boolean ret=false;
		PreparedStatement pstmt=null;
		System.out.println("empId="+empId);
		System.out.println("newPass="+newPass);
		String sqlQuery="UPDATE " +
						"\"Login_Dets\" " +
						"SET \"Password\" = ? " +
						"WHERE \"EmployeeID\"=? AND \"Password\"=?" ;
	
		try{
			DBConnection db=new DBConnection();
			con=db.getConnection();
			if(null!=con){
				pstmt=con.prepareStatement(sqlQuery);
				pstmt.setString(1,newPass);
				pstmt.setInt(2,empId);
				pstmt.setString(3,oldPass);
				rows=pstmt.executeUpdate();
				if(rows!=0) {
					ret=true;
				}
				else {
					ret=false;
				}
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
        	try {
        	if(null!=con){        		
				con.commit();				
        		con.close();
        	}
        	if(null!=pstmt){  
        		pstmt.close();
        	}
        	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		return ret;
		
	}
	public boolean updatePassword(int empId,String newPass)  {
		Connection con=null;
		int rows=0;
		boolean ret=false;
		PreparedStatement pstmt=null;
		System.out.println("empId="+empId);
		System.out.println("newPass="+newPass);
		String sqlQuery="UPDATE " +
						"\"Login_Dets\" " +
						"SET \"Password\" = ? " +
						"WHERE \"EmployeeID\"=?";
		System.out.println(sqlQuery);
		try{
			DBConnection db=new DBConnection();
			con=db.getConnection();
			if(null!=con){
				pstmt=con.prepareStatement(sqlQuery);
				pstmt.setString(1,newPass);
				pstmt.setInt(2,empId);
				rows=pstmt.executeUpdate();
				System.out.println(rows);
				if(rows!=0) {
					ret=true;
				}
				else {
					ret=false;
				}
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
        	try {
        	if(null!=con){        		
				con.commit();				
        		con.close();
        	}
        	if(null!=pstmt){  
        		pstmt.close();
        	}
        	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		return ret;
		
	}

}
