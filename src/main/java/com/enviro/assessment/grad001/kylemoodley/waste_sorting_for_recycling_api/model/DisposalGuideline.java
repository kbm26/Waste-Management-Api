package com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "DisposalGuidelines")
public class DisposalGuideline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DisposalGuidelineId")
    private Integer disposalGuidelineId;

    @ManyToOne
    @JoinColumn(name = "WasteCategoryId", nullable = false)
    private WasteCategory wasteCategory;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Description", nullable = false)
    private String description;

    // Getters and Setters

    public Integer getDisposalGuidelineId() {
        return disposalGuidelineId;
    }

    public void setDisposalGuidelineId(Integer disposalGuidelineId) {
        this.disposalGuidelineId = disposalGuidelineId;
    }

    public WasteCategory getWasteCategory() {
        return wasteCategory;
    }

    public void setWasteCategory(WasteCategory wasteCategory) {
        this.wasteCategory = wasteCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}