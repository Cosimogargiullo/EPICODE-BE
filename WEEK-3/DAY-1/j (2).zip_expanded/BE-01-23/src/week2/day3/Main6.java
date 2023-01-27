package week2.day3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class Main6 {
	
	private static final String ENCODING = "utf-8";

	public static void main(String[] args) {
		
		String fileName = "info.txt";
		File fileInfo = new File(fileName);
		Scanner in = new Scanner(System.in);
		
		if( fileInfo.exists() ) {
			System.out.printf( "il file %s esiste %n", fileName );
			
			System.out.println( "nome file: " + fileInfo.getName() );
			System.out.println( "path file: " + fileInfo.getPath() );
			System.out.println( "dimensioni file: " + fileInfo.length() );
			System.out.println( "ultima modifica file: " + fileInfo.lastModified() );
			
			System.out.println( "Scrivi sul file: " );
			try {
				System.out.println( "Dammi frase:" );
				String word = in.nextLine();
				
				// versione testo statico
				// writeOnFile( fileInfo, "ciao sono un testo statico", true );
				
				// versione testo dinamico
				writeOnFile( fileInfo, word + System.lineSeparator(), true );
				System.out.println( "Ho scritto correttamente sul file!" );
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println( "Leggi dal file:" );
			try {
				readFromFile(fileInfo);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.printf( "il file %s non esiste %n", fileName );
		}
		
		try {
			overwriteCycleOnFile(fileInfo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		in.close();

	}
	
	public static void writeOnFile(File f, String s, boolean append) throws IOException {
		// se non passo 4 argomento o lo passo false, sovrascrive il contenuto
		// se gli passo true, aggiunge al contenuto
		FileUtils.writeStringToFile(f, s, ENCODING, append);
	}
	
	public static void readFromFile(File f) throws IOException {
		System.out.printf( "I contenuti del file %s sono: %n", f.getName() );
		System.out.println( FileUtils.readFileToString(f, ENCODING) );
	}
	
	public static void overwriteCycleOnFile(File f) throws IOException {
		StringBuilder s = new StringBuilder("");
		for(int i = 1; i <= 10; i++) {
			s.append(i + "" + System.lineSeparator());
		}
		String str = s.toString();
		
		FileUtils.writeStringToFile(f, str, ENCODING, true);
	}

}
