package com.revature.config;

import org.postgresql.Driver;

import java.sql.*;

/**
 * 
 * @author Revature
 *
 *         This is a paceholder class to hold the configurations of your db
 *         connection. You should change the url, username, and password. DO NOT
 *         CHANGE THE MODIFIERS OR THE NAMES OF THE VARIABLES. These are used to
 *         test your db schema.
 */
public class ConnectionUtil {
	//for singleton instance
	private static ConnectionUtil cu;
	
	// add your jdbc url
	public static final String URL = "jdbc:postgresql://db-test.cvzitglr9py5.us-east-1.rds.amazonaws.com:5432/test_db";
	// add your jdbc username
	public static final String USERNAME = "sanbornshane9";
	// add your jdbc password
	public static final String PASSWORD = "Qwasd0324!";
	// name of the created stored procedure in tier 3
	public static final String TIER_3_PROCEDURE_NAME = "";
	// name of the created sequence in tier 3
	public static final String TIER_3_SEQUENCE_NAME = "mysequence";

	static {
		try {
			DriverManager.registerDriver(new Driver());
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	// implement this method to connect to the db and return the connection object
	public Connection connect() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}


	//implement this method with a callable statement that calls the absolute value sql function
	public long callAbsoluteValueFunction(long value){
		Connection c = null;
		long answer = 0;
		try{
			c = cu.connect();
			CallableStatement s = c.prepareCall("{call ABS(?)}");
			s.setLong(1,value);
			ResultSet rs = s.executeQuery();
			while(rs.next()){
				answer = rs.getLong("Result");
			}
		}catch(SQLException throwables){

		}
		return answer;
	}
	

	//make the class into a singleton
	private ConnectionUtil(){
		super();
	}

	public static ConnectionUtil getInstance(){
		if(cu == null){
			cu = new ConnectionUtil();
		}
		return cu;
	}
}
