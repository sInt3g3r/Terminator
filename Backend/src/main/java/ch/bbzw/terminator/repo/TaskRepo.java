package ch.bbzw.terminator.repo;

import ch.bbzw.terminator.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TaskRepo extends CrudRepository<Task, Long>{
    Task findById(long id);

    Task findByTaskDate(Date taskDate);

}
