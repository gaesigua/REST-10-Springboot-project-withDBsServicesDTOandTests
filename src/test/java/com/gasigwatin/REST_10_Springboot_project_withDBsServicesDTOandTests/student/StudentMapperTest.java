package com.gasigwatin.REST_10_Springboot_project_withDBsServicesDTOandTests.student;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    private StudentMapper studentMapper;

//    @BeforeAll
//    public static void beforeAll(){
//        System.out.println("Inside My Before All");
//    }

    @BeforeEach
    public void setUp(){
       studentMapper = new StudentMapper();
    }

//    @AfterEach
//    public void tearDown(){
//        System.out.println("Inside My Tear Down");
//    }

    @Test
    public void shouldMapStudentDtoToStudent(){

//    Given
    StudentDto  dto = new StudentDto("Ora", "Kanam", "ora@gmail.com", 15, 1 );

//    When

    Student student = studentMapper.toStudent(dto);

//    Then

    assertEquals(dto.firstName(), student.getFirstName());
    assertEquals(dto.lastName(), student.getLastName());
    assertEquals(dto.email(), student.getEmail());
    assertEquals(dto.age(), student.getAge());

    assertNotNull(student.getSchool());

    assertEquals(dto.schoolId(), student.getSchool().getId());

    }

    @Test
    public void shouldThrow_NullPointerException_if_StudentDto_isNull() {

        var exc = assertThrows(NullPointerException.class, () -> studentMapper.toStudent(null));

        assertEquals("The Student Dto Should Not Be Null!", exc.getMessage());
    }

    @Test
    public void shouldMapStudentToStudentResponseDto(){

//        Given

        Student student = new Student("Uri", "Kanam", "uri@gmail.com", 2);

//        When

        StudentResponseDto response = studentMapper.toStudentResponseDto(student);

//        Then
        assertEquals(response.firstName(), student.getFirstName());
        assertEquals(response.lastName(), student.getLastName());
    }

//    @Test
//    public void testMethod2(){
//        System.out.println("Inside My Test Method 2!");
//    }

}