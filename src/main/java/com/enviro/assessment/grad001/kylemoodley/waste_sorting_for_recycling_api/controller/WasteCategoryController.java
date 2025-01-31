package com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.controller;

import com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.dataTransfer.WasteCategoryDTO;
import com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.service.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {

    @Autowired
    private WasteCategoryService wasteCategoryService;

    // Create a new WasteCategory
    @PostMapping
    public ResponseEntity<WasteCategoryDTO> createWasteCategory(@RequestBody WasteCategoryDTO wasteCategoryDTO) {
        WasteCategoryDTO createdWasteCategory = wasteCategoryService.createWasteCategory(wasteCategoryDTO);
        return new ResponseEntity<>(createdWasteCategory, HttpStatus.CREATED);
    }

    // Get all WasteCategories
    @GetMapping
    public ResponseEntity<List<WasteCategoryDTO>> getAllWasteCategories() {
        List<WasteCategoryDTO> wasteCategories = wasteCategoryService.getAllWasteCategories();
        return new ResponseEntity<>(wasteCategories, HttpStatus.OK);
    }

    // Get a specific WasteCategory by ID
    @GetMapping("/{id}")
    public ResponseEntity<WasteCategoryDTO> getWasteCategoryById(@PathVariable Integer id) {
        WasteCategoryDTO wasteCategoryDTO = wasteCategoryService.getWasteCategoryById(id);
        return wasteCategoryDTO != null ?
                new ResponseEntity<>(wasteCategoryDTO, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Update a WasteCategory
    @PutMapping("/{id}")
    public ResponseEntity<WasteCategoryDTO> updateWasteCategory(@PathVariable Integer id, @RequestBody WasteCategoryDTO wasteCategoryDTO) {
        WasteCategoryDTO updatedWasteCategory = wasteCategoryService.updateWasteCategory(id, wasteCategoryDTO);
        return updatedWasteCategory != null ?
                new ResponseEntity<>(updatedWasteCategory, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete a WasteCategory
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWasteCategory(@PathVariable Integer id) {
        boolean deleted = wasteCategoryService.deleteWasteCategory(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}