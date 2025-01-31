package com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.dataTransfer;

public class DisposalGuidelineDTO {

    private Integer disposalGuidelineId;
    private Integer wasteCategoryId; // Reference to WasteCategory
    private String name;
    private String description;

    // Getters and Setters

    public Integer getDisposalGuidelineId() {
        return disposalGuidelineId;
    }

    public void setDisposalGuidelineId(Integer disposalGuidelineId) {
        this.disposalGuidelineId = disposalGuidelineId;
    }

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
}
