package com.gasigwatin.REST_10_Springboot_project_withDBsServicesDTOandTests.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper){
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto saveStudent(StudentDto studentDto){

        var student = studentMapper.toStudent(studentDto);
        var savedStudent = studentRepository.save(student);

        return studentMapper.toStudentResponseDto(savedStudent);
    }

    public List<StudentResponseDto> retrieveAllStudents(){

        return studentRepository.findAll().stream().map(studentMapper::toStudentResponseDto).collect(Collectors.toList());
    }

    public StudentResponseDto retrieveOneStudentById(Integer studentId){

        return studentRepository.findById(studentId).map(studentMapper::toStudentResponseDto).orElse(null);

    }

    public List<StudentResponseDto> retrieveOneStudentByFirstName(String fName){

        return studentRepository.findAllByFirstNameContaining(fName).stream().map(studentMapper::toStudentResponseDto).collect(Collectors.toList());
    }

    public void deleteOneStudent(Integer studentId){

        studentRepository.deleteById(studentId);
    }
}
