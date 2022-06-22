package com.example.labphaseiii;

import com.example.labphaseiii.entity.Course;
import com.example.labphaseiii.entity.Student;
import com.example.labphaseiii.repository.CourseRepo;
import com.example.labphaseiii.repository.StudentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class LabphaseIiiApplication implements CommandLineRunner {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(LabphaseIiiApplication.class, args);
    }

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public void run(String... args) throws Exception {

        Course course = new Course();
        course.setId(11);
        course.setName("DBMS");
        course.setCode("CS478");
        courseRepo.save(course);

        Student student = new Student();
        student.setId(23);
        student.setEmail("someone@miu.edu");
        student.setGpa(3.8);
        student.setFirstName("SomeOne");
        student.setLastName("TheBest");
        student.setMajor("Computer-Science");
        student.setCourses(List.of(new Course(25,"ALGS","CS489")));
        studentRepo.save(student);

    }
}
