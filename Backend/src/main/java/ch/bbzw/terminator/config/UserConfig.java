package ch.bbzw.terminator.config;

import ch.bbzw.terminator.model.User;
import ch.bbzw.terminator.repository.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean("user")
    CommandLineRunner commandLineRunner (UserRepo userRepo) {
        return args -> {
            User u1 = new User(
                    "Müller Franz",
                    "secret",
                    "Admin",
                    1L
            );

            User u2 = new User(
                    "Chai Yu",
                    "secret",
                    "Benutzer",
                    2L
            );

            userRepo.saveAll(List.of(u1,u2));
        };
    }
}
