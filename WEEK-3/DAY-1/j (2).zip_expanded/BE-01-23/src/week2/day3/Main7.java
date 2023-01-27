package week2.day3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

public class Main7 {
	
	private static final String ENCODING = "utf-8";

	public static void main(String[] args) {
		String fileName = "student.txt";
		File fileInfo = new File(fileName);
		
		if( fileInfo.exists() ) {
			try {
				readFromFile(fileInfo);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	public static void readFromFile(File f) throws IOException {
		String content = FileUtils.readFileToString(f, ENCODING);
		String[] segments = content.split("--");
		
		try {
			Student student = new Student( segments[0], Integer.parseInt(segments[1]), segments[2].split(",") );
			System.out.println( student );
		}
		catch(NumberFormatException e) {
			System.out.println( "Error!" );
		}
	}

}

class Student {
	private String name;
	private int age;
	private String[] _skills;
	private ArrayList<String> skills = new ArrayList<>();
	
	public Student(String name, int age, String[] _skills) {
		this.name = name;
		this.age = age;
		this._skills = _skills;
		this.fillSkills();
	}
	
	private void fillSkills() {
		for(int i = 0; i < this._skills.length; i++) {
			this.skills.add( this._skills[i] );
		}
	}
	
	@Override
	public String toString() {
		String s = String.format("Name: %s Age: %d%n", this.name, this.age);
		s += "Skills:" + System.lineSeparator();
		
		for(int i = 0; i < this.skills.size(); i++) {
			s += this.skills.get(i) + System.lineSeparator();
		}
		
		return s;
	}
}
