package com.nguyenduc.guideline.service;

import com.nguyenduc.guideline.client.TaskClient;
import com.nguyenduc.guideline.dto.GuidelineResponse;
import com.nguyenduc.guideline.dto.TaskDto;
import com.nguyenduc.guideline.entity.Guideline;
import com.nguyenduc.guideline.repository.GuidelineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuidelineService {

    private final GuidelineRepository repository;

    private final TaskClient taskClient;

    public void save(Guideline guideline) {
        repository.save(guideline);
    }

    public List<Guideline> findAll() {
        return repository.findAll();
    }

    public GuidelineResponse findWithTasks(String id) {
        Guideline guideline = repository.findById(id).orElse(new Guideline(null, "NOT_FOUND", "NOT_FOUND"));
        List<TaskDto> taskDtos = taskClient.findByGuidelineId(id);

        return GuidelineResponse.builder()
                .id(guideline.getId())
                .name(guideline.getName())
                .description(guideline.getDescription())
                .tasks(taskDtos)
                .build();
    }
}
