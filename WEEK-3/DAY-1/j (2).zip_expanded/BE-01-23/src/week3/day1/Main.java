package week3.day1;

public class Main {

	public static void main(String[] args) {
		
		DB db = new DB();
		db.connect();
		
		boolean insertNewStudent = false;
		if( insertNewStudent ) {
			db.insertStudent("Giacomo Verdi", 1);
		}
		
		boolean updateStudent = false;
		if( updateStudent ) {
			db.updateStudent("Alba Rossi", 5);
		}
		
		boolean deleteStudent = true;
		if( deleteStudent ) {
			db.deleteStudent(6);
		}
		
		boolean showStudents = true;
		if( showStudents ) {
			db.selectAllStudents();
		}
		
		db.disconnect();

	}

}
