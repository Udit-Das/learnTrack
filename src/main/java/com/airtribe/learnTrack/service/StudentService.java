package com.airtribe.learnTrack.service;

import com.airtribe.learnTrack.entity.Student;
import com.airtribe.learnTrack.repository.StudentRepository;

import java.util.HashMap;
import java.util.Map;

public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student) {
        studentRepository.addStudent(student);
        System.out.println("Student added: " + student.getFirstName() + " " + student.getLastName());
    }

    public void removeStudent(int studentId) {
        Student student = studentRepository.getStudentById(studentId);
        if (student != null) {
            studentRepository.removeStudent(studentId);
            System.out.println("Student removed: " + student.getFirstName() + " " + student.getLastName());
        } else {
            System.out.println("Student not found");
        }
    }

    public void updateStudent(int id, String batch, boolean isActive) {
        Student student = studentRepository.getStudentById(id);
        if (student != null) {
            student.setBatch(batch);
            student.setActive(isActive);
            studentRepository.updateStudent(student);
            System.out.println("Student with ID " + id + " updated.");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public void listStudents() {
        Map<Integer, Student> students = studentRepository.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("All Students:");
            for (Student student : students.values()) {
                System.out.println("ID: " + student.getId() + ", Name: " + student.getFirstName() + " " + student.getLastName() + ", Batch: " + student.getBatch() + ", Active: " + student.isActive());
            }
        }
    }

    public Student getStudentById(int studentId) {
        return studentRepository.getStudentById(studentId);
    }
}
