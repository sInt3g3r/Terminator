package ch.bbzw.terminator.service;

import ch.bbzw.terminator.model.Role;
import ch.bbzw.terminator.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Notwendig für @Autowired (bean)
public class RoleService {

    private final RoleRepo roleRepo;

    @Autowired
    public RoleService(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    public List<Role> getRoles() {
        return roleRepo.findAll();
    }
}
