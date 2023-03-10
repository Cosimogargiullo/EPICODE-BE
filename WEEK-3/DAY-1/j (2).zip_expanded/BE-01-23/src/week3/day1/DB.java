package week3.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	
	private final String url = "jdbc:postgresql://localhost:5432/j_theory3_example_db?useSSL=false";
	private final String username = "postgres";
	private final String password = "postgres";
	private Connection conn = null;

	public void connect() {
		try {
		  System.out.println("Connecting to database " + url);
		  conn = DriverManager.getConnection(url, username, password);
		  System.out.println("Connection is successful!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void disconnect() {
		if( conn != null ) {    	  
		    try {
				  conn.close();
				  System.out.println("Disonnection is successful!");
			} catch (SQLException e) {
				  e.printStackTrace();
			}
		}
	}
	
	public void insertStudent(String fullname, int address_id) {
		
		try {
			String sql = "INSERT INTO students (fullname, address_id) VALUES (?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, fullname);
			stmt.setInt(2, address_id);
			stmt.execute();
			
			System.out.println("Insert is successful!");
		}
		catch(SQLException e) {
			System.out.println("There was an error during inserting data");
			e.printStackTrace();
		}
		
	}
	
	public void updateStudent(String fullname, int id) {
		
		try {
			String sql = "UPDATE students SET fullname = ? WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, fullname);
			stmt.setInt(2, id);
			stmt.execute();
			
			System.out.println("Update is successful!");
		}
		catch(SQLException e) {
			System.out.println("There was an error during updating data");
			e.printStackTrace();
		}
		
	}
	
	public void selectAllStudents() {
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = 
			 stmt.executeQuery("SELECT students.id as sid, fullname, addresses.address FROM students JOIN addresses ON students.address_id = addresses.id ORDER BY sid ASC");
			
			System.out.println( "Students list:" );
			while( rs.next() ) {
				System.out.printf(
					"ID: %d Fullname: %s Address: %s%n", 
					rs.getInt("sid"), 
					rs.getString("fullname"),
					rs.getString("address")
				);
				System.out.println("-----------------------------------------------");
			}
			
		} catch (SQLException e) {
			System.out.println("There was an error during selecting data");
			e.printStackTrace();
		}
		
	}
	
	public void deleteStudent(int id) {
		try {
			String sql = "DELETE FROM students WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			
			System.out.println("Delete is successful!");
		}
		catch(SQLException e) {
			System.out.println("There was an error during deleting data");
			e.printStackTrace();
		}
	}
	
}
