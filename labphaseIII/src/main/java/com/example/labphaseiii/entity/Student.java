package com.example.labphaseiii.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<Course> courses;
    private double gpa;


}
