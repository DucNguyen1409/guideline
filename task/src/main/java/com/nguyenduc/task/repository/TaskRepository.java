package com.nguyenduc.task.repository;

import com.nguyenduc.task.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, String> {
    List<Task> findAllByGuidelineId(String guidelineId);
}
