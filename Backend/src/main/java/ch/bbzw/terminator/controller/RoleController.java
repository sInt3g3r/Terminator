package ch.bbzw.terminator.controller;

import ch.bbzw.terminator.model.Role;
import ch.bbzw.terminator.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    //readAll
    @GetMapping(path = "getRoles")
    public List<Role> getRoles() {
        return roleService.getRoles();
    }

    //readSingle
    @GetMapping(path = "getRole/{id}")
    public Optional<Role> getRole(@PathVariable("id") long id) { return roleService.getRole(id);}

    //delete
    @DeleteMapping(path = "delRole/{id}")
    public void delRole(@PathVariable("id") long id) { roleService.delRole(id);}

    //replace
    @PutMapping(path = "putRole/{id}")
    public void putRole(@PathVariable("id") long id, @RequestBody Role role) { roleService.putRole(id, role);}

    //create
    @PostMapping(path = "postRole")
    public void postRole(@RequestBody Role role) { roleService.postRole(role);}
}
