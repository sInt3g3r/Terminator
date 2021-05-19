package ch.bbzw.terminator.service;

import ch.bbzw.terminator.model.User;
import ch.bbzw.terminator.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Notwendig für @Autowired (bean)
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public void postUser(User user) {
        userRepo.save(user);
    }

    public void delUser(Long id) {
        boolean exists = userRepo.existsById(id);
        if (exists) {
            userRepo.deleteById(id);
        }
        else {
            throw new IllegalStateException("ID: "+id+" not found.");
        }
    }

    public void putUser(Long id, User user) {
        boolean exists = userRepo.existsById(id);
        if (exists) {
            user.setId(id);
            userRepo.save(user);
        }
        else {
            throw new IllegalStateException("ID: "+id+" not found.");
        }
    }
}
