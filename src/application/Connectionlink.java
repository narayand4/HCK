package application;

import java.sql.DriverManager;

public class Connectionlink {
	public Connectionlink getConnection(){
		Connectionlink con = null;
		try{
			String url = "jdbc:mysql://localhost:3306/pulakdb";
			String username = "durgesh";
			String password = "qaz#123";
						
			//Define Driver
			Class.forName("com.mysql.jdbc.Driver");
		
			//Establish connection
			con = (Connectionlink) DriverManager.getConnection(url,username,password);
		} catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return con;
	}
}
