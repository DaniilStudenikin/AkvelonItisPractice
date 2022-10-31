package ru.itis.akvelonitispractice.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.akvelonitispractice.models.enums.ProjectStatus;

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

    private String name;

    private LocalDateTime start;

    private LocalDateTime completion;

    @Enumerated(value = EnumType.STRING)
    private ProjectStatus status;

    private Integer priority;

    @OneToMany(mappedBy = "project")
    @JsonManagedReference
    private List<Task> tasks;

}
