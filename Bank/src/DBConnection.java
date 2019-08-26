//package BankInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	DBConnection(){
		
	}
	Connection getDBConnection(String dbname){
		String dbURL = "jdbc:mysql://localhost:3306/"+dbname;
        String username ="root";
        String password = "";
       
        Connection dbCon = null;
             
        try {
			dbCon = DriverManager.getConnection(dbURL, username, password);
		} catch (SQLException e) {
			System.out.println("Cannot connect to your database "+dbname +"and "+ e.getMessage());
		}
        return dbCon;
	}
}
