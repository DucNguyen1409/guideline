package com.nguyenduc.guideline.repository;

import com.nguyenduc.guideline.entity.Guideline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuidelineRepository extends JpaRepository<Guideline, String> {
}
