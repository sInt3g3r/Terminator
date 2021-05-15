package ch.bbzw.terminator.model;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor //Lombok - Erstellt einen Konstruktor mit allen Parametern abhänig von den Membervariablen
@NoArgsConstructor //Lombok - Erstellt einen Leeren Konstruktor
@Data //Lombok - erstellt ToString(), Konstruktoren, Getter&Setter
@Entity //Entität - Informationsobjekt wird für DB benötigt
@Table(name = "task") //Tabelle für DB benötigt
public class Task {
    @Id
    @SequenceGenerator(name = "sec_task", sequenceName = "sec_task", allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "sec_task")
    private Long id;
    private Long userId;
    private LocalDate taskDate;
    private String taskTitel;
    private String description;
    private Boolean taskDone;

    public Task(Long userId, LocalDate taskDate, String taskTitel, String description, Boolean taskDone) {
        this.userId = userId;
        this.taskDate = taskDate;
        this.taskTitel = taskTitel;
        this.description = description;
        this.taskDone = taskDone;
    }
}
