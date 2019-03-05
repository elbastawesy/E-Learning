package com.three2one.assessment.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "student")
public class Student extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Student's name can't by null")
    @Valid
    private String name;

    @NotNull(message = "Student's email can't by null")
    @Valid
    private String email;

    @NotNull(message = "Student's username can't by null")
    @Valid
    private String username;

    @NotNull(message = "Student's password can't by null")
    @Valid
    private String password;

    private String dOB;

    private Long gender;

    public Student() {
    }

    public Student(@NotNull(message = "Student's name can't by null") @Valid String name, @NotNull(message = "Student's email can't by null") @Valid String email, @NotNull(message = "Student's username can't by null") @Valid String username, @NotNull(message = "Student's password can't by null") @Valid String password, String dOB, Long gender) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.dOB = dOB;
        this.gender = gender;
    }

    @PrePersist
    public void validatePrePersist() {
        super.validatePrePersist();
    }

    @PreUpdate
    public void validatePreUpdate() {
        super.validatePreUpdate();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getdOB() {
        return dOB;
    }

    public void setdOB(String dOB) {
        this.dOB = dOB;
    }

    public Long getGender() {
        return gender;
    }

    public void setGender(Long gender) {
        this.gender = gender;
    }
}
