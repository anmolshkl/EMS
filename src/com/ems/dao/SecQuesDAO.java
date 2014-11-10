package com.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ems.db.DBConnection;

public class SecQuesDAO {
	public String getQuestion(int empId) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String secQuest=null;
		String sqlQuery="SELECT \"SecurityQuestion\" FROM \"Login_Dets\" WHERE \"EmployeeID\"=?";
		try{
			DBConnection db=new DBConnection();
			conn=db.getConnection();
			if(null!=conn){
				pstmt=conn.prepareStatement(sqlQuery);
				pstmt.setInt(1, empId);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					secQuest=rs.getString(1);
				}
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
		return secQuest;
	}
	public boolean checkAnswer(int empId,String answ) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		boolean ret=false;
		String sqlQuery="SELECT \"SecurityAnswer\" FROM \"Login_Dets\" WHERE \"EmployeeID\" =? AND \"SecurityAnswer\"=?";
		try{
			DBConnection db=new DBConnection();
			conn=db.getConnection();
			if(null!=conn){
				pstmt=conn.prepareStatement(sqlQuery);
				pstmt.setInt(1, empId);
				pstmt.setString(2, answ);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					ret=true;
				}
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
		return ret;
	}
}
