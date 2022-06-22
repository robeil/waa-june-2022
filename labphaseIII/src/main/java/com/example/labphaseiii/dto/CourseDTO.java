package com.example.labphaseiii.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

    private long id;
    private String name;
    private String code;

//    public CourseDTO toDTO(Course course){
//
//        CourseDTO courseDTO = new CourseDTO();
//
//        courseDTO.setCode(course.getCode());
//        courseDTO.setId(course.getId());
//        courseDTO.setName(course.getName());
//
//        return courseDTO;
//    }
//
//    public Course toEntity(){
//       // Course course = new Course(this.id,this.name,this.code);
//        Course course = new Course();
//        course.setCode(this.code);
//        course.setName(this.name);
//        course.setId(this.id);
//
//        return course;
//    }
}
