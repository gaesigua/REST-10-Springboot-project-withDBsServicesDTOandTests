package com.gasigwatin.REST_10_Springboot_project_withDBsServicesDTOandTests.student;

import com.gasigwatin.REST_10_Springboot_project_withDBsServicesDTOandTests.school.School;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public StudentResponseDto saveStudent(@Valid @RequestBody StudentDto studentDto){

        return studentService.saveStudent(studentDto);
    }

    @GetMapping("/students")
    public List<StudentResponseDto> retrieveAllStudents(){
       return studentService.retrieveAllStudents();
    }

    @GetMapping("/students/search/{student-id}")
    public StudentResponseDto retrieveOneStudentById(@PathVariable Integer studentId){
        return studentService.retrieveOneStudentById(studentId);
    }

    @GetMapping("/students/search/{student-firstname}")
    public List<StudentResponseDto> retrieveOneStudentByFirstName(@PathVariable("student-firstname") String fName){

        return studentService.retrieveOneStudentByFirstName(fName);

    }

    @DeleteMapping("/students/delete/{student-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteOneStudent(@PathVariable("student-id") Integer studentId){

        studentService.deleteOneStudent(studentId);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){

        var errors = new HashMap<String, String>();

        exception.getBindingResult().getAllErrors().forEach(error -> {
            var fieldName = ((FieldError)error).getField();
            var errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

    }
}
