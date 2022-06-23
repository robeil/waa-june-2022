package com.example.labphaseiii.service;

import com.example.labphaseiii.dto.StudentDTO;
import com.example.labphaseiii.entity.Course;
import com.example.labphaseiii.entity.Student;

import java.util.List;


public interface StudentService {

    List<StudentDTO> getStudentsByMajor(String major);
    //void save(Student student);

}
