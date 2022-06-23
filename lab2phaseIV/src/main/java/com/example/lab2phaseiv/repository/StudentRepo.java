package com.example.lab2phaseiv.repository;

import com.example.lab2phaseiv.entity.Course;
import com.example.lab2phaseiv.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    private static List<Student> students = new ArrayList<>();

    public StudentRepo() {
        Student s1 = new Student(12, "Robeil", "Aregawi", "robeilaregawi@miu.edu", "compro",
                List.of(new Course(13,"Mpp","CS401"), new Course(14,"Fpp","CS390")), 3.8);
        Student s2 = new Student(14, "Keleab", "Brhane", "keleab@miu.edu", "msd",
                List.of(new Course(18,"ASD","CS525"), new Course(24,"WAA","CS545")), 3.6);

        students.add(s1);
        students.add(s2);
    }

    public List<Student> getAllStudents(){
        return students;
    }

    public void save(Student student) {
        students.add(student);
    }
}
