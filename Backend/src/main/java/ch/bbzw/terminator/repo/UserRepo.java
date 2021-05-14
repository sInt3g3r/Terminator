package ch.bbzw.terminator.repo;

import ch.bbzw.terminator.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    User checkPassword(String username, String user_password);
}
