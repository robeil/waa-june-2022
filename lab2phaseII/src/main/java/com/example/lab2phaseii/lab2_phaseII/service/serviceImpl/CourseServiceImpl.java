package com.example.lab2phaseii.lab2_phaseII.service.serviceImpl;

import com.example.lab2phaseii.lab2_phaseII.dto.CourseDTO;
import com.example.lab2phaseii.lab2_phaseII.dto.StudentDTO;
import com.example.lab2phaseii.lab2_phaseII.entity.Course;
import com.example.lab2phaseii.lab2_phaseII.entity.Student;
import com.example.lab2phaseii.lab2_phaseII.repository.CourseRepo;
import com.example.lab2phaseii.lab2_phaseII.repository.StudentRepo;
import com.example.lab2phaseii.lab2_phaseII.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;


    @Override
    public List<CourseDTO> getAllCourse() {

         List<Course> courses = courseRepo.getAllCourses();

        return courses.stream()
                .map(course -> new CourseDTO(course.getId(), course.getName(), course.getCode()))
                .collect(Collectors.toList());
    }

}
