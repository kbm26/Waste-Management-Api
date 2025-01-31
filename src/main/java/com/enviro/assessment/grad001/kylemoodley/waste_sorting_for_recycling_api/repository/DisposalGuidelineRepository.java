package com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.repository;

import com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.model.DisposalGuideline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisposalGuidelineRepository extends JpaRepository<DisposalGuideline, Integer> {
    // Custom queries can be added here
}