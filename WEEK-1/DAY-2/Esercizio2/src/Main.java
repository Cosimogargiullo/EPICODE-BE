
public class Main {

	public static void main(String[] args) {
		
		Sim s1 = new Sim("+39 340 1001010");
		
		Chiamate chiamata1 = new Chiamate("+39 3444444444", 13);
		s1.getListaChiamate()[0] = chiamata1;
		
		chiamata1 = new Chiamate("+39 1111111", 3);
		s1.getListaChiamate()[1] = chiamata1;		
		
		s1.stampaDati();
		
	}

}
