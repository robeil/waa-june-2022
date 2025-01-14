package com.example.labphaseiii.controller;

import com.example.labphaseiii.dto.StudentDTO;
import com.example.labphaseiii.entity.Student;
import com.example.labphaseiii.service.serviceImpl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentServiceImpl studentService;

    @Autowired
    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/{major}")
    public List<StudentDTO> getAllStudentbyMajor(@PathVariable("major") String major){
        return studentService.getStudentsByMajor(major);
    }
}
