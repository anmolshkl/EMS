package com.ems.dao;

import java.sql.*;

import com.ems.bean.LoginBean;
import com.ems.bean.ProfileBean;
import com.ems.db.DBConnection;

public class ProfileDAO {

	public ProfileBean getUser(int empId,boolean confStat) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sqlQuery=null;
		ProfileBean profile=new ProfileBean();
        try {
        	DBConnection db=new DBConnection();
			con=db.getConnection();
        	sqlQuery="Select " +
        			"\"Addr\"," +
        			"\"FN\"," +
        			"\"MN\"," +
        			"\"LN\"," +
        			"\"Dept\"," +
        			"\"MobNum\"," +
        			"\"Qualf\"," +
        			"\"Desig\"," +
        			"\"DOB\"," +
        			"\"EmployeeID\"," +
        			"\"DOJoining\"," +
        			"\"DOCreation\"," +
        			"\"ConfStat\"," +
        			"\"WorkflowID\"," +
        			"\"DepName\"," +
        			"\"DepRel\"," +
        			"\"Contact\"," +
        			"\"Email\"," +
        			"\"BloodGroup\"," +
        			"\"PanNum\"," +
        			"\"LibNum\" " +
        			" from \"Primary_Dets\" " +
        			"where" +
        			" \"EmployeeID\"=? AND \"ConfStat\"=?";
        	if(con != null) {
        		pstmt=con.prepareStatement(sqlQuery);
				pstmt.setInt(1,empId);
				pstmt.setBoolean(2,confStat);
        		rs=pstmt.executeQuery();
        		while(rs.next()) {
	        		profile.setAddr(rs.getString(1));
	        		profile.setFn(rs.getString(2));
	        		profile.setMn(rs.getString(3));
	        		profile.setLn(rs.getString(4));
	        		profile.setDept(rs.getString(5));
	        		profile.setMob(rs.getLong(6));
	        		profile.setQualf(rs.getString(7));
	        		profile.setDesig(rs.getString(8));
	        		profile.setDob(rs.getDate(9));
	        		profile.setEmpId(rs.getInt(10));
	        		profile.setDoj(rs.getDate(11));
	        		profile.setDoc(rs.getDate(12));
	        		profile.setConfStat(rs.getBoolean(13));
	        		profile.setWfId(rs.getInt(14));
	        		profile.setDepName(rs.getString(15));
	        		profile.setDepRel(rs.getString(16));
	        		profile.setContact(rs.getLong(17));
	        		profile.setEmail(rs.getString(18));
	        		profile.setBloodGroup(rs.getString(19));
	        		profile.setPanNum(rs.getInt(20));
	        		profile.setLibNum(rs.getInt(21));
	        	}
        		if(rs.getRow() == 0) {
        			profile=null;
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
        return profile;
	}
	
	
	public ProfileBean getUser(int wfId) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sqlQuery=null;
		ProfileBean profile=new ProfileBean();
        try {
        	DBConnection db=new DBConnection();
			con=db.getConnection();
        	sqlQuery="Select " +
        			"\"Addr\"," +
        			"\"FN\"," +
        			"\"MN\"," +
        			"\"LN\"," +
        			"\"Dept\"," +
        			"\"MobNum\"," +
        			"\"Qualf\"," +
        			"\"Desig\"," +
        			"\"DOB\"," +
        			"\"EmployeeID\"," +
        			"\"DOJoining\"," +
        			"\"DOCreation\"," +
        			"\"ConfStat\"," +
        			"\"WorkflowID\"," +
        			"\"DepName\"," +
        			"\"DepRel\"," +
        			"\"Contact\"," +
        			"\"Email\"," +
        			"\"BloodGroup\"," +
        			"\"PanNum\"," +
        			"\"LibNum\" " +
        			" from \"Primary_Dets\" " +
        			"where" +
        			" \"WorkflowID\"=?";
        	if(con != null) {
        		pstmt=con.prepareStatement(sqlQuery);
				pstmt.setInt(1,wfId);
        		rs=pstmt.executeQuery();
        		while(rs.next()) {
	        		profile.setAddr(rs.getString(1));
	        		profile.setFn(rs.getString(2));
	        		profile.setMn(rs.getString(3));
	        		profile.setLn(rs.getString(4));
	        		profile.setDept(rs.getString(5));
	        		profile.setMob(rs.getLong(6));
	        		profile.setQualf(rs.getString(7));
	        		profile.setDesig(rs.getString(8));
	        		profile.setDob(rs.getDate(9));
	        		profile.setEmpId(rs.getInt(10));
	        		profile.setDoj(rs.getDate(11));
	        		profile.setDoc(rs.getDate(12));
	        		profile.setConfStat(rs.getBoolean(13));
	        		profile.setWfId(rs.getInt(14));
	        		profile.setDepName(rs.getString(15));
	        		profile.setDepRel(rs.getString(16));
	        		profile.setContact(rs.getLong(17));
	        		profile.setEmail(rs.getString(18));
	        		profile.setBloodGroup(rs.getString(19));
	        		profile.setPanNum(rs.getInt(20));
	        		profile.setLibNum(rs.getInt(21));
	        	}
        		if(rs.getRow() == 0) {
        			profile=null;
        			System.out.println("inside ProfileDao rows="+rs.getRow());
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
        return profile;
	}
	
	
	public void setUser(ProfileBean profile) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sqlQuery=null;
        try {
        	DBConnection db=new DBConnection();
			con=db.getConnection();
        	sqlQuery="INSERT INTO \"Primary_Dets\" " +
        			"(\"Addr\"," +
        			"\"FN\"," +
        			"\"MN\"," +
        			"\"LN\"," +
        			"\"Dept\"," +
        			"\"MobNum\"," +
        			"\"Qualf\"," +
        			"\"Desig\"," +
        			"\"DOB\"," +
        			"\"EmployeeID\","+
        			"\"DOJoining\"," +
        			"\"DOCreation\"," +
        			"\"ConfStat\"," +
        			"\"WorkflowID\"," +
        			"\"DepName\"," +
        			"\"DepRel\"," +
        			"\"Contact\"," +
        			"\"Email\"," +
        			"\"BloodGroup\"," +
        			"\"PanNum\"," +
        			"\"LibNum\")" +
        		    " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        	if(con != null) {
        		pstmt=con.prepareStatement(sqlQuery);
        		pstmt.setString(1,profile.getAddr());
        		pstmt.setString(2,profile.getFn());
        		pstmt.setString(3,profile.getMn());
        		pstmt.setString(4,profile.getLn());
        		pstmt.setString(5,profile.getDept());
        		pstmt.setLong(6,profile.getMob());
				pstmt.setString(7,profile.getQualf());
				pstmt.setString(8,profile.getDesig());
				pstmt.setDate(9,profile.getDob());
				pstmt.setInt(10,profile.getEmpId());
				pstmt.setDate(11,profile.getDoj());
				pstmt.setDate(12,profile.getDoc());	
				pstmt.setBoolean(13,profile.isConfStat());
				pstmt.setInt(14,profile.getWfId());
				pstmt.setString(15,profile.getDepName());
        		pstmt.setString(16,profile.getDepRel());
        		pstmt.setLong(17,profile.getContact());
        		pstmt.setString(18,profile.getEmail());
        		pstmt.setString(19,profile.getBloodGroup());
        		pstmt.setInt(20,profile.getPanNum());
                pstmt.setInt(21,profile.getLibNum()); 
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
	
	
	public void updateProfile(int wfId,boolean stat) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sqlQuery=null;
		 try {
	        	DBConnection db=new DBConnection();
				con=db.getConnection();
				if(stat == true) {
					sqlQuery="UPDATE \"Primary_Dets\" SET \"ConfStat\"=? WHERE \"WorkflowID\"=?";
					if(con != null) {
		        		pstmt=con.prepareStatement(sqlQuery);
						pstmt.setBoolean(1,stat);
						pstmt.setInt(2,wfId);
						pstmt.executeUpdate();
					}
				}
				else {
					sqlQuery="DELETE FROM \"Primary_Dets\" WHERE \"WorkflowID\"=?";
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