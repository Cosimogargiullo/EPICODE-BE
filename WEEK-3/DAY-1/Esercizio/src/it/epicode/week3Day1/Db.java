package it.epicode.week3Day1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class Db {

	private final String url = "jdbc:postgresql://localhost:5432/postgres?useSSL=false";
	private final String username = "postgres";
	private final String password = "18062020";
	private Connection conn = null;

//	Establishing Connection
	public void connect() {
		try {
			System.out.println("Connecting to database " + url);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connection is successful!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	Terminate Connection
	public void disconnect() {
		if (conn != null) {
			try {
				conn.close();
				System.out.println("Disonnection is successful!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

//	Add data
	public void insertCliente(String nome, String cognome,  Date dataNascita, String regioneResidenza) {

		try {
			String sql = "INSERT INTO clienti (nome, cognome, dataNascita, regioneResidenza) VALUES (?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, nome);
			stmt.setString(2, cognome);
			stmt.setDate(3, dataNascita);
			stmt.setString(4, regioneResidenza);
			stmt.execute();

			System.out.println("Insert is successful!");
		} catch (SQLException e) {
			System.out.println("There was an error during inserting data");
			e.printStackTrace();
		}

	}
}
