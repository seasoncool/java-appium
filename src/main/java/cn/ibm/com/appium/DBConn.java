package cn.ibm.com.appium;

import java.sql.*;
import java.util.Vector;

public class DBConn {
	
	String dbsqldriver = "net.sourceforge.jtds.jdbc.Driver";	
	String sqlurl = "jdbc:jtds:sqlserver://cndbzp1144.cn.ibm.com:1433;databaseName=Sales_Tracker_ST";
	String sqluser = "james";
	String sqlpassword = "sticm567";
	
	String dbmysqldriver = "com.mysql.jdbc.Driver";
	String mysqlurl = "jdbc:mysql://127.0.0.1:3307/scutcs";
	String mysqluser = "root";
	String mysqlpassword = "";
	
	Connection conn = null;
	ResultSet rs = null;
	String getResult = "";
	PreparedStatement ps;
	
	public void mySQLConn(){
	    try {
	      Class.forName(dbmysqldriver);
	      conn = DriverManager.getConnection(mysqlurl,mysqluser,mysqlpassword);
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }		
	}
	
	public void sqlConn(){
		try{
			Class.forName(dbsqldriver);
			conn = DriverManager.getConnection(sqlurl,sqluser,sqlpassword);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	// it must have return one row result then post index
	public String qureyReturn(String sql){
		try{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()){
				getResult = rs.getString(0);
			}
		}catch (Exception e){
			e.printStackTrace();
		}		
		return getResult;	
	}
	
	public Vector<Vector<Object>> getAllData(String sql){
        Vector<Vector<Object>> vc = new Vector<Vector<Object>>();
        Vector<Object> temp = null;
	    try {
	      ps = conn.prepareStatement(sql);
	      rs = ps.executeQuery();
	      ResultSetMetaData rsmd = rs.getMetaData();
	      while (rs.next()) {
	        temp = new Vector<Object>();
	        for (int i = 0; i < rsmd.getColumnCount(); i++) {
	          temp.add(rs.getObject(rsmd.getColumnName(i+1)));
	        }
	        vc.add(temp);
	      }
	       rs.close();
	       ps.close();
	       conn.close();
	    }
	    catch (Exception ex) {
	      ex.printStackTrace();
	    }
	    //return all data
	    return vc;
}
}	
	




