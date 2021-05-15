package ch.bbzw.terminator.model;

import lombok.*;
import javax.persistence.*;

@AllArgsConstructor //Lombok - Erstellt einen Konstruktor mit allen Parametern abhänig von den Membervariablen
@NoArgsConstructor //Lombok - Erstellt einen Leeren Konstruktor
@Data //Lombok - erstellt ToString(), Konstruktoren, Getter&Setter
@Entity //Entität - Informationsobjekt wird für DB benötigt
@Table(name = "benutzer") //Tabelle für DB benötigt
public class User {
    @Id
    @SequenceGenerator(name = "sec_user", sequenceName = "sec_user", allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "sec_user")
    private Long id;
    private String userName;
    private String userPw;
    private String description;
    private Long roleId;

    public User(String userName, String userPw, String description, Long roleId) {
        this.userName = userName;
        this.userPw = userPw;
        this.description = description;
        this.roleId = roleId;
    }
}
