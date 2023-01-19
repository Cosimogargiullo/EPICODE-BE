package it.epicode.week2Day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {

//		PRODUCT LIST
		List<Product> products = new ArrayList<Product>(
				Arrays.asList(
					new Product(1, "Twilight", "Books", 121),
					new Product(2, "Socks", "Baby", 5.90),
					new Product(3, "T-Shirt", "Boy", 12),
					new Product(4, "After", "Books", 15),
					new Product(5, "Hat", "Baby", 59),
					new Product(6, "Pants", "Boy", 44)
				)
		);
		
		List<Product> products2 = new ArrayList<Product>(
				Arrays.asList(
					new Product(7, "Twilight", "Books", 121),
					new Product(8, "T-Shirt", "Boy", 12),
					new Product(9, "After", "Books", 15),
					new Product(10, "Pants", "Boy", 44)
				)
		);
		
//		ORDER LIST
		List<Order> orders = new ArrayList<Order>(
				Arrays.asList(
					new Order(1, "Shipped", 2021, 1, 01, 2021, 2, 23, products, new Customer(11, "Cliente-1", 2)),
					new Order(2, "Delivered", 2021, 2, 01, 2021, 2, 23, products2, new Customer(12, "Cliente-2", 1)),
					new Order(3, "Delivered", 2021, 7, 01, 2021, 2, 23, products, new Customer(13, "Cliente-3", 2)),
					new Order(4, "Delivered", 2021, 7, 01, 2021, 2, 23, products, new Customer(13, "Cliente-3", 1)),
					new Order(5, "Delivered", 2021, 7, 01, 2021, 2, 23, products, new Customer(13, "Cliente-3", 2))
				)
		);	

//		PRODUCT LIST CATEGORY: BOOKS, PRICE > 100
		List<Product> bookMore100 = products.stream().filter( p -> (p.getCategory() == "Books" && p.getPrice() > 100)).toList();
		bookMore100.forEach(e -> System.out.println(e.printProduct()));
		
//		ORDER LIST PRODUCT CATEGORY BABY
		Predicate<Product> catBaby = p -> p.getCategory().equals("Baby");
		List<Order> lp = orders.stream().filter( o -> (o.getProducts().stream().anyMatch(catBaby))).toList();
		lp.forEach(e -> System.out.println(e.printOrder()));
		
//		LIST BOY CATEGORY 10% DISCOUT
		List<Product> catBoy10 = products.stream().filter( p -> (p.getCategory() == "Boy")).toList();
		catBoy10.forEach(e -> System.out.println(e.printProduct()));
		catBoy10.forEach(e -> System.out.println(e.printProduct10()));
		
//		Ottenere una lista di prodotti ordinati da clienti di livello (tier) 2 tra l’01-Feb-2021 e l’01-Apr-2021
//		ORDER LIST PRODUCT CATEGORY BABY
		List<Product> lp3 = null;
		List<Order> lp2 = orders.stream().filter( o -> o.getCustomer().getTier() == 2 && (o.getOrderDate().getMonthValue() == 1 || o.getOrderDate().getMonthValue() == 2 || o.getOrderDate().getMonthValue() == 3 )).toList();
		lp2.forEach(e -> e.getProducts().forEach(c -> System.out.println(c.printProduct())));
		
	}

}
