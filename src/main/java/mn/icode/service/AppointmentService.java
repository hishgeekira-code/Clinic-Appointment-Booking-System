package mn.icode.service;

import mn.icode.entity.Appointment;
import mn.icode.entity.Doctor;
import mn.icode.entity.Schedule;
import mn.icode.entity.User;
import mn.icode.repository.AppointmentRepository;
import mn.icode.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final ScheduleRepository scheduleRepository;

    public AppointmentService(AppointmentRepository appointmentRepository, ScheduleRepository scheduleRepository) {
        this.appointmentRepository = appointmentRepository;
        this.scheduleRepository = scheduleRepository;
    }

    @Transactional
    public Appointment createAppointment(User user, Doctor doctor, Schedule schedule, String reason) {
        // Schedule-ийн боломжтой эсэхийг шалгах
        if (!schedule.getAvailable()) {
            throw new IllegalStateException("The selected appointment time is unavailable.");
        }

        // Захиалга үүсгэх
        Appointment appointment = new Appointment(user, doctor, schedule, reason, "BOOKED");
        
        // Хуваарийн идэвхтэй төлөвийг false болгох
        schedule.setAvailable(false);
        scheduleRepository.save(schedule);

        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAppointmentsByUser(Long userId) {
        return appointmentRepository.findByUserId(userId);
    }

    public List<Appointment> getAppointmentsByDoctor(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
}