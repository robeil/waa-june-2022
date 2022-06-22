package com.example.lab2phaseii.service;

import com.example.lab2phaseii.lab2_phaseII.entity.Student;

import java.util.List;


public interface StudentService {

    List<Student> getStudentsByMajor(String major);

}
