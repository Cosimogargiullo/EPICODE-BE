package it.epicode.mobilemonitoring.common.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtUtils {

	@Value("${jwt.expirationms}")
	private long jwtExpirationMs;

	@Value("${jwt.secret}")
	private String jwtSecret;

//	GENERAZIONE DEL TOKEN
	public String generateJwtToken(Authentication authentication) {
		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
		Date now = new Date();
		Date expire = new Date(now.getTime() + jwtExpirationMs);
		userPrincipal.setExpirationTime(expire);
		return Jwts.builder().setSubject(userPrincipal.getUsername()).setIssuedAt(now).setExpiration(expire).signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}

//	GET USERNAME DAL TOKEN
	public String getUsernameFromToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}
	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (Exception ex) {
			log.error("ERRORE NEL TOKEN: {}", ex.getMessage());
		}
		return false;
	}
}
