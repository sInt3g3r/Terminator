package ch.bbzw.terminator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "role")
public class UserRole implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_sequence")
    @SequenceGenerator(allocationSize = 1, name = "role_sequence")
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(nullable = false, unique = true)
    private String roleName;

    @Column
    private String description;

    public UserRole(String _roleName, String _description) {
        this.roleName = _roleName;
        this.description = _description;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getDescription() {
        return description;
    }

}