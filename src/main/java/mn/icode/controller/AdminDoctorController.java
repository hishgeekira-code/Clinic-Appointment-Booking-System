package mn.icode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import mn.icode.entity.Doctor;
import mn.icode.service.DepartmentService;
import mn.icode.service.DoctorService;

@Controller
@RequestMapping("/admin/doctors")
public class AdminDoctorController {
	
	private final DoctorService doctorService;
	private final DepartmentService departmentService;
	
	public AdminDoctorController(DoctorService doctorService, DepartmentService departmentService) {
		this.doctorService = doctorService;
		this.departmentService = departmentService;
	}
	
	
	// Emch nariin jagsaalt harah
	@GetMapping
	public String listDoctors(Model model) {
		model.addAttribute("doctors", doctorService.getAllDoctors());
		model.addAttribute("departments", departmentService.getAllDepartments());
		model.addAttribute("doctor", new Doctor());
		return "admin/doctors";
	}
	
	// Shine emch nemeh
	@PostMapping("/add")
	public String addDoctor(@ModelAttribute("doctor") Doctor doctor) {
		doctorService.saveDoctor(doctor);
		return "redirect:/admin/doctors?success";
	}
	
	// Emchiin medeelel zasah huudas
	@GetMapping("/edit/{id}")
	public String editDoctorsForm(@PathVariable Long id, Model model) {
		model.addAttribute("doctor", doctorService.getDoctorById(id));
		model.addAttribute("departments", departmentService.getAllDepartments());
		return "admin/doctor-edit";
	}
	
	// Emchiin medeelel shinechleh
	@PostMapping("/update/{id}")
	public String updateDoctor(@PathVariable Long id, @ModelAttribute("doctor") Doctor doctor) {
		doctorService.updateDoctor(id, doctor);
		return "redirect:/admin/doctors?updated";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteDoctor(@PathVariable Long id) {
		doctorService.deleteDoctor(id);
		return "redirect:/admin/doctors?deleted";
	}
}
