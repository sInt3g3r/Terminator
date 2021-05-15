package ch.bbzw.terminator.model;

//@ToString  //Lombok - Überschreibt die ToString() Methode mit allen Members
//@AllArgsConstructor //Lombok - Erstellt einen Konstruktor mit allen Parameter abhängig von den Members
//@NoArgsConstructor //Lombok - Erstellt einen Leeren Konstruktor
//@EqualsAndHashCode // Lombok - Wird benötigt um Objekte zu vergleichen
//@Slf4j //Lombok - logger

import lombok.*;
import javax.persistence.*;

@AllArgsConstructor //Lombok - Erstellt einen Konstruktor mit allen Parametern abhänig von den Membervariablen
@NoArgsConstructor //Lombok - Erstellt einen Leeren Konstruktor
@Data //Lombok - erstellt ToString(), Konstruktoren, Getter&Setter
@Entity //Entität - Informationsobjekt wird für DB benötigt
@Table(name = "note") //Tabelle für DB benötigt
public class Note {
    @Id
    @SequenceGenerator(name = "sec_note", sequenceName = "sec_note", allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "sec_note")
    private Long id;
    private Long userId;
    private String note;

    public Note(Long userId, String note) {
        this.userId = userId;
        this.note = note;
    }
}
