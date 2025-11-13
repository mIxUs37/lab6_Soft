package com.example.lab6.lab6.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CoursesDto {
    private Long id;
    private String name;
    private String description;
}
