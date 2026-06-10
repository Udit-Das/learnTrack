package com.airtribe.learnTrack.util;

public class idGenerator {
    private static int studentIdCounter = 1;
    private static int courseIdCounter = 1;

    public static int getNextStudentId() {
        return studentIdCounter++;
    }

    public static int getNextCourseId() {
        return courseIdCounter++;
    }

}
