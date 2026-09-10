package mn.icode.config;

import mn.icode.entity.User;
import mn.icode.model.Role;
import mn.icode.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        // Хэрэв админ хэрэглэгч байхгүй бол шинээр үүсгэнэ
        if (!userRepository.existsByEmail("admin@clinic.mn")) {
            User admin = new User();
            admin.setFirstName("System");
            admin.setLastName("Admin");
            admin.setEmail("admin@clinic.mn");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setPhone("99112233");
            admin.setRole(Role.ADMIN);
            admin.setEnabled(true);

            userRepository.save(admin);
        }
    }
}