package it.epicode.week5Day1.components;

abstract public class Prodotto {
	private static double prezzo;
	private static double calorie;
	private String prodName;
	
	
//	Constructors
	public Prodotto() {
		
	}
	
	public Prodotto(String prodName, double prezzo, double calorie) {
		this.prezzo = prezzo;
		this.calorie = calorie;
		this.prodName = prodName;
		
	}

	public  static double getPrezzo() {
		return prezzo;
	}

	public static void setPrezzo(double prezz) {
		prezzo = prezz;
	}

	public static double getCalorie() {
		return calorie;
	}

	public static void setCalorie(double calori) {
		calorie = calori;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	
	
}
