package ch.bbzw.terminator.controller;

import ch.bbzw.terminator.model.Task;
import ch.bbzw.terminator.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api")
public class TaskController {

    private final TaskService taskService;

    @Autowired //TaskService wird instanziert und diesem Konstruktor übergeben (injected)
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(path = "getTasks") //wird ausgeführt wenn /api/task aufgerufen wird
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @PostMapping(path = "newTask")
    public void newTask(@RequestBody Task task) {
        taskService.newTask(task);
    }

    @DeleteMapping(path = "delTask/{id}")
    public void delTask(@PathVariable("id") Long id) {
        taskService.delTask(id);
    }

}
