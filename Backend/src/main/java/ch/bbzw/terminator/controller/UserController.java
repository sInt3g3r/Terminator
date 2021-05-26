package ch.bbzw.terminator.controller;

import ch.bbzw.terminator.model.User;
import ch.bbzw.terminator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //readAll
    @GetMapping(path = "getUsers")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    //readSingle
    @GetMapping(path = "getUser/{id}")
    public Optional<User> getUser(@PathVariable("id") long id) { return userService.getUser(id); }

    //delete
    @DeleteMapping(path = "delUser/{id}")
    public void delUser(@PathVariable("id") Long id){
        userService.delUser(id);
    }

    //replace
    @PutMapping(path = "putUser/{id}")
    public void putUser(@PathVariable("id") Long id, @RequestBody User user){ userService.putUser(id,user); }

    //create
    @PostMapping(path = "postUser")
    public void postUser(@RequestBody User user){ userService.postUser(user); }
}
