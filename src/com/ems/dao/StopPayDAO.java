package com.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.ems.bean.StopPayBean;
import com.ems.db.DBConnection;

public class StopPayDAO {
	public StopPayBean getDetails(int empId){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sqlQuery=null;
		StopPayBean bean=null;
        try {
        	DBConnection db=new DBConnection();
			con=db.getConnection();
        	sqlQuery="Select * FROM \"Blckd_Pay\" where \"EmployeeID\"=?";
        	if(con != null) {
        		pstmt=con.prepareStatement(sqlQuery);
				pstmt.setInt(1,empId);
				rs=pstmt.executeQuery();
        		while(rs.next()) {
        			bean= new StopPayBean();
	        		bean.setEmpId(rs.getInt(2));
	        		bean.setFromDate(rs.getDate(3));
	        		bean.setToDate(rs.getDate(4));
	        		bean.setReason(rs.getString(5));
	        		bean.setWfId(rs.getInt(6));
	        		bean.setConfStat(rs.getBoolean(7));
        		}
        	}
        }
        catch(Exception ex) {
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
         	if(null!=rs){ 		
         		rs.close();
         	}
         	} catch (SQLException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
         }
         return bean;
	}
	public void setDetails(StopPayBean bean){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sqlQuery=null;
		
        try {
        	DBConnection db=new DBConnection();
			con=db.getConnection();
        	sqlQuery="INSERT into " +
        			"\"Blckd_Pay\"  " +
        			"(\"EmployeeID\"," +
        			"\"FromDate\"," +
        			"\"ToDate\"," +
        			"\"Reason\"," +
        			"\"WorkflowID\"," +
        			"\"ConfStat\") " +
        			"values(?,?,?,?,?,?)"; 
        			
        			if(con != null) {
                		pstmt=con.prepareStatement(sqlQuery);
                		pstmt.setInt(1,bean.getEmpId());
                		pstmt.setDate(2,bean.getFromDate());
                		pstmt.setDate(3,bean.getToDate());
                		pstmt.setString(4,bean.getReason());
                		pstmt.setInt(5,bean.getWfId());
                		pstmt.setBoolean(6,bean.isConfStat());
                		pstmt.executeUpdate();
        			}
        }
        catch(Exception ex) {
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
 	}
	public StopPayBean getDetsByWfId(int wfId){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sqlQuery=null;
		StopPayBean bean=null;
        try {
        	DBConnection db=new DBConnection();
			con=db.getConnection();
        	sqlQuery="Select * FROM \"Blckd_Pay\" where \"WorkflowID\"=?";
        	if(con != null) {
        		pstmt=con.prepareStatement(sqlQuery);
				pstmt.setInt(1,wfId);
				rs=pstmt.executeQuery();
        		while(rs.next()) {
        			bean= new StopPayBean();
	        		bean.setEmpId(rs.getInt(2));
	        		bean.setFromDate(rs.getDate(3));
	        		bean.setToDate(rs.getDate(4));
	        		bean.setReason(rs.getString(5));
	        		bean.setWfId(rs.getInt(6));
	        		bean.setConfStat(rs.getBoolean(7));
        		}
        	}
        }
        catch(Exception ex) {
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
         	if(null!=rs){ 		
         		rs.close();
         	}
         	} catch (SQLException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
         }
         return bean;
	}
	public void updateDetails(int wfId,boolean stat) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sqlQuery=null;
		 try {
	        	DBConnection db=new DBConnection();
				con=db.getConnection();
				if(stat == true) {
					sqlQuery="UPDATE \"Blckd_Pay\" SET \"ConfStat\"=? WHERE \"WorkflowID\"=?";
					if(con != null) {
		        		pstmt=con.prepareStatement(sqlQuery);
						pstmt.setBoolean(1,stat);
						pstmt.setInt(2,wfId);
						pstmt.executeUpdate();
					}
				}
				else {
					sqlQuery="DELETE FROM \"Blckd_Pay\" WHERE \"WorkflowID\"=?";
					if(con != null) {
						pstmt=con.prepareStatement(sqlQuery);
						pstmt.setInt(1,wfId);
						pstmt.executeUpdate();
					}
				}
		 }
		 catch(Exception ex) {
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
	}
}
 	
        