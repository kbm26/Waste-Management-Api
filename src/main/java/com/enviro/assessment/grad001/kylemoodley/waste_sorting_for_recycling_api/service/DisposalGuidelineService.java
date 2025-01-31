package com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.service;

import com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.dataTransfer.DisposalGuidelineDTO;
import com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.model.DisposalGuideline;
import com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.model.WasteCategory;
import com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.repository.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DisposalGuidelineService {

    @Autowired
    private DisposalGuidelineRepository disposalGuidelineRepository;

    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    // Create a new DisposalGuideline
    public DisposalGuidelineDTO createDisposalGuideline(DisposalGuidelineDTO disposalGuidelineDTO) {
        Optional<WasteCategory> wasteCategoryOpt = wasteCategoryRepository.findById(disposalGuidelineDTO.getWasteCategoryId());
        if (wasteCategoryOpt.isPresent()) {
            WasteCategory wasteCategory = wasteCategoryOpt.get();
            DisposalGuideline disposalGuideline = new DisposalGuideline();
            disposalGuideline.setWasteCategory(wasteCategory);
            disposalGuideline.setName(disposalGuidelineDTO.getName());
            disposalGuideline.setDescription(disposalGuidelineDTO.getDescription());

            DisposalGuideline savedDisposalGuideline = disposalGuidelineRepository.save(disposalGuideline);
            return convertToDTO(savedDisposalGuideline);
        }
        return null;
    }

    // Get all DisposalGuidelines
    public List<DisposalGuidelineDTO> getAllDisposalGuidelines() {
        List<DisposalGuideline> disposalGuidelines = disposalGuidelineRepository.findAll();
        return disposalGuidelines.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get DisposalGuideline by ID
    public DisposalGuidelineDTO getDisposalGuidelineById(Integer id) {
        Optional<DisposalGuideline> disposalGuidelineOpt = disposalGuidelineRepository.findById(id);
        return disposalGuidelineOpt.map(this::convertToDTO).orElse(null);
    }

    // Update a DisposalGuideline
    public DisposalGuidelineDTO updateDisposalGuideline(Integer id, DisposalGuidelineDTO disposalGuidelineDTO) {
        Optional<DisposalGuideline> disposalGuidelineOpt = disposalGuidelineRepository.findById(id);
        Optional<WasteCategory> wasteCategoryOpt = wasteCategoryRepository.findById(disposalGuidelineDTO.getWasteCategoryId());
        if (disposalGuidelineOpt.isPresent() && wasteCategoryOpt.isPresent()) {
            WasteCategory wasteCategory = wasteCategoryOpt.get();
            DisposalGuideline disposalGuideline = disposalGuidelineOpt.get();
            disposalGuideline.setWasteCategory(wasteCategory);
            disposalGuideline.setName(disposalGuidelineDTO.getName());
            disposalGuideline.setDescription(disposalGuidelineDTO.getDescription());

            DisposalGuideline updatedDisposalGuideline = disposalGuidelineRepository.save(disposalGuideline);
            return convertToDTO(updatedDisposalGuideline);
        }
        return null;
    }

    // Delete a DisposalGuideline
    public boolean deleteDisposalGuideline(Integer id) {
        Optional<DisposalGuideline> disposalGuidelineOpt = disposalGuidelineRepository.findById(id);
        if (disposalGuidelineOpt.isPresent()) {
            disposalGuidelineRepository.delete(disposalGuidelineOpt.get());
            return true;
        }
        return false;
    }

    // Convert model to DTO
    private DisposalGuidelineDTO convertToDTO(DisposalGuideline disposalGuideline) {
        DisposalGuidelineDTO disposalGuidelineDTO = new DisposalGuidelineDTO();
        disposalGuidelineDTO.setDisposalGuidelineId(disposalGuideline.getDisposalGuidelineId());
        disposalGuidelineDTO.setWasteCategoryId(disposalGuideline.getWasteCategory().getWasteCategoryId());
        disposalGuidelineDTO.setName(disposalGuideline.getName());
        disposalGuidelineDTO.setDescription(disposalGuideline.getDescription());
        return disposalGuidelineDTO;
    }
}
