package com.airtribe.learnTrack.service;

import com.airtribe.learnTrack.entity.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseService {

    private List<Course> courseList = new ArrayList<>();

    public void addCourse(Course course) {
        courseList.add(course);
    }

    public void removeCourse(int courseId) {
        for (Course course : courseList) {
            if (course.getId() == courseId) {
                courseList.remove(course);
                System.out.println("Course removed: " + course.getCourseName());
                return;
            }
        }
        System.out.println("Course not found");
    }

    public void updateCourse(int id, boolean isActive) {
        for (Course course : courseList) {
            if (course.getId() == id) {
                course.setActive(isActive);
                System.out.println(" updated Course to "+ (isActive ? "active" : "inactive") + ": " + course.getCourseName());
                return;
            }
        }
        System.out.println("Course not found.");
    }

    public void displayCourseList() {
        if (courseList.isEmpty()) {
            System.out.println("No courses found.");
            return;
        }
        System.out.println("All Courses:");
        for (Course course : courseList) {
            System.out.println("ID: " + course.getId() + ", Name: " + course.getCourseName() + "Description: "+ course.getDescription() +", Duration: " + course.getDurationInWeeks() + ", Active: " + course.isActive());
        }
    }
}
