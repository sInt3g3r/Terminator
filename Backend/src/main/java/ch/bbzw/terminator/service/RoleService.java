package ch.bbzw.terminator.service;

import ch.bbzw.terminator.model.Role;
import ch.bbzw.terminator.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Notwendig für @Autowired (bean)
public class RoleService {

    private final RoleRepo roleRepo;

    @Autowired
    public RoleService(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    //readAll
    public List<Role> getRoles() {
        return roleRepo.findAll();
    }

    //readSingle
    public Optional<Role> getRole(long id) {
        boolean exists = roleRepo.existsById(id);
        if (exists) {
            return roleRepo.findById(id);
        }
        else {
            throw new IllegalStateException("ID: "+id+" not found.");
        }
    }

    //delete
    public void delRole(long id) {
        boolean exists = roleRepo.existsById(id);
        if (exists) {
            roleRepo.deleteById(id);
        }
        else {
            throw new IllegalStateException("ID: "+id+" not found.");
        }
    }

    //replace
    public void putRole(long id, Role role) {
        boolean exists = roleRepo.existsById(id);
        if (exists) {
            role.setId(id);
            roleRepo.save(role);
        }
        else {
            throw new IllegalStateException("ID: "+id+" not found.");
        }
    }

    //create
    public void postRole(Role role) {
        if ( role.getRoleName().isEmpty() ) {
            throw new IllegalStateException("Note cannot be empty. UserId needs to be greater then 0.");
        }
        else{
            roleRepo.save(role);
        }
    }
}
