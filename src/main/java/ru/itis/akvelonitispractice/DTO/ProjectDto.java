package ru.itis.akvelonitispractice.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectDto {
    @NotBlank(message = "Поле projectName не может быть пустым")
    private String projectName;

    @PositiveOrZero
    private Integer priority;
}
