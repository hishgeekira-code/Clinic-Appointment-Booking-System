package mn.icode.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mn.icode.entity.Schedule;
import mn.icode.repository.ScheduleRepository;

@Service
public class ScheduleService {
	private final ScheduleRepository scheduleRepository;
	
	public ScheduleService(ScheduleRepository scheduleRepository) {
		this.scheduleRepository = scheduleRepository;
	}
	
	public List<Schedule> getAllSchedules() {
		return scheduleRepository.findAll();
	}
	
	public List<Schedule> getSchedulesByDoctor(Long doctorId) {
		return scheduleRepository.findByDoctorId(doctorId);
	}
	
	public Schedule saveSchedule(Schedule schedule) {
		return scheduleRepository.save(schedule);
	}
	
	public void deleteSchedule(Long id) {
		scheduleRepository.deleteById(id);
	}
}
