package com.example.lab2phaseii.lab2_phaseII.service.serviceImpl;

import com.example.lab2phaseii.lab2_phaseII.dto.CourseDTO;
import com.example.lab2phaseii.lab2_phaseII.entity.Course;
import com.example.lab2phaseii.lab2_phaseII.entity.Student;
import com.example.lab2phaseii.lab2_phaseII.repository.CourseRepo;
import com.example.lab2phaseii.lab2_phaseII.repository.StudentRepo;
import com.example.lab2phaseii.lab2_phaseII.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepo courseRepo;
    private StudentRepo studentRepo;

    @Autowired
    public CourseServiceImpl(CourseRepo courseRepo, StudentRepo studentRepo) {
        this.courseRepo = courseRepo;
        this.studentRepo = studentRepo;
    }

    @Override
    public List<CourseDTO> getCoursesBySudentId(int studentId) {

        List<Student> students = studentRepo.getAllStudents();

        return  students.stream()
                .filter(student -> student.getId() == studentId)
                .flatMap(stud -> stud.getCourses().stream())
                .map(course -> new CourseDTO(course.getId(), course.getName(), course.getCode()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> getAllCourse() {

         List<Course> courses = courseRepo.getAllCourses();

        return courses.stream()
                .map(course -> new CourseDTO(course.getId(), course.getName(), course.getCode()))
                .collect(Collectors.toList());
    }

   @Override
    public void updateById(int id) {

       /* List<Course> courses = courseRepo.getAllCourses();
        courses.stream()
                .filter(course -> course.getId() == id)
                .findFirst().get()*/
    }

    @Override
    public void deleteById(int id) {

    }

}
