package vn.iostar.configs;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectSQL {
	private final String serverName = "localhost";
	private final String dbName = "ltweb";
	private final String portNumber = "1433";
	private final String instance = "";
	private final String userID = "vietfinn";
	private final String password = "vietfinn2909";

	public Connection getConnection() throws Exception {
	
			String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";integratedSecurity=true;"
					+ "databaseName=" + dbName;

			if (instance == null || instance.trim().isEmpty())
				url = "jdbc:sqlserver:// " + serverName + ":" + portNumber + ";integratedSecurity=true;databaseName=" + dbName;
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			return DriverManager.getConnection(url);

	}

	public static void main(String[] args) {
		try {
			System.out.println(new DBConnectSQL().getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
