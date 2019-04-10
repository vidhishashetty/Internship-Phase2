package com.example.hospitalpatient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hospitalpatient.model.Supplier;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
