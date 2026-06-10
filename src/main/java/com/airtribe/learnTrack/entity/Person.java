package com.airtribe.learnTrack.entity;

public class Person {
    protected static int idCounter = 1;
    protected int id;
    protected String firstName;
    protected String lastName;
    protected String email;

    public Person(String firstName, String lastName, String email) {
        this.id = idCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Person(String firstName, String lastName) {
        this.id = idCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void getDisplayName() {
        System.out.println("Person Name: " + firstName + " " + lastName);
    }

}
