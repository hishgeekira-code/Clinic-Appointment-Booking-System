package mn.icode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import mn.icode.entity.Schedule;
import mn.icode.service.DoctorService;
import mn.icode.service.ScheduleService;

@Controller
@RequestMapping("/admin/schedules")
public class AdminScheduleController {
	
	private final ScheduleService scheduleService;
	private final DoctorService doctorService;
	
	public AdminScheduleController(ScheduleService scheduleService, DoctorService doctorService) {
		this.scheduleService = scheduleService;
		this.doctorService = doctorService;
	}
	
	@GetMapping
	public String getSchedulesPage(Model model) {
		model.addAttribute("schedules", scheduleService.getAllSchedules());
		model.addAttribute("doctors", doctorService.getAllDoctors());
		model.addAttribute("schedule", new Schedule());
		return "admin/schedules";
	}
	
	@PostMapping("/add")
	public String addSchedule(@ModelAttribute("schedule") Schedule schedule) {
		scheduleService.saveSchedule(schedule);
		return "redirect:/admin/schedules";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteSchedule(@PathVariable Long id) {
		scheduleService.deleteSchedule(id);
		return "redirect:/admin/schedules";
	}
}
