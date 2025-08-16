package rebit.pm.training.currencymgtapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
	private static Connection connection;
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Admin@123";
	private static final String CONNECTIONURL = "jdbc:mysql://localhost:3306/coin_mgt_app";

	public static void initializeDatabase() {
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(CONNECTIONURL, USERNAME, PASSWORD);
		} catch (Exception e) {
			throw new RuntimeException("Failed to Connect.");
		}
	}

	public static Connection getConnection() {
		if (connection == null) {
			throw new IllegalStateException("Database connection established.");
		}
		return connection;
	}

	public static void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeResource(AutoCloseable resource) {
		if (resource != null) {
			try {
				resource.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}