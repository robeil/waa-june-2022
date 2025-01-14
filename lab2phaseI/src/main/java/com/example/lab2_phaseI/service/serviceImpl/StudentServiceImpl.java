package com.example.lab2_phaseI.service.serviceImpl;

import com.example.lab2_phaseI.entity.Student;
import com.example.lab2_phaseI.repository.StudentRepo;
import com.example.lab2_phaseI.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepo studentRepo;

    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
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
