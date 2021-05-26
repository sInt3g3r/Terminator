package ch.bbzw.terminator.service;

import ch.bbzw.terminator.model.User;
import ch.bbzw.terminator.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Notwendig für @Autowired (bean)
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    //readAll
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    //readSingle
    public Optional<User> getUser(long id) {
        boolean exists = userRepo.existsById(id);
        if (exists) {
            return userRepo.findById(id);
        }
        else {
            throw new IllegalStateException("ID: "+id+" not found.");
        }
    }

    //delete
    public void delUser(Long id) {
        boolean exists = userRepo.existsById(id);
        if (exists) {
            userRepo.deleteById(id);
        }
        else {
            throw new IllegalStateException("ID: "+id+" not found.");
        }
    }

    //replace
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

    //create
    public void postUser(User user) {
        if (    user.getUserName().isEmpty() ||
                user.getUserPw().isEmpty() ||
                user.getRoleId() <= 0
            ) {
            throw new IllegalStateException("UserName,Password cannot be empty. RoleId needs to be greater then 0.");
        }
        else{
            userRepo.save(user);
        }
    }
}
