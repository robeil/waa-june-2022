package com.example.lab2_phaseI.service;

import com.example.lab2_phaseI.entity.Course;

import java.util.List;


public interface CourseService {

   List<Course> getCoursesBySudentId(int studentId);
   List<Course> getAllCourses();
   void updateCourseById(Course course, int id);
   void deleteCourseById(int id);
    void createNewCourse(Course course);
}
