package com.gasigwatin.REST_10_Springboot_project_withDBsServicesDTOandTests.student;

import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
        @NotEmpty(message = "First Name Should Not Be Empty!")
        String firstName,

        @NotEmpty(message = "Last Name Should Not Be Empty!")
        String lastName,

        String email,

        int age,

        Integer schoolId) {
}
