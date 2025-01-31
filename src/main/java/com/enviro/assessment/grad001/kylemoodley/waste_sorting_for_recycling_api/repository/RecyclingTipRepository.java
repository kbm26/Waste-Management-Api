package com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.repository;
import com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.model.RecyclingTip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecyclingTipRepository extends  JpaRepository<RecyclingTip, Integer> {
    // Custom queries can be added here, for example:
    // Optional<RecyclingTip> findByName(String name);
}
