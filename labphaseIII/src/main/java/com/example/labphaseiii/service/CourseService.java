package com.example.labphaseiii.service;

import com.example.labphaseiii.dto.CourseDTO;
import com.example.labphaseiii.entity.Course;

import java.util.List;


public interface CourseService {

   List<CourseDTO> getCoursesBySudentId(int studentId);
   List<CourseDTO> getAllCourse();
   void updateById(int id);
   void deleteById(int id);
    void createNewCourse(Course course);
    ///void save(Course course);

}
