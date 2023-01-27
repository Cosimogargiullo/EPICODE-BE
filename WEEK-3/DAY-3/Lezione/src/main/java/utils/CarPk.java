package utils;

import java.io.Serializable;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public class CarPk  implements Serializable {

	protected String plate;
	protected String country;
	
}
