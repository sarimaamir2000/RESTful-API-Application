package com.example.demo;

public class Doctor {
    private Long id;
    private String name;

    public Doctor() {
        // Default constructor
    }

    public Doctor(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter and Setter methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}