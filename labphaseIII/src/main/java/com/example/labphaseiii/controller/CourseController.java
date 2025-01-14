package com.example.labphaseiii.controller;


import com.example.labphaseiii.dto.CourseDTO;
import com.example.labphaseiii.entity.Course;
import com.example.labphaseiii.service.serviceImpl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
//@CrossOrigin //allowing to accept form other origin
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

    @PostMapping
    public void createCourse(@RequestBody Course course){
        courseService.createNewCourse(course);
    }
    @GetMapping(path = "{id}")
    public List<CourseDTO> getAllCoursesById(@PathVariable("id") int studentId){
        return courseService.getCoursesBySudentId(studentId);
    }

}
