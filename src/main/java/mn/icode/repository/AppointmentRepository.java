package mn.icode.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import mn.icode.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	
	List<Appointment> findByUserId(Long userId);
	
	List<Appointment> findByDoctorId(Long doctorId);
	
	Optional<Appointment> findByScheduleId(Long scheduleId);
	
	List<Appointment> findByStatus(String status);
}
