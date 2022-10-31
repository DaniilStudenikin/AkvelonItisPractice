package ru.itis.akvelonitispractice.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.akvelonitispractice.models.enums.TaskStatus;

import javax.validation.constraints.PositiveOrZero;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskUpdateDto {

    private String name;

    private String description;

    private TaskStatus status;

    @PositiveOrZero
    private Integer priority;
}
