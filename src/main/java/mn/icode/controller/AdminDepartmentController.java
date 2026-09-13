package mn.icode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mn.icode.entity.Department;
import mn.icode.security.DepartmentService;

@Controller
@RequestMapping("/admin/departments")
public class AdminDepartmentController {
	
	private final DepartmentService departmentService;
	
	public AdminDepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	// Jagsaalt harah
	@GetMapping
	public String listDepartments(Model model) {
		model.addAttribute("departments", departmentService.getAllDepartments());
		model.addAttribute("department", new Department());
		return "admin/departments";
	}
	
	// Shineer nemeh
	@PostMapping("/add")
	public String addDepartment(@ModelAttribute("department") Department department, Model model) {
		try {
			departmentService.saveDepartment(department);
			return "redirect:/admin/departments?success";
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			model.addAttribute("departments", departmentService.getAllDepartments());
			return "admin/departments";
		}
	}
	
	// Zasah huudas haruulah
	@GetMapping("/edit/{id}")
	public String editDepartmentForm(@PathVariable Long id, Model model) {
		model.addAttribute("department", departmentService.getDepartmentById(id));
		return "admin/department-edit";
	}
	
	// Zaswariig hadgalah
	@PostMapping("/update/{id}")
	public String updateDepartment(@PathVariable Long id, @ModelAttribute("department") Department department) {
		departmentService.updateDepartment(id, department);
		return  "redirect:/admin/departments?updated";
	}
	
	// Ustgah
	@GetMapping("/delete/{id}")
	public String  deleteDepartment(@PathVariable Long id) {
		departmentService.deleteDepartment(id);
		return "redirect:/admin/departments?deleted";
	}
}
