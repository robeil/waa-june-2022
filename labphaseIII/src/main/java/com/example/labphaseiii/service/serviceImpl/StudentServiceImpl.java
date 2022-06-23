package com.example.labphaseiii.service.serviceImpl;

import com.example.labphaseiii.dto.CourseDTO;
import com.example.labphaseiii.dto.StudentDTO;
import com.example.labphaseiii.entity.Course;
import com.example.labphaseiii.entity.Student;
import com.example.labphaseiii.repository.StudentRepo;
import com.example.labphaseiii.service.StudentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
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

    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<StudentDTO> getStudentsByMajor(String major) {

        List<StudentDTO> students = new ArrayList<>();

        return studentRepo.getAllStudents().stream()
                .filter(student -> student.getMajor().equals(major))
                .map(stu -> {
                    var stuDto = modelMapper.map(stu,StudentDTO.class);
                    students.add(stuDto);
                    return students;
                })
                .map(s -> new StudentDTO())
                .collect(Collectors.toList());

    }
}
