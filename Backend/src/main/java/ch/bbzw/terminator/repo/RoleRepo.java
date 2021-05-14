package ch.bbzw.terminator.repo;

import ch.bbzw.terminator.model.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends CrudRepository<UserRole, Long> {
    UserRole findById(long id);
}