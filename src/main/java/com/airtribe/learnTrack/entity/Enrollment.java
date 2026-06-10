package com.airtribe.learnTrack.entity;

public class Enrollment {
    //Fields: id, studentId, courseId, enrollmentDate, status (e.g., "ACTIVE", "COMPLETED", "CANCELLED" as String or simple enum if you want slightly advanced)
    private static int idCounter = 1; // Static counter to generate unique IDs
    private int id;
    private int studentId;
    private int courseId;
    private String enrollmentDate; // Consider using LocalDate for better date handling

    private static enrollmentStatus status;
    public enum enrollmentStatus{
        ACTIVE,
        COMPLETED,
        CANCELLED
    }

    public Enrollment(int studentId, int courseId, String enrollmentDate, enrollmentStatus status) {
        this.id = idCounter++; // Assign a unique ID and increment the counter
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public enrollmentStatus getStatus() {
        return status;
    }

    public void setStatus(enrollmentStatus status) {
        this.status = status;
    }
}
