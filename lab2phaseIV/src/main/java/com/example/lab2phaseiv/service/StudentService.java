package com.example.lab2phaseiv.service;

import com.example.lab2phaseiv.dto.StudentDTO;
import com.example.lab2phaseiv.entity.Student;

import java.util.List;


public interface StudentService {

    List<StudentDTO> getStudentsByMajor(String major);
    //void save(Student student);

}
