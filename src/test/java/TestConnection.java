import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

public class TestConnection {

	public static void main(String[] args) throws SQLException {
		//jdbc:postgresql://host:port/database
		
		
		String url = "jdbc:postgresql://192.168.1.102:5434/testdb";
		Properties props = new Properties();
		props.setProperty("user","wildfly");
		props.setProperty("password","wildfly_ds218");
		Connection conn = DriverManager.getConnection(url, props);
		
		String query = "select id from test_schema.yves_table";
		
		Statement  stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		 while (rs.next()) {
		        int id = rs.getInt("ID");
		        System.out.println("Id: " + id);
		 }
		 stmt.close();
		conn.close();

	}

}
