package mn.icode.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "appointments")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "doctor_id", nullable = false)
	private Doctor doctor;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "schedule_id", nullable = false, unique = true)
	private Schedule schedule;
	
	private String reason;
	
	@Column(nullable = false)
	private String status = "BOOKED"; // BOOKED, CONFIRMED, COMPLETED, CANCELLED, NO_SHOW
	
	@Column(nullable = false)
	private LocalDateTime createdAt = LocalDateTime.now();
	
	public Appointment() {}

	public Appointment(User user, Doctor doctor, Schedule schedule, String reason, String status) {
		this.user = user;
		this.doctor = doctor;
		this.schedule = schedule;
		this.reason = reason;
		this.status = status;
		this.createdAt = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
	
}
