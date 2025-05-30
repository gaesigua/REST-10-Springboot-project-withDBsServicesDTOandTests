package com.gasigwatin.REST_10_Springboot_project_withDBsServicesDTOandTests.student;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gasigwatin.REST_10_Springboot_project_withDBsServicesDTOandTests.school.School;
import jakarta.persistence.*;

@Entity
@Table(name = "STUDENT TABLE")
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "FIRST NAME", length = 100)
    private String firstName;

    @Column(name = "LAST NAME", length = 100)
    private String lastName;

    @Column(name = "EMAIL", length = 100)
    private String email;

    @Column(name = "AGE", length = 3)
    private int age;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "school_id")
    private School school;



    public Student(){}

    public Student(String firstName, String lastName, String email, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public School getSchool(){
        return school;
    }

    public void setSchool(School school){
        this.school = school;
    }
}
