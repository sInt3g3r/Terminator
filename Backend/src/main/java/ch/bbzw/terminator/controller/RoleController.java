package ch.bbzw.terminator.controller;

import ch.bbzw.terminator.model.UserRole;
import ch.bbzw.terminator.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "/userRole")
//@PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
public class RoleController {
    private final UserRole userRole;

    @Autowired
    public RoleController(final UserRole _userRole) {
        this.userRole = _userRole;
    }

    @GetMapping("/info")
    public Authentication getInfo() {
        final SecurityContext context = SecurityContextHolder.getContext();
        return context.getAuthentication();
    }

    @GetMapping("/")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public List<UserRole> getAll() {
        final Iterable<UserRole> roles = userRole.findAll();
        return StreamSupport
                .stream(roles.spliterator(), false)
                .collect(Collectors.toList());
    }

    @PostMapping("/")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public UserRole add(@RequestBody final UserRole _user) {
        return RoleRepo.save(_user);
    }
}