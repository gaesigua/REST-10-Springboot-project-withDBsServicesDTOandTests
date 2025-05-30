package com.gasigwatin.REST_10_Springboot_project_withDBsServicesDTOandTests.school;

import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {

    public School toSchool(SchoolDto dto){
        return new School(dto.schoolName(), dto.country());
    }

    public SchoolDto toSchoolDto(School school){
        return new SchoolDto(school.getSchoolName(), school.getCountry());
    }
}
