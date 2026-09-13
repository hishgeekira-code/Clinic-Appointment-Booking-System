package mn.icode.controller.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mn.icode.entity.Doctor;
import mn.icode.service.DoctorService;

@RestController
@RequestMapping("/api/admin/doctors")
public class DoctorRestController {
	
	private final DoctorService doctorService;
	
	public DoctorRestController(DoctorService doctorService) {
		this.doctorService = doctorService;
	}
	
	@GetMapping
	public ResponseEntity<List<Doctor>> getAll() {
		return ResponseEntity.ok(doctorService.getAllDoctors());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Doctor> getById(@PathVariable Long id) {
		return ResponseEntity.ok(doctorService.getDoctorById(id));
	}
	
	@PostMapping
	public ResponseEntity<Doctor> create(@RequestBody Doctor doctor) {
		return ResponseEntity.ok(doctorService.saveDoctor(doctor));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Doctor> update(@PathVariable Long id, @RequestBody Doctor doctor) {
		return ResponseEntity.ok(doctorService.updateDoctor(id, doctor));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		doctorService.deleteDoctor(id);
		return ResponseEntity.noContent().build();
	}
}
