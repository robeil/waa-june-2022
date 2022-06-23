package com.example.lab2phaseiv.service;


import com.example.lab2phaseiv.dto.CourseDTO;
import com.example.lab2phaseiv.entity.Course;

import java.util.List;


public interface CourseService {

   List<CourseDTO> getCoursesBySudentId(int studentId);
   List<CourseDTO> getAllCourse();
   void updateById(int id);
   void deleteById(int id);
    void createNewCourse(Course course);
    ///void save(Course course);

}
