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


    private StudentDTO convertEntityToDto(Student student){

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        StudentDTO  studentDTO = new StudentDTO();
        studentDTO = modelMapper.map(student, StudentDTO.class);

        return studentDTO;
    }

    private Student convertDtoToEntity(StudentDTO studentDTO){

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Student student = new Student();
        student = modelMapper.map(studentDTO,Student.class);

        return student;
    }
    @Override
    public List<Student> getStudentsByMajor(String major) {

//        List<Student> students = new ArrayList<>();
//
//        for(Student student : studentRepo.getAllStudents()){
//            if(student.getMajor().equalsIgnoreCase(major)){
//                students.add(student);
//            }
//        }
//        return students;

        return studentRepo.getAllStudents().stream()
                .filter(m -> m.getMajor().equals(major))
                .collect(Collectors.toList());

    }
}
