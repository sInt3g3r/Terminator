package ch.bbzw.terminator.service;

import ch.bbzw.terminator.model.Task;
import ch.bbzw.terminator.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class TaskService {

    private final TaskRepo taskRepo;

    @Autowired
    public TaskService(final TaskRepo _taskRepo) {
        this.taskRepo = _taskRepo;
    }

    @Transactional(readOnly = true)
    public List<Task> getAll() {
        final Iterable<Task> tasks = taskRepo.findAll();
        return StreamSupport
                .stream(tasks.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Transactional
    public Task add(final Task _task) {
        return taskRepo.save(_task);
    }

    //@Caching(evict = {@CacheEvict(key = "#id"), @CacheEvict(key = "0")})
    public void delete(final long _id) {
        taskRepo.deleteById(_id);
    }

    //@CacheEvict(allEntries = true)
    public void deleteAll() {
        taskRepo.deleteAll(taskRepo.findAll());
    }

    @Transactional(readOnly = true)
    //@Cacheable(key = "#id", unless = "#result == null")
    public Optional<Task> get(final long _id) {
        return Optional.ofNullable(taskRepo.findById(_id));
    }
}