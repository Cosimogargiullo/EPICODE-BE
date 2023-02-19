package it.epicode.mobilemonitoring.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.mobilemonitoring.common.security.JwtUtils;
import it.epicode.mobilemonitoring.common.security.UserDetailsImpl;
import it.epicode.mobilemonitoring.common.security.login.LoginRequest;
import it.epicode.mobilemonitoring.common.security.login.LoginResponse;

@RestController
public class AuthController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@PostMapping("/auth/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
		Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
//		auth.getAuthorities();
		
		SecurityContextHolder.getContext().setAuthentication(auth);
		
		String jwt = jwtUtils.generateJwtToken(auth);
		
		UserDetailsImpl user = (UserDetailsImpl) auth.getPrincipal();
		
		List<String> roles = user.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList());
		
		return ResponseEntity.ok(new LoginResponse(user.getUsername(),jwt,user.getExpirationTime(),roles));
	}

}
