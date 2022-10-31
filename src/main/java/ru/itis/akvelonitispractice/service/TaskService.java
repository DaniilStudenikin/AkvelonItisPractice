package ru.itis.akvelonitispractice.service;

import ru.itis.akvelonitispractice.DTO.TaskCreateDto;
import ru.itis.akvelonitispractice.DTO.TaskUpdateDto;
import ru.itis.akvelonitispractice.models.Task;

import java.util.List;

public interface TaskService {

    void createTask(Long projectId, TaskCreateDto taskCreateDto);

    Task getTask(Long id);

    void updateTask(Long id, TaskUpdateDto taskUpdateDto);

    void deleteTask(Long id);

    List<Task> getAllTasks(Long projectId);
}
