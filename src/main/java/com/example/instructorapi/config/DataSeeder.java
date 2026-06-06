package com.example.instructorapi.config;

import com.example.instructorapi.model.Role;
import com.example.instructorapi.model.User;
import com.example.instructorapi.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataSeeder(
        UserRepository userRepository,
        PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        createAdminIfMissing();
    }

    private void createAdminIfMissing() {
        String adminEmail = "super.admin@gmail.com";

        if (userRepository.existsByEmail(adminEmail)) {
            return;
        }

        User admin = new User(
            "Super Admin",
            adminEmail,
            passwordEncoder.encode("password"),
            Role.ADMIN
        );

        userRepository.save(admin);

        System.out.println("Seeded default admin user: " + adminEmail);
    }
}