package com.factory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class SqlFactory {
	
	Connection con;

	public Connection getcon(){
		try{			
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/system_survey_database","root","1367");

		}
		catch(SQLException e){
			System.out.println(e);
		}
		catch(ClassNotFoundException cnf){
			System.out.println(cnf);
		}
		return con;	

	}
	public void closecon(){
		try{	
			if(con != null)
			
				con.close();
			
		}catch(SQLException e){
			System.out.println(e);
		}
			
	}
}