package ru.itis.akvelonitispractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.akvelonitispractice.DTO.ProjectDto;
import ru.itis.akvelonitispractice.service.ProjectService;

@RestController
@RequestMapping(value = "/api/v1")
public class ProjectController {


    @Autowired
    private ProjectService projectService;

    @PostMapping(value = "/project/create")
    public ResponseEntity<String> createProject(@RequestBody ProjectDto projectDto) {
        System.out.println(projectDto);
        return ResponseEntity.ok().build();
    }

    
}
