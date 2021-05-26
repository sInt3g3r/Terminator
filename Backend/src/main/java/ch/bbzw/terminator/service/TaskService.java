package ch.bbzw.terminator.service;

import ch.bbzw.terminator.model.Task;
import ch.bbzw.terminator.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service //Notwendig für @Autowired (bean)
public class TaskService {

    private final TaskRepo taskRepo;

    @Autowired
    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    //readAll
    public List<Task> getTasks() {
        return taskRepo.findAll();
    }

    //readSingle
    public Optional<Task> findById(long id) {
        boolean exists = taskRepo.existsById(id);
        if (exists) {
            return taskRepo.findById(id);
        } else {
            throw new IllegalStateException("ID: " + id + " not found.");
        }
    }

    //delete
    public void delTask(Long id) {
        boolean exists = taskRepo.existsById(id);
        if (exists) {
            taskRepo.deleteById(id);
        }
        else {
            throw new IllegalStateException("Task wurde nicht gefunden");
        }
    }

    //replace
    public void putTask(Long id, Task task) {
        boolean exists = taskRepo.existsById(id);
        if (exists) {
            task.setId(id);
            taskRepo.save(task);
        }
        else {
            throw new IllegalStateException("Task wurde nicht gefunden");
        }
    }

    //create
    public void postTask(Task task) {
        if (    task.getTaskTitel().isEmpty() ||
                task.getTaskDate() == null ||
                task.getUserId() <= 0
        ) {
            throw new IllegalStateException("TaskTitel cannot be empty. TaskDate needs to be valid. UserId needs to be greater then 0.");
        }
        else{
            taskRepo.save(task);
        }
    }


}
