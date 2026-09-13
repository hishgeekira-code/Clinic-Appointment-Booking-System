package mn.icode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mn.icode.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	
	List<Doctor> findByActiveTrue();
	
	List<Doctor> findByDepartmentId(Long departmentId);
}
