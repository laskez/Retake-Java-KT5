package com.example.retake_kt5.config;

import com.example.retake_kt5.model.Category;
import com.example.retake_kt5.model.User;
import com.example.retake_kt5.repository.CategoryRepository;
import com.example.retake_kt5.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(CategoryRepository categoryRepository,
                           UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (categoryRepository.count() == 0) {
            categoryRepository.save(new Category(null, "Высокий"));
            categoryRepository.save(new Category(null, "Средний"));
            categoryRepository.save(new Category(null, "Низкий"));
            System.out.println("Добавлены начальные категории: Высокий, Средний, Низкий");
        }

        if (userRepository.findByUsername("laskez").isEmpty()) {
            User user = new User(
                    "laskez",
                    passwordEncoder.encode("laskez"),
                    "USER"
            );
            userRepository.save(user);
            System.out.println("Создан пользователь: laskez / laskez (роль USER)");
        }
    }
}