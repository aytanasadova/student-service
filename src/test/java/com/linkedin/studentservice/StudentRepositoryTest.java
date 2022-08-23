package com.linkedin.studentservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.BDDAssertions.then;

@DataJpaTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    void testGetStudentByName_returnsStudentDetails() {

        //given
        Student savedDtudent = studentRepository.save(new Student(null, "Mark"));

        //when
        Student student = studentRepository.getStudentbyName("Mark");
        
        //then
        then(student.getId()).isNotNull();
        then(student.getName()).isEqualTo(savedDtudent);
    }
}
