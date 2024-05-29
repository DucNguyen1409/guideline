package com.nguyenduc.task.controller;

import com.nguyenduc.task.entity.Task;
import com.nguyenduc.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskRest {

    private final TaskService taskService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Task task) {
        log.info("[TaskRest] save: {}", task);
        taskService.save(task);
    }

    @GetMapping
    public ResponseEntity<List<Task>> findAll() {
        log.info("[TaskRest] findAll");
        return ResponseEntity.ok(taskService.findAll());
    }

    @GetMapping("/guideline/{guideline-id}")
    public ResponseEntity<List<Task>> findByGuidelineId(@PathVariable("guideline-id") String guidelineId) {
        log.info("[TaskRest] findByGuidelineId: {}", guidelineId);
        return ResponseEntity.ok(taskService.findAll());
    }
}
