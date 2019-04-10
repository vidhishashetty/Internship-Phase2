package com.example.hospitalpatient.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;

@Entity
@Table(name = "suppliers")

public class Supplier implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String company;
    
    @NotBlank
   private String email;
    
    
 // Getters and Setters
    
    public Long getId() {
		return id;
	}
   
   public void setId(Long id) {
		this.id = id;
	}
   
   
    public String getName() {
		return name;
	}
    public void setName(String name) {
		this.name = name;

    }
	 public String getCompany() {
			return company;
		}
	 public void setCompany(String company) {
			this.company = company;


	 }	
	 public String getEmail() {
		return email;
		}
	    public void setEmail(String email) {
			this.email = email;
	    }}
