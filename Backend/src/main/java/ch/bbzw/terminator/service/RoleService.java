package ch.bbzw.terminator.service;

import ch.bbzw.terminator.model.UserRole;
import ch.bbzw.terminator.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RoleService {
    private final RoleRepo roleRepo;

    @Autowired
    public RoleService(final RoleRepo _taskRepo) {
        this.roleRepo = _taskRepo;
    }

    @Transactional(readOnly = true)
    public List<UserRole> getAll() {
        final Iterable<UserRole> tasks = roleRepo.findAll();
        return StreamSupport
                .stream(tasks.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Transactional
    public RoleRepo add(final UserRole _role) {
        return roleRepo.save(_role);
    }

    //@Caching(evict = {@CacheEvict(key = "#id"), @CacheEvict(key = "0")})
    public void delete(final long _id) {
        roleRepo.deleteById(_id);
    }

    //@CacheEvict(allEntries = true)
    public void deleteAll() {
        roleRepo.deleteAll(roleRepo.findAll());
    }

    @Transactional(readOnly = true)
    //@Cacheable(key = "#id", unless = "#result == null")
    public Optional<UserRole> get(final long _id) {
        return Optional.ofNullable(roleRepo.findById(_id));
    }
}