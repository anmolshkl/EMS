package com.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ems.bean.LoginBean;
import com.ems.db.DBConnection;

public class LoginDAO {
	
	public boolean checkEmployeeId(int empId) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String accessLevel=null;
		String sqlQuery="Select \"AccessLevel\" from \"Login_Dets\" where \"EmployeeID\"=?";
		try{
			DBConnection db=new DBConnection();
			conn=db.getConnection();
			if(null!=conn){
				pstmt=conn.prepareStatement(sqlQuery);
				pstmt.setInt(1,empId);
				rs=pstmt.executeQuery();
				if(rs.next()){
					accessLevel=rs.getInt(1)+"";
				}
				System.out.println("accessLevel="+accessLevel);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
        	try {
        	if(null!=conn){        		
				conn.commit();				
        		conn.close();
        	}
        	if(null!=pstmt){  
        		pstmt.close();
        	}
        	if(null!=rs){ 		
        		rs.close();
        	}
        	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		if(accessLevel == null) {
			return false;
		}
		else {
			return true;
		}
	}
	public String checkIfValidUser(int userName, String password) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String accessLevel=null;
		String sqlQuery="Select \"AccessLevel\" from \"Login_Dets\" where \"EmployeeID\"=? and \"Password\"=?";
		try{
			DBConnection db=new DBConnection();
			conn=db.getConnection();
			if(null!=conn){
				pstmt=conn.prepareStatement(sqlQuery);
				pstmt.setInt(1, userName);
				pstmt.setString(2, password);
				rs=pstmt.executeQuery();
				while(rs.next()){
					accessLevel=rs.getString(1);
				}
				System.out.println("accessLevel="+accessLevel);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
        	try {
        	if(null!=conn){        		
				conn.commit();				
        		conn.close();
        	}
        	if(null!=pstmt){  
        		pstmt.close();
        	}
        	if(null!=rs){ 		
        		rs.close();
        	}
        	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		return accessLevel;
	}
	public void setLoginDets(LoginBean bean) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sqlQuery="INSERT INTO" +
				" \"Login_Dets\" " +
				"(\"EmployeeID\" ," +
				" \"Password\"," +
				"\"SecurityQuestion\"," +
				"\"SecurityAnswer\"," +
				"\"AccessLevel\")" +
				"  values(?,?,?,?,?)";
		try{
			DBConnection db=new DBConnection();
			conn=db.getConnection();
			if(null!=conn){
				System.out.println("Inside LoginDAO setDetails="+bean.getEmpId());
				pstmt=conn.prepareStatement(sqlQuery);
		        pstmt.setInt(1,bean.getEmpId());
		        pstmt.setString(2,"employee");
		        pstmt.setString(3,"none");
		        pstmt.setString(4,"none");
		        pstmt.setInt(5,Integer.parseInt(bean.getAccessLevel()));
				System.out.println("Inside LoginDAO setDetails="+Integer.parseInt(bean.getAccessLevel()));
		        pstmt.executeUpdate();
			}
			
		}
		    	catch(Exception ex){
					ex.printStackTrace();
				}
				finally{
		        	try {
		        	if(null!=conn){        		
						conn.commit();				
		        		conn.close();
		        	}
		        	if(null!=pstmt){  
		        		pstmt.close();
		        	}
		        	} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		        
		        
	}
	public LoginBean getLoginDets(int empId) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		LoginBean bean=new LoginBean();
		String sqlQuery="SELECT * FROM \"Login_Dets\"WHERE \"EmployeeID\"=?";
		try{
			DBConnection db=new DBConnection();
			conn=db.getConnection();
			if(null!=conn){
				pstmt=conn.prepareStatement(sqlQuery);
		        pstmt.setInt(1,empId);
		        rs=pstmt.executeQuery();
			}
			if(rs.next()) {
				bean.setAccessLevel(rs.getInt(6)+"");
				bean.setEmpId(rs.getInt(2));
				bean.setSecQues(rs.getString(4));
			}
			
		}
		    	catch(Exception ex){
					ex.printStackTrace();
				}
				finally{
		        	try {
		        	if(null!=conn){        		
						conn.commit();				
		        		conn.close();
		        	}
		        	if(null!=pstmt){  
		        		pstmt.close();
		        	}
		        	} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		        
		        return bean;
	}
	public void updateLoginDets(LoginBean bean,String answer) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sqlQuery="UPDATE" +
				" \"Login_Dets\" " +
				"SET \"SecurityQuestion\"=?," +
				"\"SecurityAnswer\"=?" +
				" WHERE \"EmployeeID\"=?";
		try{
			DBConnection db=new DBConnection();
			conn=db.getConnection();
			if(null!=conn){
				pstmt=conn.prepareStatement(sqlQuery);
		        pstmt.setString(1,bean.getSecQues());
		        pstmt.setString(2,answer);
		        pstmt.setInt(3,bean.getEmpId());
		        pstmt.executeUpdate();
			}
			
		}
		    	catch(Exception ex){
					ex.printStackTrace();
				}
				finally{
		        	try {
		        	if(null!=conn){        		
						conn.commit();				
		        		conn.close();
		        	}
		        	if(null!=pstmt){  
		        		pstmt.close();
		        	}
		        	} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		        
		        
	}
	
}
