package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {

	private static final String url = "jdbc:mysql://127.0.0.1:3306/ninegag?useSSL=false";
	private static final String user = "boris";
	private static final String password = "Istinataboli1@";
	

	private static DBConnection instance = null;
	
	private Connection con;

	private DBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con =DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static DBConnection getInstance() {
		synchronized (DBConnection.class) {
			if (instance == null) {
				instance = new DBConnection();
			}
		}
		return instance;
	}

	public Connection getCon() {
		return con;
	}

}
