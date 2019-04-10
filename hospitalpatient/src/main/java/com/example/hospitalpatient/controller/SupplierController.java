package com.example.hospitalpatient.controller;


import com.example.hospitalpatient.exception.ResourceNotFoundException;
import com.example.hospitalpatient.model.Supplier;
import com.example.hospitalpatient.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SupplierController {

    @Autowired
    SupplierRepository supplierRepository;

   //  Get All Patients
    @GetMapping("/suppliers")
    public List<Supplier> getAllStaff() {
        return supplierRepository.findAll();
    }

    // Create a new staff
    @PostMapping("/suppliers")
    public Supplier createStaff(@Valid @RequestBody Supplier supplier) {
        return supplierRepository.save(supplier);
    }

   //  Get a Single Patient
    @GetMapping("/suppliers/{id}")
    public Supplier getStaffById(@PathVariable(value = "id") Long supplierId) {
        return supplierRepository.findById(supplierId)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier", "id", supplierId));
    }
    // Update a Patient
    @PutMapping("/suppliers/{id}")
    public Supplier updateStaff(@PathVariable(value = "id") Long supplierId,
                                            @Valid @RequestBody Supplier supplierDetails) {

      Supplier supplier = supplierRepository.findById(supplierId)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier", "id", supplierId));

      supplier.setName(supplierDetails.getName());
      supplier.setCompany(supplierDetails.getCompany());
      supplier.setEmail(supplierDetails.getEmail());
      

      Supplier updatedSupplier = supplierRepository.save(supplier);
      return updatedSupplier;
    }


    
 // Delete a Patient
    @DeleteMapping("/suppliers/{id}")
    public ResponseEntity<?> deleteStaff(@PathVariable(value = "id") Long supplierId) {
    	Supplier supplier = supplierRepository.findById(supplierId)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier", "id", supplierId));

    	supplierRepository.delete(supplier);

        return ResponseEntity.ok().build();
    }
}
