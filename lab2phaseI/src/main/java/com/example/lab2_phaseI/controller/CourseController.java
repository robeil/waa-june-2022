package com.example.lab2_phaseI.controller;

import com.example.lab2_phaseI.entity.Course;
import com.example.lab2_phaseI.service.serviceImpl.CourseServiceImpl;
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

    @GetMapping(path = "{id}")
    public List<Course> getAllCoursesById(@PathVariable("id") int studentId){
        return courseService.getCoursesBySudentId(studentId);
    }
}
