package com.gasigwatin.REST_10_Springboot_project_withDBsServicesDTOandTests.school;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService){
        this.schoolService = schoolService;
    }

    @PostMapping("/schools")
    public SchoolDto postSchoolDetails(@RequestBody SchoolDto schoolDto){
        return schoolService.postSchoolDetails(schoolDto);
    }

    @GetMapping("/schools")
    public List<School> retrieveAllSchools(){

        return schoolService.retrieveAllSchools();
    }

    @DeleteMapping("/schools/{school-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteASchool(@PathVariable("school-id") Integer schoolId){
        schoolService.deleteASchool(schoolId);
    }

}
