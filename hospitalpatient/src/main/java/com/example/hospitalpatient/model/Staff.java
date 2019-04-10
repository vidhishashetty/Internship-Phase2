package com.example.hospitalpatient.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;



@Entity
@Table(name = "staffs")

public class Staff implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String profession;
    


    
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
	 public String getProfession() {
			return profession;
		}
	 public void setProfession(String profession) {
			this.profession = profession;

	 }	
	
}
