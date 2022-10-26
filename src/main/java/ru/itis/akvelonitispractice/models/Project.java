package ru.itis.akvelonitispractice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectName;

    private LocalDateTime projectStartDateTime;

    private LocalDateTime projectCompletionDateTime;

    private ProjectStatus projectStatus;

    private Integer projectPriority;

    @OneToMany
    private List<Task> projectTasks;

    public enum ProjectStatus {
        NotStarted, Active, Completed
    }
}
