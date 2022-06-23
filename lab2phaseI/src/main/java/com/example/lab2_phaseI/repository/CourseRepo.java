package com.example.lab2_phaseI.repository;

import com.example.lab2_phaseI.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {

    private static List<Course> courses =  new ArrayList<>();


    public CourseRepo() {

        Course c1 = new Course(545,"WAA","CS545");
        Course c2 = new Course(525,"ASD","CS525");
        Course c3 = new Course(475,"WAP","CS475");

        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
    }

    public List<Course> getAllCourses(){
        return courses;
    }


    public void createNewCourse(Course course) {
        courses.add(course);
    }
}
