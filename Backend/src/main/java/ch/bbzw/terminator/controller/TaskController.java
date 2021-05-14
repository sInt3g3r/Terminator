package ch.bbzw.terminator.controller;

import ch.bbzw.terminator.model.Task;
import ch.bbzw.terminator.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/tasks")
//@PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(final TaskService _taskService) {
        this.taskService = _taskService;
    }

    @GetMapping("/")
    public List<Task> getAll() {
        return taskService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Task> get(@PathVariable final long _id) {
        return taskService.get(_id);
    }

    @PostMapping("/")
    public Task add(@RequestBody final Task _task) {
        return taskService.add(_task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable final long _id) {
        taskService.delete(_id);
    }

    @DeleteMapping("/")
    public void deleteAll() {
        taskService.deleteAll();
    }
}