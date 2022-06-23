package com.example.lab2_phaseI.controller;

import com.example.lab2_phaseI.entity.Course;
import com.example.lab2_phaseI.service.serviceImpl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @PutMapping("/{id}")
    public void updateCourseById(@RequestBody Course course, @PathVariable int id){
         courseService.updateCourseById(course,id);
    }

    @PostMapping
    public void createCourse(@RequestBody Course course){
        courseService.createNewCourse(course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourseById(@PathVariable int id){
        courseService.deleteCourseById(id);
    }
}
