package com.nguyenduc.task.service;

import com.nguyenduc.task.entity.Task;
import com.nguyenduc.task.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repository;

    public void save(Task task) {
        repository.save(task);
    }

    public List<Task> findAll() {
        return repository.findAll();
    }

    public List<Task> findByGuidelineId(String guidelineId) {
        return repository.findAllByGuidelineId(guidelineId);
    }
}
