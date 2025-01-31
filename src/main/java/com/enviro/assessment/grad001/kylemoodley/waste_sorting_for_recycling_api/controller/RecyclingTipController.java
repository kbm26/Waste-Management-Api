package com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.controller;

import com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.dataTransfer.RecyclingTipDTO;
import com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.service.RecyclingTipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipController {

    @Autowired
    private RecyclingTipService recyclingTipService;

    @PostMapping
    public ResponseEntity<RecyclingTipDTO> createRecyclingTip(@RequestBody RecyclingTipDTO recyclingTipDTO) {
        RecyclingTipDTO createdRecyclingTip = recyclingTipService.createRecyclingTip(recyclingTipDTO);
        return new ResponseEntity<>(createdRecyclingTip, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RecyclingTipDTO>> getAllRecyclingTips() {
        List<RecyclingTipDTO> recyclingTips = recyclingTipService.getAllRecyclingTips();
        return new ResponseEntity<>(recyclingTips, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTipDTO> getRecyclingTipById(@PathVariable Integer id) {
        RecyclingTipDTO recyclingTipDTO = recyclingTipService.getRecyclingTipById(id);
        return recyclingTipDTO != null ?
                new ResponseEntity<>(recyclingTipDTO, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTipDTO> updateRecyclingTip(@PathVariable Integer id, @RequestBody RecyclingTipDTO recyclingTipDTO) {
        RecyclingTipDTO updatedRecyclingTip = recyclingTipService.updateRecyclingTip(id, recyclingTipDTO);
        return updatedRecyclingTip != null ?
                new ResponseEntity<>(updatedRecyclingTip, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecyclingTip(@PathVariable Integer id) {
        boolean deleted = recyclingTipService.deleteRecyclingTip(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}