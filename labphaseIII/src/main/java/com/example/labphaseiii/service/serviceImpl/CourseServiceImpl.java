package com.example.labphaseiii.service.serviceImpl;

import com.example.labphaseiii.dto.CourseDTO;
import com.example.labphaseiii.dto.StudentDTO;
import com.example.labphaseiii.entity.Course;
import com.example.labphaseiii.entity.Student;
import com.example.labphaseiii.repository.CourseRepo;
import com.example.labphaseiii.repository.StudentRepo;
import com.example.labphaseiii.service.CourseService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    public CourseServiceImpl(CourseRepo courseRepo, StudentRepo studentRepo,ModelMapper modelMapper) {
        this.courseRepo = courseRepo;
        this.studentRepo = studentRepo;
        this.modelMapper = modelMapper;
    }

    private CourseDTO convertEntityToDto(Course course){

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        CourseDTO courseDTO = new CourseDTO();
        courseDTO = modelMapper.map(course,CourseDTO.class);

        return courseDTO;
    }

    private Course convertDtoToEntity(CourseDTO courseDTO){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Course course = new Course();
        course = modelMapper.map(courseDTO,Course.class);

        return course;
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
