package com.airtribe.learnTrack.entity;

public class Trainer extends Person{
    private String firstName;
    private String lastName;
    private String expertise;

    public Trainer(String firstName, String lastName, String expertise) {
        super(firstName, lastName);
        this.expertise = expertise;
    }
}
