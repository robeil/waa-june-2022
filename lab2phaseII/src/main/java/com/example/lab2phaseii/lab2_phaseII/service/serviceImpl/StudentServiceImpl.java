package com.example.lab2phaseii.lab2_phaseII.service.serviceImpl;

import com.example.lab2phaseii.lab2_phaseII.dto.CourseDTO;
import com.example.lab2phaseii.lab2_phaseII.dto.StudentDTO;
import com.example.lab2phaseii.lab2_phaseII.entity.Course;
import com.example.lab2phaseii.lab2_phaseII.entity.Student;
import com.example.lab2phaseii.lab2_phaseII.repository.StudentRepo;
import com.example.lab2phaseii.lab2_phaseII.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<StudentDTO> getStudentsByMajor(String major) {

        List<StudentDTO> studentDTOS =new ArrayList<>();

        for(Student student : studentRepo.getAllStudents()) {
            if(student.getMajor().equals(major)) {
                var dto = modelMapper.map(student, StudentDTO.class);
                studentDTOS.add(dto);

            }
        }
        return studentDTOS;
    }

    @Override
    public List<CourseDTO> getCoursesBySudentId(int studentId) {

        List<CourseDTO> students = new ArrayList<>();

        for(Student student: studentRepo.getAllStudents()){
            if(student.getId() == studentId){
                for(Course course : student.getCourses()){
                    var dto = modelMapper.map(course,CourseDTO.class);
                    students.add(dto);
                }
            }
        }
        return  students;

    }
}
