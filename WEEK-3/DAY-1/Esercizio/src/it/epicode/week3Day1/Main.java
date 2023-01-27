package it.epicode.week3Day1;

import java.sql.Date;

public class Main {

	public static void main(String[] args) {
		
//		DataBase Instance
		Db db = new Db();
//		DataBase Connection
		db.connect();
		
		boolean insertCliente = true;
		if( insertCliente ) {
			db.insertCliente( "Cosimo", "Gargiullo", Date.valueOf("2002-10-2"), "Calabria");
		}
//		DataBase Disconnection
		db.disconnect();

	}

}
