package com.masai.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtils {
     public static Connection getConnectionToDatabases() throws ClassNotFoundException, SQLException {
    	 Class.forName("com.mysql.cj.jdbc.Driver");
    	 String url = "jdbc:mysql://localhost/db1";
    	 return DriverManager.getConnection(url, "root", "6809");
     }
     public static void closeConnection(Connection con) throws SQLException {
    	 if(con != null)
    		 con.close();
     }
}
