package com.nguyenduc.guideline.controller;

import com.nguyenduc.guideline.dto.GuidelineResponse;
import com.nguyenduc.guideline.entity.Guideline;
import com.nguyenduc.guideline.service.GuidelineService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/guidelines")
@RequiredArgsConstructor
public class GuidelineRest {

    private final GuidelineService guidelineService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Guideline guideline) {
        log.info("[GuidelineRest] save: {}", guideline);
        guidelineService.save(guideline);
    }

    @GetMapping
    public ResponseEntity<List<Guideline>> findAll() {
        log.info("[GuidelineRest] findAll");
        return ResponseEntity.ok(guidelineService.findAll());
    }

    @GetMapping("/with-tasks/{guideline-id}")
    public ResponseEntity<GuidelineResponse> findGuidelineWithTask(
            @PathVariable("guideline-id") String guidelineId) {
        log.info("[GuidelineRest] findGuidelineWithTask: {}", guidelineId);
        return ResponseEntity.ok(guidelineService.findWithTasks(guidelineId));
    }
}
