package mn.icode.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mn.icode.entity.Doctor;
import mn.icode.repository.DoctorRepository;

@Service
public class DoctorService {
	
	private final DoctorRepository doctorRepository;
	
	public DoctorService(DoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}
	
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}
	
	public List<Doctor> getActiveDoctors() {
		return doctorRepository.findByActiveTrue();
	}
	
	public Doctor getDoctorById(Long id) {
		return doctorRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Doctor not found with id " + id));
	}
	
	public Doctor saveDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}
	
	public Doctor updateDoctor(Long id, Doctor updatedDoctor) {
		Doctor existing = getDoctorById(id);
		existing.setFirstName(updatedDoctor.getFirstName());
		existing.setLastName(updatedDoctor.getLastName());
		existing.setSpecialization(updatedDoctor.getSpecialization());
		existing.setBio(updatedDoctor.getBio());
		existing.setActive(updatedDoctor.getActive());
		existing.setDepartment(updatedDoctor.getDepartment());
		return doctorRepository.save(existing);
	}
	
	public void deleteDoctor(Long id) {
		if (!doctorRepository.existsById(id)) {
			throw new RuntimeException("Doctor not found with id " + id);
		}
		doctorRepository.deleteById(id);
	}
}
