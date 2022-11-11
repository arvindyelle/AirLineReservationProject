package com.airreservation.demo.controller;

import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airreservation.demo.dao.RoleDao;
import com.airreservation.demo.dao.UserDao;
import com.airreservation.demo.dto.LoginDto;
import com.airreservation.demo.dto.SignUpDto;
import com.airreservation.demo.model.Role;
import com.airreservation.demo.model.User;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginDto loginDto) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(), loginDto.getPassword()));
		/*
		 * Authentication authentication = authenticationManager.authenticate( new
		 * UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(),
		 * loginDto.getPassword()));
		 */
		/*
		 * SecurityContext context = SecurityContextHolder.createEmptyContext();
		 * context.setAuthentication(authentication);
		 * SecurityContextHolder.setContext(context);
		 */
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
	}

	@SuppressWarnings("unchecked")
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto) {

		// add check for username exists in a DB
		if (userDao.existsByUsername(signUpDto.getUsername())) {
			return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
		}

		// add check for email exists in DB
		if (userDao.existsByEmail(signUpDto.getEmail())) {
			return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
		}

		// create user object
		User user = new User();
		user.setTitle(signUpDto.getTitle());
		user.setFirstName(signUpDto.getFirstName());
		user.setLastName(signUpDto.getLastName());
		user.setUsername(signUpDto.getUsername());
		user.setEmail(signUpDto.getEmail());
		user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
		user.setConfirmPassword(passwordEncoder.encode(signUpDto.getConfirmPassword()));
		user.setDateOfBirth(signUpDto.getDateOfBirth());
		user.setPhoneNumber(signUpDto.getPhoneNumber());
		
		

		Set<Role> roles = roleDao.findByRole("ROLE_USER");
		user.setRole((Set<Role>) roles);

		userDao.save(user);

		return new ResponseEntity<>("User registered successfully", HttpStatus.OK);

	}

}
