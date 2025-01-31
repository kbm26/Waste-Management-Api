package com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.controller;

import com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.dataTransfer.DisposalGuidelineDTO;
import com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.service.DisposalGuidelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelineController {

    @Autowired
    private DisposalGuidelineService disposalGuidelineService;

    @PostMapping
    public ResponseEntity<DisposalGuidelineDTO> createDisposalGuideline(@RequestBody DisposalGuidelineDTO disposalGuidelineDTO) {
        DisposalGuidelineDTO createdDisposalGuideline = disposalGuidelineService.createDisposalGuideline(disposalGuidelineDTO);
        return new ResponseEntity<>(createdDisposalGuideline, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DisposalGuidelineDTO>> getAllDisposalGuidelines() {
        List<DisposalGuidelineDTO> disposalGuidelines = disposalGuidelineService.getAllDisposalGuidelines();
        return new ResponseEntity<>(disposalGuidelines, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuidelineDTO> getDisposalGuidelineById(@PathVariable Integer id) {
        DisposalGuidelineDTO disposalGuidelineDTO = disposalGuidelineService.getDisposalGuidelineById(id);
        return disposalGuidelineDTO != null ?
                new ResponseEntity<>(disposalGuidelineDTO, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuidelineDTO> updateDisposalGuideline(@PathVariable Integer id, @RequestBody DisposalGuidelineDTO disposalGuidelineDTO) {
        DisposalGuidelineDTO updatedDisposalGuideline = disposalGuidelineService.updateDisposalGuideline(id, disposalGuidelineDTO);
        return updatedDisposalGuideline != null ?
                new ResponseEntity<>(updatedDisposalGuideline, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisposalGuideline(@PathVariable Integer id) {
        boolean deleted = disposalGuidelineService.deleteDisposalGuideline(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}