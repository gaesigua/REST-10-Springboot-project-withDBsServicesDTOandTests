package com.gasigwatin.REST_10_Springboot_project_withDBsServicesDTOandTests.student;

public record StudentDto(String firstName, String lastName, String email, int age, Integer schoolId) {
}
