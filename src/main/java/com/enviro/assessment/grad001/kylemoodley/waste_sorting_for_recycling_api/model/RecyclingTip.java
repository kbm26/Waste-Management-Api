package com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "RecyclingTips")
public class RecyclingTip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RecyclingTipId")
    private Integer recyclingTipId;

    @ManyToOne
    @JoinColumn(name = "WasteCategoryId", nullable = false)
    private WasteCategory wasteCategory;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Description", nullable = false)
    private String description;

    public Integer getRecyclingTipId() {
        return recyclingTipId;
    }

    public void setRecyclingTipId(Integer recyclingTipId) {
        this.recyclingTipId = recyclingTipId;
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
