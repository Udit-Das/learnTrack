package com.airtribe.learnTrack.repository;

import com.airtribe.learnTrack.entity.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentRepository {
    private Map<Integer, Student> studentMap = new HashMap<>();

    public void addStudent(Student student) {
        studentMap.put(student.getId(), student);
    }

    public Student getStudentById(int id) {
        return studentMap.get(id);
    }

    public void updateStudent(Student student) {
        studentMap.put(student.getId(), student);
    }

    public void removeStudent(int id) {
        studentMap.remove(id);
    }

    public Map<Integer, Student> getAllStudents() {
        return studentMap;
    }
}
