import java.sql.*;
import javax.swing.*;

public class oracleConnection {

	Connection conn =null;
	public static Connection dbConnector() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC driver not found");
			e.printStackTrace();
			return null;
		}
		
		try {
			Connection conn=DriverManager.getConnection("AddOracleDatabaseServerConnectionString", "AddDatabaseUsername", "AddDatabasePassword");
			return conn;
			
		} catch (SQLException e) {
			System.out.println("Connection Failed");
			e.printStackTrace();
			return null;
		}
		
	}
	
	static Connection connection=dbConnector();
}
