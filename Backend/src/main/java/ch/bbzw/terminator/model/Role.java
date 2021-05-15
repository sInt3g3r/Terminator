package ch.bbzw.terminator.model;

import lombok.*;
import javax.persistence.*;

@AllArgsConstructor //Lombok - Erstellt einen Konstruktor mit allen Parametern abhänig von den Membervariablen
@NoArgsConstructor //Lombok - Erstellt einen Leeren Konstruktor
@Data //Lombok - erstellt ToString(), Konstruktoren, Getter&Setter
@Entity //Entität - Informationsobjekt wird für DB benötigt
@Table(name = "role") //Tabelle für DB benötigt
public class Role {
    @Id
    @SequenceGenerator(name = "sec_role", sequenceName = "sec_role", allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "sec_role")
    private Long id;
    private String roleName;
    private String description;

    public Role(String roleName, String description) {
        this.roleName = roleName;
        this.description = description;
    }
}
