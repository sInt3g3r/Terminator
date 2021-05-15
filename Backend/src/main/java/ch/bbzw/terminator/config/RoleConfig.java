package ch.bbzw.terminator.config;

import ch.bbzw.terminator.model.Role;
import ch.bbzw.terminator.repository.RoleRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RoleConfig {

    @Bean("role")
    CommandLineRunner commandLineRunner(RoleRepo roleRepo) {
      return args -> {
          Role r1 = new Role(
                  "Admin",
                  "Administrator"
          );

          Role r2 = new Role(
                  "Benutzer",
                  "Normaler Benutzer"
          );

          roleRepo.saveAll(List.of(r1,r2));
      };
    }
}
