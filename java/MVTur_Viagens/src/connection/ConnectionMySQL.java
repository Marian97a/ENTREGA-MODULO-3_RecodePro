package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMySQL {
	 private static String url = "jdbc:mysql://localhost:3306/MVTur_viagens";
	 private static String username = "root";
	 private static String password = "Ma@05091997";

    public static Connection createConnectionMySQL() throws Exception {
    	Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    public static void main(String[] args) throws Exception {
        Connection con = createConnectionMySQL();
        
        if (con != null) {
        	System.out.println("Connection established successfully!");
        	 con.close();
        }
    }
}