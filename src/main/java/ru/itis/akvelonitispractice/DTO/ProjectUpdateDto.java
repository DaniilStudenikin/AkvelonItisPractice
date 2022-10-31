package ru.itis.akvelonitispractice.DTO;

import lombok.*;
import ru.itis.akvelonitispractice.models.enums.ProjectStatus;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectUpdateDto {

    private String name;

    @PositiveOrZero
    private Integer priority;

    @FutureOrPresent
    private LocalDateTime completion;

    private ProjectStatus status;
}
