package ch.bbzw.terminator.service;

import ch.bbzw.terminator.model.Task;
import ch.bbzw.terminator.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Notwendig für @Autowired (bean)
public class TaskService {

    private final TaskRepo taskRepo;

    @Autowired
    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    public List<Task> getTasks() {
        return taskRepo.findAll();
    }

    public void postTask(Task task) {
        taskRepo.save(task);
    }

    public void delTask(Long id) {
        boolean exists = taskRepo.existsById(id);
        if (exists) {
            taskRepo.deleteById(id);
        }
        else {
            throw new IllegalStateException("Task wurde nicht gefunden");
        }
    }

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
}
