package mn.icode.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mn.icode.entity.Department;
import mn.icode.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	private final DepartmentRepository departmentRepository;

	public DepartmentService(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}
	
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}
	
	public Department getDepartmentById(Long id) {
		return departmentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Department not found with id: " + id));
	}
	
	public Department saveDepartment(Department department) {
		if (department.getId() == null && departmentRepository.existsByName(department.getName())) {
			throw new RuntimeException("Department already exists!");
		}
		return departmentRepository.save(department);
	}
	
	public Department updateDepartment(Long id, Department updatedDepartment) {
		Department existing = getDepartmentById(id);
		existing.setName(updatedDepartment.getName());
		existing.setDescription(updatedDepartment.getDescription());
		return departmentRepository.save(existing);
	}
	
	public void deleteDepartment(Long id) {
		if (!departmentRepository.existsById(id)) {
			throw new RuntimeException("Department not found with id " + id);
		}
		departmentRepository.deleteById(id);
	}
}
