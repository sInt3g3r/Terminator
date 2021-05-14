package ch.bbzw.terminator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.ColumnTransformer;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "benutzer")
@NamedQuery(name = "User.checkPassword", query = "SELECT u FROM User u WHERE u.userName = :userName and user_password = public.crypt(text(:user_password), text(user_password))")
public class User implements Serializable  { //Serializable =
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "benutzer_sequence")
    @SequenceGenerator(allocationSize = 1, name = "benutzer_sequence")
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(nullable = false, unique = true)
    private String userName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    @ColumnTransformer(write = "crypt(?, gen_salt('bf', 8))")
    private String userPw;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserGroup userGroup;

    protected User() {
    }

    public User(String _userName, String _userPw, UserGroup _userGroup) {
        this.userName = _userName;
        this.userPw = _userPw;
        this.userGroup = _userGroup;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPw;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }
}