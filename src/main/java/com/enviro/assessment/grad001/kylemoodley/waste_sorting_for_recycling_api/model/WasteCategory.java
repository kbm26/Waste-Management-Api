package com.enviro.assessment.grad001.kylemoodley.waste_sorting_for_recycling_api.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "waste_categories")
public class WasteCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "waste_category_id")
    private Integer wasteCategoryId;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    public Integer getWasteCategoryId() {
        return wasteCategoryId;
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