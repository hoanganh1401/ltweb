package vn.iotstar.configs;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectSQL {
	private final String serverName = "DESKTOP-0A9U9E2\\HOANGANH";
	private final String dbName = "KetNoiDB";
	private final String portNumber = "1434";
	private final String instance = "";
	private final String userID = "sa";
	private final String password = "ask123456789";
	
	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName="
				+ dbName;
		if (instance == null || instance.trim().isEmpty())
			url = "jdbc:sqlserver://" + serverName  + ";databaseName=" + dbName;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url, userID, password);
				
	
}

public static void main(String[] args) {
	try {
		System.out.println(new DBConnectSQL().getConnection());
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
}