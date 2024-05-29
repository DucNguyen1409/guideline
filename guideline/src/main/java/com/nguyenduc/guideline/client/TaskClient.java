package com.nguyenduc.guideline.client;

import com.nguyenduc.guideline.dto.TaskDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "task-service", url = "${application.config.tasks-url}")
public interface TaskClient {
    @GetMapping("/guideline/{guideline-id}")
    List<TaskDto> findByGuidelineId(@PathVariable("guideline-id") String guidelineId);

}
