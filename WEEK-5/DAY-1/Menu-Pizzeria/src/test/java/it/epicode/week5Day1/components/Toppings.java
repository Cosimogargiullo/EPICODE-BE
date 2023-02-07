package it.epicode.week5Day1.components;

public enum Toppings {
	CHEESE(0.69, 92), HAM(0.99, 35), ONIONS(0.69, 22), PINAPPLE(0.79, 24), SALAMI(0.99, 86);

	public double prezzo;
	public int calorie;

	private Toppings(double prezzo, int calorie) {
		this.prezzo = prezzo;
		this.calorie = calorie;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public int getCalorie() {
		return calorie;
	}

	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}
	
	
}
