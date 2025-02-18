package com.example.demo.config;


import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {

    @Bean
    public void createDefaultAdmin(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        if (userRepository.findByUsername("admin").isEmpty()) { // Check if admin already exists
            User admin = new User(null, "Mohamed", "Ali","admin", passwordEncoder.encode("admin123"), User.Role.ADMIN);
            userRepository.save(admin);
            System.out.println("✅ Default admin user created: admin / admin123");
        }
    }
}
