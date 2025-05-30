package com.gasigwatin.REST_10_Springboot_project_withDBsServicesDTOandTests.student;

import com.gasigwatin.REST_10_Springboot_project_withDBsServicesDTOandTests.school.School;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @PostMapping("/students")
    public StudentResponseDto postStudentDetails(@RequestBody StudentDto studentDto){

        var student = toStudentDto(studentDto);

        var savedStudent = studentRepository.save(student);

        return toStudentResponseDto(savedStudent);
    }

    private Student toStudentDto(StudentDto dto){
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

    private StudentResponseDto toStudentResponseDto(Student student){
        return new StudentResponseDto(student.getFirstName(), student.getLastName());
    }



    @GetMapping("/students")
    public List<Student> retrieveAllStudents(){
       return studentRepository.findAll();
    }

    @GetMapping("/students/search/{student-id}")
    public Student retrieveOneStudentById(@PathVariable Integer studentId){
        return studentRepository.findById(studentId).orElse(new Student());
    }

    @GetMapping("/students/search/{student-firstname}")
    public List<Student> retrieveOneStudentByFirstName(@PathVariable("student-firstname") String fName){

        return studentRepository.findAllByFirstNameContaining(fName);

    }

    @DeleteMapping("/students/delete/{student-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteOneStudent(@PathVariable("student-id") Integer studentId){

        studentRepository.deleteById(studentId);
    }
}
