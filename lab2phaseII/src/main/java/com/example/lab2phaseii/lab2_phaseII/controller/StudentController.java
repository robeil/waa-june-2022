package com.example.lab2phaseii.lab2_phaseII.controller;


import com.example.lab2phaseii.lab2_phaseII.dto.CourseDTO;
import com.example.lab2phaseii.lab2_phaseII.dto.StudentDTO;
import com.example.lab2phaseii.lab2_phaseII.service.serviceImpl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/{major}")
    public List<StudentDTO> getAllStudentbyMajor(@PathVariable("major") String major){
        return studentService.getStudentsByMajor(major);
    }
    @GetMapping(path ="/{id}")
    public List<CourseDTO> findAllCoursesByStudentById(@PathVariable int id){
        return studentService.getCoursesBySudentId(id);

    }
}
