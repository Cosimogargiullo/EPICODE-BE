package it.epicode.be.gestioneincendi.model;

public class CentroControlloFactory {
	
	private static int selectCentroControllo = 0;
	
	public static CentroControlloInterface createCentroControllo() {
		
		switch (selectCentroControllo) {
		case 0:
			return new CentroControlloHttp();
		 default:
			 throw new RuntimeException("Centro di controllo non supportato");
		}
		
	}

	public static int getSelectCentroControllo() {
		return selectCentroControllo;
	}

	public static void setSelectCentroControllo(int select) {
		selectCentroControllo = select;
	}

}
