package com.example.lab2phaseii.service;

import com.example.lab2phaseii.lab2_phaseII.dto.CourseDTO;
import com.example.lab2phaseii.lab2_phaseII.entity.Course;

import java.util.List;


public interface CourseService {

   List<CourseDTO> getCoursesBySudentId(int studentId);
   List<CourseDTO> getAllCourse();
   void updateById(int id);
   void deleteById(int id);

}
