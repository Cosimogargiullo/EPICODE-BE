package it.epicode.week2Day4;

public class Customer {	
	
	private long id;
	private String name;
	private Integer tier;
	
	public Customer(long id, String name, Integer tier) {
		super();
		this.id = id;
		this.name = name;
		this.tier = tier;
	}
	
	

	public long getId() {
		return id;
	}



	public String getName() {
		return name;
	}



	public Integer getTier() {
		return tier;
	}



	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
}
