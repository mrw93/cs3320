package edu.txstate.cyberflix.data.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DAO {

	private static final String DB_NAME = "sakila";
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/sakila";

	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "";   // fill this in with your root pw

	public static Connection getDBConnection() {
		Connection dbConnection = null;
		try {
			Class.forName(DB_DRIVER).newInstance();
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DAOPassword.getPassword());
			dbConnection.setAutoCommit(true);
		} catch (ClassNotFoundException e) {
			System.err.println(e.toString());
		} catch (InstantiationException | IllegalAccessException e) {
			System.err.println(e.toString());
		} catch (SQLException e) {
			System.err.println("DAO SQLException " + e.toString());
		}
		return dbConnection;
	}

	String getDBName() {
		return DB_NAME;
	}

	String getDBUserName() {
		return DB_USER;
	}

	String getDBPassword() {
		return DB_PASSWORD;
	}

	public void closeQuietly(Connection dbConnection) {
		try {
			dbConnection.close();
		} catch (SQLException e) {

		}

	}

	abstract public void save(Object anObject) throws SQLException;

}
