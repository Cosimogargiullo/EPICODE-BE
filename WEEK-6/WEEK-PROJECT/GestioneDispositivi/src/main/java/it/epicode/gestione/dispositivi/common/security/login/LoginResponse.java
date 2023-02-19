package it.epicode.gestione.dispositivi.common.security.login;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class LoginResponse {
	
	public LoginResponse(String username, String jwt, Date expiration, List<String> role) {
		this.username = username;
		this.token = jwt;
		this.expirationDate = expiration;
		this.roles = role;
	}
	
	private String token;
	private final String type = "Bearer";
	private String username;
	private List<String> roles;
	private Date expirationDate;
	
	
	

}
