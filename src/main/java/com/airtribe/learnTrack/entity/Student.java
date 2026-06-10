package com.airtribe.learnTrack.entity;

public class Student extends Person{
    private String batch;
    private boolean isActive;

    public Student(String firstName, String lastName, String email, String batch, boolean isActive) {
        super(firstName, lastName, email);
        this.batch = batch;
        this.isActive = isActive;
    }

    public Student(String firstName, String lastName, String batch, boolean isActive) {
        super(firstName, lastName);
        this.batch = batch;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
    @Override
    public void getDisplayName() {
        System.out.println("Student Name: " + getFirstName() + " " + getLastName());
    }
}
