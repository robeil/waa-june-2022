package com.example.labphaseiii.service.serviceImpl;

import com.example.labphaseiii.dto.CourseDTO;
import com.example.labphaseiii.entity.Course;
import com.example.labphaseiii.repository.CourseRepo;
import com.example.labphaseiii.repository.StudentRepo;
import com.example.labphaseiii.service.CourseService;
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
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<CourseDTO> getCoursesBySudentId(int studentId) {

        List<CourseDTO> students = new ArrayList<>();

        return studentRepo.getAllStudents().stream()
                .filter(student -> student.getId() == studentId)
                .flatMap(stud -> stud.getCourses().stream())
                .map(course -> {
                    var dto = modelMapper.map(course, CourseDTO.class);
                    students.add(dto);
                    return students;
                })
                .map(c -> (CourseDTO) c)
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> getAllCourse() {

         List<CourseDTO> courses = new ArrayList<>();

        return courseRepo.getAllCourses().stream()
                .map(course -> {
                    var dto = modelMapper.map(course, CourseDTO.class);
                    courses.add(dto);
                    return course;
                })
                .map(c -> new CourseDTO(c.getId(),c.getName(),c.getCode()))
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

    @Override
    public void createNewCourse(Course course) {
        courseRepo.createNewCourse(course);
    }


}
