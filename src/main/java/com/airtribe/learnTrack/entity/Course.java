package com.airtribe.learnTrack.entity;

import com.airtribe.learnTrack.util.idGenerator;

public class Course {
    private int id;
    private String courseName;
    private String description;
    private String durationInWeeks;
    private boolean isActive;

    public Course(String courseName, String description, String durationInWeeks, boolean isActive) {
        this.id = idGenerator.getNextCourseId();
        this.courseName = courseName;
        this.description = description;
        this.durationInWeeks = durationInWeeks;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDurationInWeeks() {
        return durationInWeeks;
    }

    public void setDurationInWeeks(String durationInWeeks) {
        this.durationInWeeks = durationInWeeks;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
