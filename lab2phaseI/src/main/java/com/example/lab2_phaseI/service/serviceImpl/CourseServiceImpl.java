package com.example.lab2_phaseI.service.serviceImpl;

import com.example.lab2_phaseI.entity.Course;
import com.example.lab2_phaseI.repository.CourseRepo;
import com.example.lab2_phaseI.repository.StudentRepo;
import com.example.lab2_phaseI.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepo courseRepo;
    private StudentRepo studentRepo;

    @Autowired
    public CourseServiceImpl(StudentRepo studentRepo,CourseRepo courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    @Override
    public List<Course> getCoursesBySudentId(int studentId) {

        return studentRepo.getAllStudents().stream()
                .filter(student -> student.getId() == studentId)
                .flatMap(course -> course.getCourses().stream())
                .collect(Collectors.toList());
    }

    @Override
    public List<Course> getAllCourses() {
        return studentRepo.getAllStudents().stream()
                .flatMap(course -> course.getCourses().stream())
                .collect(Collectors.toList());
    }

    @Override
    public void updateCourseById(Course course, int id) {
        courseRepo.getAllCourses().stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .map(c -> new Course(course.getId(), course.getName(), course.getCode()));
    }

    @Override
    public void deleteCourseById(int id) {
        courseRepo.getAllCourses().remove(id);
    }

    @Override
    public void createNewCourse(Course course) {
        courseRepo.createNewCourse(course);
    }

}
