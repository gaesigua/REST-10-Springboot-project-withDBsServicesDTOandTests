package com.gasigwatin.REST_10_Springboot_project_withDBsServicesDTOandTests.student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

//    Which Service Are We Testing:

    @InjectMocks
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

    //the first object for the "studentDto" parameter
        StudentDto dto = new StudentDto("Allen", "Kayonga", "allen@gmail.com", 23, 2);

    //the second object for the "student" variable

        Student student = new Student("Allen", "Kayonga", "allen@gmail.com", 23);

    //the third object for the "savedStudent" (the student that will be saved in the database)

        Student savedStudent = new Student("Allen", "Kayonga", "allen@gmail.com", 23);

        savedStudent.setId(1);

//    Let's mock the calls from the saveStudent method, since we have mocked their instances, because we want to work in isolation

        when(studentMapper.toStudent(dto))
                .thenReturn(student);

        when(studentRepository.save(student))
                .thenReturn(savedStudent);

        when(studentMapper.toStudentResponseDto(savedStudent)).thenReturn(new StudentResponseDto("Allen", "Kayonga"));

//        When

        StudentResponseDto responseDto = studentService.saveStudent(dto);

//        Then

        assertEquals(student.getFirstName(), dto.firstName());
        assertEquals(student.getLastName(), dto.lastName());
        assertEquals(student.getEmail(), dto.email());
        assertEquals(student.getAge(), dto.age());

//        Now Let's Verify/Ensure that the mocks inside the saveStudent method were called only once

        verify(studentMapper, times(1))
                .toStudent(dto);
        verify(studentRepository, times(1))
                .save(student);
        verify(studentMapper, times(1))
                .toStudentResponseDto(savedStudent);


    }

    @Test
    public void shouldRetrieveListOfAllStudents() {

        //Given

        List<Student> students = new ArrayList<>();

        students.add(new Student("Allen", "Kayonga", "allen@gmail.com", 23));

        //Let's Mock The call

        when(studentRepository.findAll()).thenReturn(students);
        when(studentMapper.toStudentResponseDto(any(Student.class))).thenReturn(new StudentResponseDto("Allen", "Kayonga"));

        //Then

        List<StudentResponseDto> studentResponseDtos = studentService.retrieveAllStudents();

        assertEquals(students.size(), studentResponseDtos.size());

        verify(studentRepository, times(1)).findAll();
        verify(studentMapper, times(1)).getClass();

    }

    @Test
    public void shouldFindStudentById(){
        //Given

        Integer studentId = 1;

        Student student = new Student("Ora", "Kanam", "Ora@gmail.com", 23);

        //Let's Mock The Calls

        when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));
        when(studentMapper.toStudentResponseDto(student)).thenReturn(new StudentResponseDto("Ora", "Kanam"));


        //When

        StudentResponseDto responseDto= studentService.retrieveOneStudentById(studentId);

        //Then

        assertEquals(responseDto.firstName(), student.getFirstName());
        assertEquals(responseDto.lastName(), student.getLastName());

        //Let's verify

        verify(studentRepository, times(1)).findById(studentId);
        verify(studentMapper, times(1)).getClass();
    }

    @Test
    public void shouldFindStudentByFirstName(){

        //Given

        String studentFirstName = "Ora";

        List<Student> students = new ArrayList<>();

        students.add(new Student("Ora", "Kanam", "Ora@gmail.com", 23));



        // Let's Mock the Calls

        when(studentRepository.findAllByFirstNameContaining(studentFirstName)).thenReturn(students);
        when(studentMapper.toStudentResponseDto(any(Student.class)));

        //When

        var responseDtos = studentService.retrieveOneStudentByFirstName(studentFirstName);

        //Then

        assertEquals(students.size(),responseDtos.size());

        //Verify

        verify(studentRepository, times(1)).findAllByFirstNameContaining(studentFirstName);

    }

    @Test
    public void shouldDeleteOneStudent(){

        //Given

        Integer studentId = 1;

        Student student = new Student("Ora", "Kanan", "Ora@gmail.com", 23);

        //Let's Mock The Calls



        //When

        studentService.deleteOneStudent(studentId);


        //Then



        //Verify

        verify(studentRepository, times(1)).deleteById(studentId);



    }

}