package com.linkedin.studentservice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@Data
@Entity
@Builder
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private boolean active;
    private int grade;

    public Student(Long id, String name) {
        this.name=name;
    }


}
