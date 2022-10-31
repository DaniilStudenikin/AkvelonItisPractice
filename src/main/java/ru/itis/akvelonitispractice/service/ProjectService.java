package ru.itis.akvelonitispractice.service;

import ru.itis.akvelonitispractice.DTO.ProjectCreateDto;
import ru.itis.akvelonitispractice.DTO.ProjectUpdateDto;
import ru.itis.akvelonitispractice.models.Project;


public interface ProjectService {
    void createProject(ProjectCreateDto createDto);

    Project getProject(Long id);

    void updateProject(Long id, ProjectUpdateDto updateDto);

    void deleteProject(Long id);
}
