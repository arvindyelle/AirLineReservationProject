package com.airreservation.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "auth_role")
public class Role {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "auth_role_id")
    private int id;

    @Column(name = "role_name",length=60)
    
    private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Role(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

	

}
