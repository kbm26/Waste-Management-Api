package com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.service;

import com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.dataTransfer.WasteCategoryDTO;
import com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.model.WasteCategory;
import com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WasteCategoryService {

    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    public WasteCategoryDTO createWasteCategory(WasteCategoryDTO wasteCategoryDTO) {
        WasteCategory wasteCategory = new WasteCategory();
        wasteCategory.setName(wasteCategoryDTO.getName());
        wasteCategory.setDescription(wasteCategoryDTO.getDescription());

        WasteCategory savedWasteCategory = wasteCategoryRepository.save(wasteCategory);
        return convertToDTO(savedWasteCategory);
    }

    public List<WasteCategoryDTO> getAllWasteCategories() {
        List<WasteCategory> wasteCategories = wasteCategoryRepository.findAll();
        return wasteCategories.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public WasteCategoryDTO getWasteCategoryById(Integer id) {
        Optional<WasteCategory> wasteCategoryOpt = wasteCategoryRepository.findById(id);
        return wasteCategoryOpt.map(this::convertToDTO).orElse(null);
    }

    public WasteCategoryDTO updateWasteCategory(Integer id, WasteCategoryDTO wasteCategoryDTO) {
        Optional<WasteCategory> wasteCategoryOpt = wasteCategoryRepository.findById(id);
        if (wasteCategoryOpt.isPresent()) {
            WasteCategory wasteCategory = wasteCategoryOpt.get();
            wasteCategory.setName(wasteCategoryDTO.getName());
            wasteCategory.setDescription(wasteCategoryDTO.getDescription());

            WasteCategory updatedWasteCategory = wasteCategoryRepository.save(wasteCategory);
            return convertToDTO(updatedWasteCategory);
        }
        return null;
    }

    public boolean deleteWasteCategory(Integer id) {
        Optional<WasteCategory> wasteCategoryOpt = wasteCategoryRepository.findById(id);
        if (wasteCategoryOpt.isPresent()) {
            wasteCategoryRepository.delete(wasteCategoryOpt.get());
            return true;
        }
        return false;
    }

    private WasteCategoryDTO convertToDTO(WasteCategory wasteCategory) {
        WasteCategoryDTO wasteCategoryDTO = new WasteCategoryDTO();
        wasteCategoryDTO.setWasteCategoryId(wasteCategory.getWasteCategoryId());
        wasteCategoryDTO.setName(wasteCategory.getName());
        wasteCategoryDTO.setDescription(wasteCategory.getDescription());
        return wasteCategoryDTO;
    }
}
