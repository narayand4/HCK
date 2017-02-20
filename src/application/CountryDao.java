package application;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDao{
	Connection con = null;
	
	private void connect(){
		String url = "jdbc:mysql://localhost:3306/pulakdb";
		String username = "durgesh";
		String password = "qaz#123";
		try{
			//Define Driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//Establish connection
			con = DriverManager.getConnection(url,username,password);
		} catch (Exception ex){
			System.out.println(ex.getMessage());
		}		
	}
	
	public List<Country> getCountry(int id){
		connect();
		List<Country> list = new ArrayList<Country>();
		try{
			String condition = "";
			if(id>0)
				condition = "AND id='"+id+"'";
			String query = "SELECT * FROM countries WHERE 1=1 "+condition;
			
			//Fetch Data
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
				Country ct = new Country();
				ct.setId(rs.getInt(1));
				ct.setName(rs.getString(2));
				list.add(ct);
			}
			
			//close connection and statement 
			st.close();
			con.close();
		} catch (Exception ex){
			System.out.println(ex.getMessage());
		}
		return list;
	}
	
	public void addCountry(Country ct){
		connect();
		String insertQuery = "INSERT INTO countries (name) VALUES (?)";
		PreparedStatement prSt;
		try {
			prSt = con.prepareStatement(insertQuery);
			prSt.setString(1, ct.getName());
			prSt.executeUpdate();	
			
			//close connection
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
}
