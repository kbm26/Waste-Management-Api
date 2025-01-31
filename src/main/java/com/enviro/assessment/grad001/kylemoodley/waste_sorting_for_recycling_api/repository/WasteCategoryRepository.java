package com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.repository;

import com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Integer> {
    // Custom queries can be added here
}