package com.example.hospitalpatient.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;



@Entity
@Table(name = "patients")

public class Patient implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String disease;
    

  private Long age;

    
    // Getters and Setters ... (Omitted for brevity)
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
	 public String getDisease() {
			return disease;
		}
	 public void setDisease(String disease) {
			this.disease = disease;


	 }	
	 public Long getAge() {
			return age;
		}
	 public void setAge(Long age) {
			this.age = age;


	 }	
	
}