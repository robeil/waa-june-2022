package com.example.lab2_phaseI.service;

import com.example.lab2_phaseI.entity.Course;

import java.util.List;


public interface CourseService {

   List<Course> getCoursesBySudentId(int studentId);
   //Course addCourse();
}
