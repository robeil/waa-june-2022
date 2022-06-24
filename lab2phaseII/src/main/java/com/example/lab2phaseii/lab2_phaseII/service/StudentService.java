package com.example.lab2phaseii.lab2_phaseII.service;

import com.example.lab2phaseii.lab2_phaseII.dto.CourseDTO;
import com.example.lab2phaseii.lab2_phaseII.dto.StudentDTO;
import com.example.lab2phaseii.lab2_phaseII.entity.Student;

import java.util.List;


public interface StudentService {

    List<StudentDTO> getStudentsByMajor(String major);
    List<CourseDTO> getCoursesBySudentId(int studentId);

}
