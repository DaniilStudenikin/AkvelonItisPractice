package ru.itis.akvelonitispractice.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class TaskCreateDto {
    @NotBlank
    private String name;

    private String description;

    private Integer priority;

}
