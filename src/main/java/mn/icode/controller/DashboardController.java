package mn.icode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
	
	@GetMapping("/customer/dashboard")
	public String customerDashboard() {
		return "customer/dashboard";
	}
	
	@GetMapping("/admin/dashboard")
	public String adminDashboard() {
		return "admin/dashboard";
	}
	
	@GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }
}
