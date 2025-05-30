package com.gasigwatin.REST_10_Springboot_project_withDBsServicesDTOandTests.school;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gasigwatin.REST_10_Springboot_project_withDBsServicesDTOandTests.student.Student;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "SCHOOL TABLE")
public class School {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "SCHOOL NAME", length = 255)
    private String schoolName;

    @Column(name = "COUNTRY", length = 50)
    private String country;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Student> student;


    public School(){}

    public School(String schoolName, String country){
        this.schoolName = schoolName;
        this.country = country;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getSchoolName(){
        return schoolName;
    }

    public void setSchoolName(String schoolName){
        this.schoolName = schoolName;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public List<Student> getStudent(){
        return student;
    }

    public void setStudents(List<Student> student){
        this.student = student;
    }
}
