package com.ems.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.ems.bean.SalaryDetsBean;
import com.ems.db.DBConnection;

public class SalaryDetsDAO {
	public SalaryDetsBean getSalaryDetails(int empId) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sqlQuery=null;
		SalaryDetsBean salary= null;
		try {
			DBConnection db=new DBConnection();
			conn=db.getConnection();
			sqlQuery= "SELECT " 
			    		+ "\"EmployeeID\"," 
			    		+ "\"Designation\"," 
			    		+ "\"Salary\" "
			    		+ "FROM " + "\"Sal_Dets\" " 
			    		+ "WHERE \"EmployeeID\"=?";
			if(conn != null) {
	    		pstmt=conn.prepareStatement(sqlQuery);
				pstmt.setInt(1,empId);
				rs=pstmt.executeQuery();
	    		if(rs.next()) {
	    			salary=new SalaryDetsBean();
	    			salary.setEmpId(rs.getInt(1));
	    			salary.setDesig(rs.getString(2));
	    			salary.setSalary(rs.getInt(3));
	    		}
			}
	    	
	    }
	    catch(Exception ex) {
	       ex.printStackTrace();
	       if(null!=conn){        		
	    	   try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   	}
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
    return salary;
}
	public void setSalaryDetails(SalaryDetsBean salary) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sqlQuery=null;
		
	
        try {
        	DBConnection db=new DBConnection();
			conn=db.getConnection();
			
			sqlQuery="INSERT INTO \"Sal_Dets\" " +
					"(\"EmployeeID\"," +
					"\"Designation\"," +
					"\"Salary\")" +
					"VALUES(?,?,?)";
			if(conn != null) {
        		pstmt=conn.prepareStatement(sqlQuery);
        		pstmt.setInt(1,salary.getEmpId());
        		pstmt.setString(2,salary.getDesig());
        		pstmt.setInt(3,salary.getSalary());
        		pstmt.executeUpdate();
			}
        }
        catch(Exception ex) {
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
	}
}
