package com.example.lab2_phaseI.service.serviceImpl;

import com.example.lab2_phaseI.entity.Course;
import com.example.lab2_phaseI.repository.StudentRepo;
import com.example.lab2_phaseI.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    //private CourseRepo courseRepo;
    private StudentRepo studentRepo;

    @Autowired
    public CourseServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Course> getCoursesBySudentId(int studentId) {

        return studentRepo.getAllStudents().stream()
                .filter(student -> student.getId() == studentId)
                .flatMap(course -> course.getCourses().stream())
                .collect(Collectors.toList());
    }
}
