package com.example.hospitalpatient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hospitalpatient.model.Patient;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}