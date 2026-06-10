package com.airtribe.learnTrack.service;

import com.airtribe.learnTrack.entity.Enrollment;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentService {
    private final List<Enrollment> enrollments = new ArrayList<>();

    public void enrollStudent(int studentId, int courseId, String enrollmentDate) {
        Enrollment enrollment = new Enrollment(studentId, courseId, enrollmentDate, Enrollment.enrollmentStatus.ACTIVE);
        enrollments.add(enrollment);
        System.out.println("Student with ID " + studentId + " enrolled in course " + courseId);
    }

    // Remove an enrollment
    public void removeEnrollment(int studentId, int courseId) {
        boolean removed = enrollments.removeIf(enrollment ->
                enrollment.getStudentId() == studentId && enrollment.getCourseId() == courseId);
        if (removed) {
            System.out.println("Enrollment removed for student ID " + studentId + " and course ID " + courseId);
        } else {
            System.out.println("Enrollment not found for student ID " + studentId + " and course ID " + courseId);
        }
    }

    // List all enrollments
    public void listEnrollments() {
        if (enrollments.isEmpty()) {
            System.out.println("No enrollments found.");
        } else {
            System.out.println("All Enrollments:");
            for (Enrollment enrollment : enrollments) {
                System.out.println("Student ID: " + enrollment.getStudentId() + ", Course ID: " + enrollment.getCourseId());
            }
        }
    }

    public void viewEnrollmentsForStudent(int viewEnrollmentsStudentId) {
        System.out.println("Enrollments for Student ID " + viewEnrollmentsStudentId + ":");
        boolean found = false;
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudentId() == viewEnrollmentsStudentId) {
                System.out.println("Course ID: " + enrollment.getCourseId() + ", Status: " + enrollment.getStatus());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No enrollments found for student ID " + viewEnrollmentsStudentId);
        }
    }

    public void updateEnrollmentStatus(int id, Enrollment.enrollmentStatus newStatus) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getId() == id) {
                enrollment.setStatus(newStatus);
                System.out.println("Enrollment ID " + id + " status updated to " + newStatus);
                return;
            }
        }
        System.out.println("Enrollment not found with ID " + id);
    }
}
