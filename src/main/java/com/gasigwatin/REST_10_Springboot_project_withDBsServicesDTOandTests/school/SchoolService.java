package com.gasigwatin.REST_10_Springboot_project_withDBsServicesDTOandTests.school;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolRepository schoolRepository, SchoolMapper schoolMapper){
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }

    public SchoolDto postSchoolDetails(SchoolDto schoolDto){
        var school = schoolMapper.toSchool(schoolDto);
        var savedSchool = schoolRepository.save(school);
        return schoolDto;
    }

    public List<SchoolDto> retrieveAllSchools(){

        return schoolRepository.findAll().stream().map(schoolMapper::toSchoolDto).collect(Collectors.toList());
    }

    public void deleteASchool(Integer schoolId){
        schoolRepository.deleteById(schoolId);
    }
}
