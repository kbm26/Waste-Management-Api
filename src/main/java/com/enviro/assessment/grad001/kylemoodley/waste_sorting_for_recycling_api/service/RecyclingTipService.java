package com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.service;

import com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.dataTransfer.RecyclingTipDTO;
import com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.model.RecyclingTip;
import com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.model.WasteCategory;
import com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.repository.RecyclingTipRepository;
import com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecyclingTipService {

    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    @Autowired
    private RecyclingTipRepository recyclingTipRepository;

    public RecyclingTipDTO createRecyclingTip(RecyclingTipDTO recyclingTipDTO) {
        Optional<WasteCategory> wasteCategoryOpt = wasteCategoryRepository.findById(recyclingTipDTO.getWasteCategoryId());
        if (wasteCategoryOpt.isPresent()) {
            WasteCategory wasteCategory = wasteCategoryOpt.get();
            RecyclingTip recyclingTip = new RecyclingTip();
            recyclingTip.setWasteCategory(wasteCategory);
            recyclingTip.setName(recyclingTipDTO.getName());
            recyclingTip.setDescription(recyclingTipDTO.getDescription());

            RecyclingTip savedRecyclingTip = recyclingTipRepository.save(recyclingTip);
            return convertToDTO(savedRecyclingTip);
        }
        return null;
    }

    public List<RecyclingTipDTO> getAllRecyclingTips() {
        List<RecyclingTip> recyclingTips = recyclingTipRepository.findAll();
        return recyclingTips.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public RecyclingTipDTO getRecyclingTipById(Integer id) {
        Optional<RecyclingTip> recyclingTipOpt = recyclingTipRepository.findById(id);
        return recyclingTipOpt.map(this::convertToDTO).orElse(null);
    }

    public RecyclingTipDTO updateRecyclingTip(Integer id, RecyclingTipDTO recyclingTipDTO) {
        Optional<RecyclingTip> recyclingTipOpt = recyclingTipRepository.findById(id);
        Optional<WasteCategory> wasteCategoryOpt = wasteCategoryRepository.findById(recyclingTipDTO.getWasteCategoryId());
        if (recyclingTipOpt.isPresent() && wasteCategoryOpt.isPresent()) {
            WasteCategory wasteCategory = wasteCategoryOpt.get();
            RecyclingTip recyclingTip = recyclingTipOpt.get();
            recyclingTip.setWasteCategory(wasteCategory);
            recyclingTip.setName(recyclingTipDTO.getName());
            recyclingTip.setDescription(recyclingTipDTO.getDescription());

            RecyclingTip updatedRecyclingTip = recyclingTipRepository.save(recyclingTip);
            return convertToDTO(updatedRecyclingTip);
        }
        return null;
    }

    public boolean deleteRecyclingTip(Integer id) {
        Optional<RecyclingTip> recyclingTipOpt = recyclingTipRepository.findById(id);
        if (recyclingTipOpt.isPresent()) {
            recyclingTipRepository.delete(recyclingTipOpt.get());
            return true;
        }
        return false;
    }

    private RecyclingTipDTO convertToDTO(RecyclingTip recyclingTip) {
        RecyclingTipDTO recyclingTipDTO = new RecyclingTipDTO();
        recyclingTipDTO.setRecyclingTipId(recyclingTip.getRecyclingTipId());
        recyclingTipDTO.setWasteCategoryId(recyclingTip.getWasteCategory().getWasteCategoryId());
        recyclingTipDTO.setName(recyclingTip.getName());
        recyclingTipDTO.setDescription(recyclingTip.getDescription());
        return recyclingTipDTO;
    }
}
