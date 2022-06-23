package com.example.lab2phaseiv.service.serviceImpl;

import com.example.lab2phaseiv.dto.StudentDTO;
import com.example.lab2phaseiv.entity.Student;
import com.example.lab2phaseiv.repository.StudentRepo;
import com.example.lab2phaseiv.service.StudentService;
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

    @Override
    public List<StudentDTO> getStudentsByMajor(String major) {

        List<StudentDTO> studentDTOS = new ArrayList<>();

        for(Student student : studentRepo.getAllStudents()){
            if(student.getMajor().equals(major)) {
                var dto = modelMapper.map(student, StudentDTO.class);
                studentDTOS.add(dto);
            }
        }
        return studentDTOS;
    }
}
