package com.example.hospitalpatient.controller;




import com.example.hospitalpatient.exception.ResourceNotFoundException;
import com.example.hospitalpatient.model.Staff;
import com.example.hospitalpatient.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StaffController {

    @Autowired
    StaffRepository staffRepository;

    // Get All Patients
    @GetMapping("/staffs")
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    // Create a new staff
    @PostMapping("/staffs")
    public Staff createStaff(@Valid @RequestBody Staff staff) {
        return staffRepository.save(staff);
    }

    // Get a Single Patient
    @GetMapping("/staffs/{id}")
    public Staff getStaffById(@PathVariable(value = "id") Long staffId) {
        return staffRepository.findById(staffId)
                .orElseThrow(() -> new ResourceNotFoundException("Staff", "id", staffId));
    }
    // Update a Patient
    @PutMapping("/staffs/{id}")
    public Staff updateStaff(@PathVariable(value = "id") Long staffId,
                                            @Valid @RequestBody Staff staffDetails) {

      Staff staff = staffRepository.findById(staffId)
                .orElseThrow(() -> new ResourceNotFoundException("Staff", "id", staffId));

      staff.setName(staffDetails.getName());
      staff.setProfession(staffDetails.getProfession());

      Staff updatedStaff = staffRepository.save(staff);
      return updatedStaff;
    }

    
 // Delete a Patient
    @DeleteMapping("/staffs/{id}")
    public ResponseEntity<?> deleteStaff(@PathVariable(value = "id") Long staffId) {
    	Staff staff = staffRepository.findById(staffId)
                .orElseThrow(() -> new ResourceNotFoundException("Staff", "id", staffId));

    	staffRepository.delete(staff);

        return ResponseEntity.ok().build();
    }
}
