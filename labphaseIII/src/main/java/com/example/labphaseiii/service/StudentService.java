package com.example.labphaseiii.service;

import com.example.labphaseiii.entity.Course;
import com.example.labphaseiii.entity.Student;

import java.util.List;


public interface StudentService {

    List<Student> getStudentsByMajor(String major);
    //void save(Student student);

}
