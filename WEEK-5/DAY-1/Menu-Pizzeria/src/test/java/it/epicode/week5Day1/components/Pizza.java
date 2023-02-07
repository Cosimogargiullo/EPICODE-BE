package it.epicode.week5Day1.components;

import java.util.ArrayList;
import java.util.List;

public class Pizza extends Prodotto{
	private List<String> ingredienti = new ArrayList<String>() {{
		add("Tomato");
		add("Cheese");
	}};
//	private List<String> Topping = new ArrayList<String>();
	
	
//	Constructors
	public Pizza() {

	}
	
	public Pizza(String  prodName, double prezzo, double calorie) {
		super( prodName, prezzo, calorie);
	}

	public List<String> getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(String ingredienti) {
		this.ingredienti.add(ingredienti);
	}
	
	public static void getFamilyPizza() {
		setCalorie(getCalorie()*1.95);
		setPrezzo(getPrezzo()+4.15);
	}
	
}
