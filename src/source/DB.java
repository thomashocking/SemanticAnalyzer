package source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class DB {
 
	public Connection conn = null;
 
	public DB() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); //check existence of jdbc.Driver
			String url = "jdbc:mysql://localhost:3306/voca"; //connection url
			conn = DriverManager.getConnection(url, "root", "wlfka102"); //init Connection
			System.out.println("conn built"); //confirm
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
 
	public ResultSet getResultSet(String sql) throws SQLException {
		Statement sta = conn.createStatement();
		//Executes the given SQL statement, which returns a single ResultSet object.
		return sta.executeQuery(sql);
	}
 
	public boolean executeSql(String sql) throws SQLException {
		Statement sta = conn.createStatement(); 
		//Executes the given SQL statement, which may return multiple results.
		return sta.execute(sql);
	}
 
	@Override
	protected void finalize() throws Throwable {
		if (conn != null || !conn.isClosed()) {
			conn.close();
		}
	}
}