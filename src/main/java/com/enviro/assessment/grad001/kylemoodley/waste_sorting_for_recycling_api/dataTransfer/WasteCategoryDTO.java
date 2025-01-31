package com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.dataTransfer;

public class WasteCategoryDTO {

    private Integer wasteCategoryId;
    private String name;
    private String description;

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
