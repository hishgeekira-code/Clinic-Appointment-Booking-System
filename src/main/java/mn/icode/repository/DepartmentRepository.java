package mn.icode.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import mn.icode.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	boolean existsByName(String name);
	
	Optional<Department> findByName(String name);
}
