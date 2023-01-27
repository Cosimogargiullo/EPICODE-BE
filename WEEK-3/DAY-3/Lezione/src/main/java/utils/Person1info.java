package utils;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Person1info {

	private double height;
	private double weight;
	private int age;
	@Column(unique=true)
	private String cf;
	public Person1info(double height, double weight, int age, String cf) {
		super();
		this.height = height;
		this.weight = weight;
		this.age = age;
		this.cf = cf;
	}
	public Person1info() {

	}
}
