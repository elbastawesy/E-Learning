package com.three2one.assessment.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "course")
public class Course extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Course's name can't by empty")
    @Valid
    private String name;

    private String description;

    @NotNull(message = "Course's publishDate can't by empty")
    @Valid
    @Column(name = "publish_date")
    private LocalDate publishDate;

    @Column(name = "last_updated")
    private LocalDate lastUpdated;

    @Column(name = "total_hours")
    private Long totalHours;

    @NotNull(message = "Course's instructor can't by empty")
    @Valid
    private String instructor;

    public Course() {
    }

    public Course(@NotNull(message = "Course's name can't by empty") @Valid String name,
                  String description,
                  @NotNull(message = "Course's publishDate can't by empty") @Valid LocalDate publishDate,
                  LocalDate lastUpdated, Long totalHours,
                  @NotNull(message = "Course's instructor can't by empty") @Valid String instructor) {
        this.setName(name);
        this.setDescription(description);
        this.setPublishDate(publishDate);
        this.setLastUpdated(lastUpdated);
        this.setTotalHours(totalHours);
        this.setInstructor(instructor);
    }

    @PrePersist
    public void validatePrePersist() {
        super.validatePrePersist();
    }

    @PreUpdate
    public void validatePreUpdate() {
        super.validatePreUpdate();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Long getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(Long totalHours) {
        this.totalHours = totalHours;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
}
