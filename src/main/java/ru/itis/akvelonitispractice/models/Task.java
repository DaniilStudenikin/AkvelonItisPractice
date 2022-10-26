package ru.itis.akvelonitispractice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String taskName;

    private String taskDescription;

    private TaskStatus taskStatus;

    private Integer priority;
    @OneToOne
    private Project project;

    private enum TaskStatus {
        ToDo, InProgress, Done
    }
}
