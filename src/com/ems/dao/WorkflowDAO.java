package com.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.ems.bean.WorkflowBean;
import com.ems.db.DBConnection;

public class WorkflowDAO {
	public void setWorkflow(WorkflowBean wfbean ) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sqlQuery=null;
		 try {
	        	DBConnection db=new DBConnection();
				conn=db.getConnection();
				sqlQuery="INSERT INTO \"Workflow\" " +
				"(\"Reason\"," +
				"\"RequestedDate\"," +
				"\"Status\"," +
				"\"RequestedBy\")" +
				" VALUES(?,?,?,?)";
				if(conn != null) {
		    		pstmt=conn.prepareStatement(sqlQuery);
		    		pstmt.setString(1,wfbean.getReason());
		    		pstmt.setDate(2,wfbean.getRDate());
		    		pstmt.setBoolean(3,wfbean.isStatus());
		            pstmt.setInt(4,wfbean.getReqId()); 
		    		pstmt.executeUpdate();
		    	}
		 }
		catch(Exception ex) {
	        ex.printStackTrace();
	     }
	     finally {
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
	public int getWfId(WorkflowBean wfbean) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sqlQuery=null;
		ResultSet rs=null;
		int wfId=-1;
		try {
	        	DBConnection db=new DBConnection();
				conn=db.getConnection();
				sqlQuery="SELECT \"WorkflowID\" " +
					"FROM \"Workflow\" " +
					"WHERE \"RequestedBy\"=? "
					+ "AND \"RequestedDate\"=? "
					+ "AND \"Status\"=? "
					+ "AND \"Reason\"=?";
				conn=db.getConnection();
				if(conn != null) {
					pstmt=conn.prepareStatement(sqlQuery);
					pstmt.setInt(1,wfbean.getReqId());
					pstmt.setDate(2,wfbean.getRDate());
					pstmt.setBoolean(3,wfbean.isStatus());
					pstmt.setString(4,wfbean.getReason());
					rs=pstmt.executeQuery();
					System.out.println("workflow returned rows="+rs.getRow());
				}
				if(rs.next()) {
					wfId=rs.getInt(1);
				}
		}
		catch(Exception ex) {
	        ex.printStackTrace();
	     }
	     finally {
	     	try {
		     	if(null!=conn){        		
		     		conn.commit();				
		     		conn.close();
		     	}
		     	if(null!=pstmt){  
		     		pstmt.close();
		     	}
		     	if(null != rs) {
		     		rs.close();
		     	}
	     	} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     }
		return wfId;
	}
	public ArrayList<WorkflowBean> getWorkflow(int empId)
	{
		 ArrayList<WorkflowBean> al = new ArrayList<WorkflowBean>(); 
		 Connection conn=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs=null;
	     String sqlQuery=null;
	     WorkflowBean wfBean=null;
			
		try {
			    DBConnection db=new DBConnection();
				conn=db.getConnection();
				sqlQuery="SELECT " +
						"\"Reason\"," +
						"\"RequestedDate\"," +
						"\"Approver\","+
						"\"Status\"," +
						"\"WorkflowID\"" +
						"FROM \"Workflow\" " +
						"WHERE \"RequestedBy\" =?";
				if(conn != null) {
					pstmt=conn.prepareStatement(sqlQuery);
					pstmt.setInt(1,empId);
					rs=pstmt.executeQuery();
					System.out.println("rows="+rs.getRow());
					while(rs.next()) {
						wfBean=new WorkflowBean();
						wfBean.setReason(rs.getString(1));
						wfBean.setRDate(rs.getDate(2));
						wfBean.setApprover(rs.getInt(3));
						wfBean.setStatus(rs.getBoolean(4));
						wfBean.setWfId(rs.getInt(5));
						wfBean.setReqId(empId);
						al.add(wfBean);
					}
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
		     	if(null!=rs) {
		     		rs.close();
		     	}
	     	} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			  }
	     }
	     return al;
		}
	public ArrayList<WorkflowBean> getAllWorkflow()
	{
		 ArrayList<WorkflowBean> al = new ArrayList<WorkflowBean>(); 
		 Connection conn=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs=null;
	     String sqlQuery=null;
	     WorkflowBean wfBean=null;
			
		try {
			    DBConnection db=new DBConnection();
				conn=db.getConnection();
				sqlQuery="SELECT * FROM \"Workflow\" ";
				if(conn != null) {
					pstmt=conn.prepareStatement(sqlQuery);
					rs=pstmt.executeQuery();
					System.out.println("rows="+rs.getRow());
					while(rs.next()) {
						wfBean=new WorkflowBean();
						wfBean.setReason(rs.getString(1));
						wfBean.setRDate(rs.getDate(2));
						wfBean.setApprover(rs.getInt(3));
						wfBean.setStatus(rs.getBoolean(4));
						wfBean.setReqId(rs.getInt(5));
						wfBean.setWfId(rs.getInt(6));
						al.add(wfBean);
					}
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
		     	if(null!=rs) {
		     		rs.close();
		     	}
	     	} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			  }
	     }
	     return al;
		}
	public void updateWorkflow(int wfId,boolean stat,int empId) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sqlQuery=null;
		 try {
	        	DBConnection db=new DBConnection();
				conn=db.getConnection();
				sqlQuery="UPDATE \"Workflow\" " +
				" SET \"Status\"=?,\"Approver\"=? "
				+ "WHERE \"WorkflowID\"=?" ;
				if(conn != null) {
		    		pstmt=conn.prepareStatement(sqlQuery);
		    		pstmt.setBoolean(1,stat);
		    		pstmt.setInt(2,empId);
		    		pstmt.setInt(3,wfId);
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
		     	} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				  }
		 }
	}
}

			
