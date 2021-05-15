package ch.bbzw.terminator.service;

import ch.bbzw.terminator.model.Task;
import ch.bbzw.terminator.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
