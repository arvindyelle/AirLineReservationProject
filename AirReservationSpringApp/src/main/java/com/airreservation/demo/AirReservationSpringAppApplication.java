package com.airreservation.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.airreservation.demo.dao.RoleDao;
import com.airreservation.demo.model.Role;

@SpringBootApplication
public class AirReservationSpringAppApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AirReservationSpringAppApplication.class, args);
	}
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public void run(String... args) throws Exception {

		Role adminRole = new Role();
		adminRole.setRole("ROLE_ADMIN");
		roleDao.save(adminRole);

		Role userRole = new Role();
		userRole.setRole("ROLE_USER");
		roleDao.save(userRole);

	}

}
