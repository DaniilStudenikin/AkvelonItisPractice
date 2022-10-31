package ru.itis.akvelonitispractice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.akvelonitispractice.DTO.ProjectCreateDto;
import ru.itis.akvelonitispractice.DTO.ProjectUpdateDto;
import ru.itis.akvelonitispractice.exceptions.ProjectNotFoundException;
import ru.itis.akvelonitispractice.models.Project;
import ru.itis.akvelonitispractice.models.enums.ProjectStatus;
import ru.itis.akvelonitispractice.repository.ProjectRepository;
import ru.itis.akvelonitispractice.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void createProject(ProjectCreateDto createDto) {
        Project project = Project.builder()
                .name(createDto.getName())
                .priority(createDto.getPriority())
                .start(createDto.getStart())
                .completion(createDto.getCompletion())
                .status(ProjectStatus.NotStarted)
                .build();
        projectRepository.save(project);
    }

    @Override
    public Project getProject(Long id) {
        return projectRepository.findById(id).orElseThrow(ProjectNotFoundException::new);
    }

    @Override
    public void updateProject(Long id, ProjectUpdateDto updateDto) {
        Project projectFromDb = projectRepository.findById(id).orElseThrow(ProjectNotFoundException::new);
        if (updateDto.getName() != null) {
            projectFromDb.setName(updateDto.getName());
        }
        if (updateDto.getPriority() != null) {
            projectFromDb.setPriority(updateDto.getPriority());
        }

        if (updateDto.getCompletion() != null) {
            projectFromDb.setCompletion(updateDto.getCompletion());
        }
        if (updateDto.getStatus() != null) {
            projectFromDb.setStatus(updateDto.getStatus());
        }
        projectRepository.save(projectFromDb);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
