package ch.bbzw.terminator.config;

import ch.bbzw.terminator.model.Note;
import ch.bbzw.terminator.repository.NoteRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class NoteConfig {

    @Bean("note")
    CommandLineRunner commandLineRunner(NoteRepo noteRepo){
        return args -> {
            Note n1 = new Note(
                1L,
                "Meine Erste Notiz"
            );

            Note n2 = new Note(
                    2L,
                    "Halli Hallo, nicht vergessen"
            );
            Note n3 = new Note(
                    3L,
                    "Meine Mutter ist krank"
            );
            noteRepo.saveAll(List.of(n1,n2,n3));
        };
    }
}
