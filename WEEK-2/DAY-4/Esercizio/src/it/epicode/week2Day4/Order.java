package it.epicode.week2Day4;

import java.time.LocalDate;
import java.util.List;

public class Order {

	private long id;
	private String status;
	private LocalDate orderDate;
	private LocalDate deliveryDate;
	private List<Product> products;
	private Customer customer;
	
	public Order(long id, String status, int orderY, int orderM, int orderD, int deliveryY, int deliveryM, int deliveryD, List<Product> products,
			Customer customer) {
		super();
		this.id = id;
		this.status = status;
		this.orderDate = LocalDate.of(orderY, orderM, orderD);
		this.deliveryDate = LocalDate.of(deliveryY, deliveryM, deliveryD);
		this.products = products;
		this.customer = customer;
	}

	public long getId() {
		return id;
	}

	public String getStatus() {
		return status;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}
	
	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public List<Product> getProducts() {
		return products;
	}

	public Customer getCustomer() {
		return customer;
	}	
	
//	Override toString
	public String printOrder() {
		return "Ordine - id: " + this.id + " - status: " + this.status;
	}
	
}
