package mn.icode.repository;

import mn.icode.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    // Эмчийн ID-аар хуваарийг авах
    List<Schedule> findByDoctorId(Long doctorId);

    // Эмч болон огноогоор идэвхтэй боломжит хуваарийг авах
    List<Schedule> findByDoctorIdAndAppointmentDateAndAvailableTrue(Long doctorId, LocalDate appointmentDate);
}