package com.gasigwatin.REST_10_Springboot_project_withDBsServicesDTOandTests.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

//    Which Service Are We Testing:

    private StudentService studentService;

//    Which dependencies Are We Declaring:

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private StudentMapper studentMapper;

    @BeforeEach
    public void setUp(){

        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_successfully_saveStudent(){

//        Given

    StudentDto studentDto = new StudentDto("Allen", "Kayonga", "allen@gmai.com", 29, 2);

    Student student = new Student("Linda", "Kabera", "linda@gmail.com", 23);

//        When

        StudentResponseDto responseDto = studentService.saveStudent(studentDto);

//        Then


    }

}