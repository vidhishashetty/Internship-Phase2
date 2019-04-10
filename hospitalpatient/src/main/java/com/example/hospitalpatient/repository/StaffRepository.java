package com.example.hospitalpatient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hospitalpatient.model.Staff;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

}
