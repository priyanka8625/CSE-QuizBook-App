package in.quizbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseOp {
	private static String DRIVERNAME = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql:///quizbook";
	private static String USERNAME = "root";
	
	private static String INSERT_QUERY = "insert into `Registration` values (?,?,?);"; 
	private static String SELECT_QUERY = ""; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int insertIntoRegistration(ArrayList al) throws SQLException{
		int rows = 0;
		Connection con = null;
		Statement st = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName(DRIVERNAME);
			con = DriverManager.getConnection(URL, USERNAME, null);
			ps = (PreparedStatement) con.prepareStatement(INSERT_QUERY);
			if(ps != null) {
				ps.setString(1,(String) al.get(0));
				ps.setString(2, (String) al.get(1));
				ps.setString(3, (String) al.get(2));
				rows = ps.executeUpdate();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return rows;
	}
	public ResultSet selectFromRegistration(String uName,String pwd) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		SELECT_QUERY = "select `email_id`,`password` from `registration` where `email_id`=? and `password`=?;";
		try {
			Class.forName(DRIVERNAME);
			con = DriverManager.getConnection(URL,USERNAME,null);
			ps = con.prepareStatement(SELECT_QUERY);
			if(ps != null) {
				ps.setString(1, uName);
				ps.setString(2, pwd);
				rs = ps.executeQuery();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
