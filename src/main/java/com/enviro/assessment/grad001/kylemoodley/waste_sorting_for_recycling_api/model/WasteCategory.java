package com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "WasteCategories")
public class WasteCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WasteCategoryId")
    private Integer wasteCategoryId;

    @Column(name = "Name", nullable = false, unique = true)
    private String name;

    @Column(name = "Description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "wasteCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DisposalGuideline> disposalGuidelines;

    @OneToMany(mappedBy = "wasteCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecyclingTip> recyclingTips;

    // Getters and Setters

    public Integer getWasteCategoryId() {
        return wasteCategoryId;
    }

    public void setWasteCategoryId(Integer wasteCategoryId) {
        this.wasteCategoryId = wasteCategoryId;
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

    public List<DisposalGuideline> getDisposalGuidelines() {
        return disposalGuidelines;
    }

    public void setDisposalGuidelines(List<DisposalGuideline> disposalGuidelines) {
        this.disposalGuidelines = disposalGuidelines;
    }

    public List<RecyclingTip> getRecyclingTips() {
        return recyclingTips;
    }

    public void setRecyclingTips(List<RecyclingTip> recyclingTips) {
        this.recyclingTips = recyclingTips;
    }
}