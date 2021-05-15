package ch.bbzw.terminator.config;

import ch.bbzw.terminator.model.Task;
import ch.bbzw.terminator.repository.TaskRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class TaskConfig {

    @Bean("task")
    CommandLineRunner commandLineRunner(TaskRepo taskRepo){
        return args -> {
            Task t1 = new Task(
                    2L,
                    LocalDate.of(2000, Month.FEBRUARY,5),
                    "Aufräumen",
                    "Zimmer 1B",
                    true
            );
            Task t2 = new Task(
                    2L,
                    LocalDate.now(),
                    "Kochen 18:00",
                    "Spaghetti",
                    false
            );

            taskRepo.saveAll(List.of(t1,t2));
        };
    }
}
