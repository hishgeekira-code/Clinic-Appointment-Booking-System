package mn.icode.controller.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import mn.icode.entity.Department;
import mn.icode.service.DepartmentService;

@RestController
@RequestMapping("/api/admin/departments")
public class DepartmentRestController {
	
	private final DepartmentService departmentService;
	
	public DepartmentRestController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	@GetMapping
	public ResponseEntity<List<Department>> getAll() {
		return ResponseEntity.ok(departmentService.getAllDepartments());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Department> getById(@PathVariable Long id) {
		return ResponseEntity.ok(departmentService.getDepartmentById(id));
	}
	
	@PostMapping
	public ResponseEntity<Department> create(@RequestBody Department department) {
		return ResponseEntity.ok(departmentService.saveDepartment(department));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Department> update(@PathVariable Long id, @RequestBody Department department) {
		return ResponseEntity.ok(departmentService.updateDepartment(id, department));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		departmentService.deleteDepartment(id);
		return ResponseEntity.noContent().build();
	}
}
