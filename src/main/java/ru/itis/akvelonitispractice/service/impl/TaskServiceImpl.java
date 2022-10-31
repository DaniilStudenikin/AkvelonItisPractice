package ru.itis.akvelonitispractice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.akvelonitispractice.DTO.TaskCreateDto;
import ru.itis.akvelonitispractice.DTO.TaskUpdateDto;
import ru.itis.akvelonitispractice.exceptions.ProjectNotFoundException;
import ru.itis.akvelonitispractice.exceptions.TaskNotFoundException;
import ru.itis.akvelonitispractice.models.Project;
import ru.itis.akvelonitispractice.models.Task;
import ru.itis.akvelonitispractice.models.enums.TaskStatus;
import ru.itis.akvelonitispractice.repository.ProjectRepository;
import ru.itis.akvelonitispractice.repository.TaskRepository;
import ru.itis.akvelonitispractice.service.TaskService;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void createTask(Long projectId, TaskCreateDto taskCreateDto) {
        Project project = projectRepository.findById(projectId).orElseThrow(ProjectNotFoundException::new);
        Task task = Task.builder()
                .name(taskCreateDto.getName())
                .status(TaskStatus.ToDo)
                .description(taskCreateDto.getDescription())
                .priority(taskCreateDto.getPriority())
                .project(project)
                .build();
        project.getTasks().add(task);
        taskRepository.save(task);
        projectRepository.save(project);

    }

    @Override
    public Task getTask(Long id) {
        return taskRepository.findById(id).orElseThrow(TaskNotFoundException::new);
    }

    @Override
    public void updateTask(Long taskId, TaskUpdateDto taskUpdateDto) {
        Task taskfromDb = taskRepository.findById(taskId).orElseThrow(TaskNotFoundException::new);
        if (taskUpdateDto.getStatus() != null) {
            taskfromDb.setStatus(taskUpdateDto.getStatus());
        }
        if (taskUpdateDto.getName() != null) {
            taskfromDb.setName(taskUpdateDto.getName());
        }
        if (taskUpdateDto.getDescription() != null) {
            taskfromDb.setDescription(taskUpdateDto.getDescription());
        }

        if (taskUpdateDto.getPriority() != null) {
            taskfromDb.setPriority(taskUpdateDto.getPriority());
        }
        taskRepository.save(taskfromDb);
    }

    @Override
    public void deleteTask(Long id) {

    }

    @Override
    public List<Task> getAllTasks(Long projectId) {
        return projectRepository.findById(projectId).orElseThrow(TaskNotFoundException::new).getTasks();
    }

}
