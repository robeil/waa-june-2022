package com.example.lab2phaseiv.dto;



import com.example.lab2phaseiv.entity.Course;
import com.example.lab2phaseiv.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<Course> courses;
    private double gpa;

    public StudentDTO toDTO(Student student){

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setId(student.getId());
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setGpa(student.getGpa());
        studentDTO.setCourses(student.getCourses());

        return studentDTO;
    }

    public Student toEntity(){
        Student student = new Student();

        student.setId(this.id);
        student.setFirstName(this.firstName);
        student.setLastName(this.lastName);
        student.setEmail(this.email);
        student.setCourses(this.courses);
        student.setGpa(this.gpa);

        return student;
    }
}
