package in.quizbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database_dash {
	private static String DRIVERNAME = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql:///quizbook";
	private static String USERNAME = "root";
	
	private static String SELECT_REG = "select `name` from `registration` where `email_id`=?;"; 
	private static String SELECT_SCORE = "select * from `quizresults` where `email_id`=?;";
	private static String INSERT_EMAIL = "insert into `quizresults` values (?,'','','','')";
	private static String UPDATE_C_SCORE = "update `quizresults` set `c`=? where `email_id`=?";
	private static String UPDATE_CPP_SCORE = "update `quizresults` set `cpp`=? where `email_id`=?";
	private static String UPDATE_JAVA_SCORE = "update `quizresults` set `java`=? where `email_id`=?";
	private static String UPDATE_JS_SCORE = "update `quizresults` set `javascipt`=? where `email_id`=?";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ResultSet fetchReg(String user) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName(DRIVERNAME);
			con = DriverManager.getConnection(URL,USERNAME,null);
			ps = con.prepareStatement(SELECT_REG);
			if(ps != null) {
				ps.setString(1, user);
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
	
	public ResultSet fetchQuizResults(String user) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName(DRIVERNAME);
			con = DriverManager.getConnection(URL,USERNAME,null);
			ps = con.prepareStatement(SELECT_SCORE);
			if(ps != null) {
				ps.setString(1, user);
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
	public void insertUserInQuizresults(String userName) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName(DRIVERNAME);
			con = DriverManager.getConnection(URL, USERNAME, null);
			ps = (PreparedStatement) con.prepareStatement(INSERT_EMAIL);
			if(ps != null) {
				ps.setString(1,userName);
				ps.executeUpdate();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		} 
	}
	public void updateCScore(Integer score,String userName) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName(DRIVERNAME);
			con = DriverManager.getConnection(URL, USERNAME, null);
			ps = (PreparedStatement) con.prepareStatement(UPDATE_C_SCORE);
			if(ps != null) {
				ps.setString(1,score.toString());
				ps.setString(2, userName);
				ps.executeUpdate();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public void updateCppScore(Integer score,String userName) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName(DRIVERNAME);
			con = DriverManager.getConnection(URL, USERNAME, null);
			ps = (PreparedStatement) con.prepareStatement(UPDATE_CPP_SCORE);
			if(ps != null) {
				ps.setString(1,score.toString());
				ps.setString(2, userName);
				ps.executeUpdate();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public void updateJavaScore(Integer score,String userName) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName(DRIVERNAME);
			con = DriverManager.getConnection(URL, USERNAME, null);
			ps = (PreparedStatement) con.prepareStatement(UPDATE_JAVA_SCORE);
			if(ps != null) {
				ps.setString(1,score.toString());
				ps.setString(2, userName);
				ps.executeUpdate();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public void updateJsScore(Integer score,String userName) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName(DRIVERNAME);
			con = DriverManager.getConnection(URL, USERNAME, null);
			ps = (PreparedStatement) con.prepareStatement(UPDATE_JS_SCORE);
			if(ps != null) {
				ps.setString(1,score.toString());
				ps.setString(2, userName);
				ps.executeUpdate();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
