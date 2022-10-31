package ru.itis.akvelonitispractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.akvelonitispractice.DTO.TaskCreateDto;
import ru.itis.akvelonitispractice.DTO.TaskUpdateDto;
import ru.itis.akvelonitispractice.models.Task;
import ru.itis.akvelonitispractice.service.TaskService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping(value = "/task/create/{projectId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createTask(@PathVariable(name = "projectId") Long projectId, @Valid @RequestBody TaskCreateDto taskCreateDto) {
        taskService.createTask(projectId, taskCreateDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/task/{task_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> getTask(@PathVariable(name = "task_id") Long taskId) {
        return ResponseEntity.ok(taskService.getTask(taskId));
    }

    @PutMapping(value = "/task/update/{task_id}")
    public ResponseEntity<String> updateTask(@PathVariable(name = "task_id") Long taskId, @Valid @RequestBody TaskUpdateDto taskUpdateDto) {
        taskService.updateTask(taskId, taskUpdateDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/task/delete/{task_id}")
    public ResponseEntity<String> deleteTask(@PathVariable(name = "task_id") Long taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(value = "/tasks/{project_id}")
    public ResponseEntity<List<Task>> getAllTasks(@PathVariable(name = "project_id") Long projectId) {
        return ResponseEntity.ok(taskService.getAllTasks(projectId));
    }
}
