package com.example.lab2_phaseI.controller;

import com.example.lab2_phaseI.entity.Student;
import com.example.lab2_phaseI.service.serviceImpl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Student> getAllStudentbyMajor(@PathVariable("major") String major){
        return studentService.getStudentsByMajor(major);
    }
}
