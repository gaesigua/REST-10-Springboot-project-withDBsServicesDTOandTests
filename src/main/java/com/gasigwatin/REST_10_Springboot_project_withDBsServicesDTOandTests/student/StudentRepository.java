package com.gasigwatin.REST_10_Springboot_project_withDBsServicesDTOandTests.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllByFirstNameContaining(String fName);

}
