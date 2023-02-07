package it.epicode.week5Day1.components;

public class Drink extends Prodotto {
	
	private double litri;
	private double volumi;
	
	
//	Constructors
	public Drink() {
	}
	
	public Drink(String  prodName, double prezzo, double calorie, double litri) {
		super(prodName, prezzo, calorie);
		this.litri = litri;
	}
	public Drink(String  prodName, double prezzo, double calorie, double litri, double volumi) {
		super(prodName, prezzo, calorie);
		this.litri = litri;
		this.volumi = volumi;
	}
}
