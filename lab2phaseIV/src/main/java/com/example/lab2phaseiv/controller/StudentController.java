package com.example.lab2phaseiv.controller;


import com.example.lab2phaseiv.dto.StudentDTO;
import com.example.lab2phaseiv.entity.Student;
import com.example.lab2phaseiv.service.serviceImpl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin
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
