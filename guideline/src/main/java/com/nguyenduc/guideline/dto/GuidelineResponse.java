package com.nguyenduc.guideline.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GuidelineResponse {
    private String id;
    private String name;
    private String description;
    private List<TaskDto> tasks;
}
