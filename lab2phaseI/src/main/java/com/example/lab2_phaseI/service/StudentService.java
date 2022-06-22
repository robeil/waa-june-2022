package com.example.lab2_phaseI.service;

import com.example.lab2_phaseI.entity.Student;

import java.util.List;


public interface StudentService {

    List<Student> getStudentsByMajor(String major);

}
