package com.gasigwatin.REST_10_Springboot_project_withDBsServicesDTOandTests.student;

import com.gasigwatin.REST_10_Springboot_project_withDBsServicesDTOandTests.school.School;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public Student toStudent(StudentDto dto){
        if (dto == null){
            throw new NullPointerException("The Student Dto Should Not Be Null!");
        }
        var student = new Student();

        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());
        student.setAge(dto.age());

        var school = new School();

        school.setId(dto.schoolId());

        student.setSchool(school);

        return student;
    }

    public StudentResponseDto toStudentResponseDto(Student student){

        return new StudentResponseDto(student.getFirstName(), student.getLastName());
    }
}
