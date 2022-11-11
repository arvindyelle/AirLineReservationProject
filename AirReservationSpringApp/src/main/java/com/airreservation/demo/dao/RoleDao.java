package com.airreservation.demo.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airreservation.demo.model.Role;
@Repository
public interface RoleDao extends JpaRepository<Role, Integer> {
	
	Set<Role> findByRole(String role);

}
