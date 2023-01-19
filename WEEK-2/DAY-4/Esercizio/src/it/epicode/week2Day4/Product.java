package it.epicode.week2Day4;

public class Product {

	private long id;
	private String name;
	private String category;
	private double price;
	
	public Product(long id, String name, String category, double price) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public double getPrice() {
		return price;
	}
	
	public String printProduct() {
		return "Prodotto - id: " + this.id + " - nome: " + this.name + " - categoria: " + this.category + " - prezzo " + this.price;
	}
	
	public String printProduct10() {
		return "Prodotto - id: " + this.id + " - nome: " + this.name + " - categoria: " + this.category + " - prezzo scontato del 10% " + (this.price-((this.price*10)/100));
	}

	
	
	

}
