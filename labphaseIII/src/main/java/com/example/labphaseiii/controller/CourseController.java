package com.example.labphaseiii.controller;


import com.example.labphaseiii.dto.CourseDTO;
import com.example.labphaseiii.service.serviceImpl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseServiceImpl courseService;

    @Autowired
    public CourseController(CourseServiceImpl courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDTO> getAllCourse(){
        return courseService.getAllCourse();
    }

    @GetMapping(path = "{id}")
    public List<CourseDTO> getAllCoursesById(@PathVariable("id") int studentId){
        return courseService.getCoursesBySudentId(studentId);
    }

}
