package com.example.lab2phaseiv.service.serviceImpl;

import com.example.lab2phaseiv.dto.CourseDTO;
import com.example.lab2phaseiv.entity.Course;
import com.example.lab2phaseiv.entity.Student;
import com.example.lab2phaseiv.repository.CourseRepo;
import com.example.lab2phaseiv.repository.StudentRepo;
import com.example.lab2phaseiv.service.CourseService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
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

        List<CourseDTO> studentDto = new ArrayList<>();

         for(Student student : studentRepo.getAllStudents()){
             if(student.getId() == studentId){
                for(Course c : student.getCourses()){
                    var dto = modelMapper.map(c, CourseDTO.class);
                    studentDto.add(dto);
                }
             }
        }
         return studentDto;
    }

    @Override
    public List<CourseDTO> getAllCourse() {
        List<CourseDTO> courseDTOS = new ArrayList<>();

        for(Course course: courseRepo.getAllCourses()){
            var dto = modelMapper.map(course, CourseDTO.class);
            courseDTOS.add(dto);
        }
        return courseDTOS;
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
