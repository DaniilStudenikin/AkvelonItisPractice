package ru.itis.akvelonitispractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.akvelonitispractice.DTO.ProjectCreateDto;
import ru.itis.akvelonitispractice.DTO.ProjectUpdateDto;
import ru.itis.akvelonitispractice.models.Project;
import ru.itis.akvelonitispractice.service.ProjectService;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping(value = "/api/v1")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping(value = "/projects", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createProject(@Valid @RequestBody ProjectCreateDto createDto) {
        projectService.createProject(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/projects/{project_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Project> getProject(@PathVariable(name = "project_id") Long projectId) {
        return ResponseEntity.ok(projectService.getProject(projectId));
    }

    @PutMapping(value = "/projects/{project_id}")
    public ResponseEntity<String> updateProject(@NotBlank @PathVariable(name = "project_id") Long projectId, @Valid @RequestBody ProjectUpdateDto updateDto) {
        projectService.updateProject(projectId, updateDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/projects/{project_id}")
    public ResponseEntity<String> deleteProject(@PathVariable(name = "project_id") Long projectId) {
        projectService.deleteProject(projectId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
