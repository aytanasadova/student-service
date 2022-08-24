package com.linkedin.studentservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

@DataJpaTest
public class StudentRepositoryTest {

    private final StudentRepository studentRepository;

    private TestEntityManager testEntityManager;

    @Autowired
    public StudentRepositoryTest(StudentRepository studentRepository, TestEntityManager testEntityManager) {
        this.studentRepository = studentRepository;
        this.testEntityManager = testEntityManager;
    }


    @Test
    void testGetStudentByName_returnsStudentDetails() {

        //given
        // Student savedStudent = studentRepository.save(new Student(null, "Mark"));
        Student savedStudent = testEntityManager.persistAndFlush(new Student(null, "Mark"));
        //when
        Student student = studentRepository.getStudentByName("Mark");

        //then
        then(student.getId()).isNotNull();
        then(student.getName()).isEqualTo(savedStudent.getName());
    }
    @Test
    public void averageGradeTest() {

//      given
        Student mark = Student.builder().name("Mark").active(true).grade(80).build();
        Student susan = Student.builder().name("Susan").active(true).grade(100).build();
        Student peter = Student.builder().name("Peter").active(false).grade(50).build();

        Arrays.asList(mark, susan, peter).forEach(testEntityManager::persistAndFlush);

//      when
        Double avgGrade = studentRepository.getAvgGradeForActiveStudents();

//      then
        then(avgGrade).isEqualTo(90);
    }
}
