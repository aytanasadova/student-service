package com.linkedin.studentservice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class StudentServiceTest {

    @Autowired
    private StudentRepository studentRepository;
   @Autowired
    private StudentService studentService;


    @Test
    @DisplayName("Returning saved student from service layer")
    void getStudentById() {

       // given
        Student savedStudent = studentRepository.save(new Student(null, "Mark"));

        //  when
        Student student = studentService.getStudentById(savedStudent.getId());

        // then
        then(student.getName()).isEqualTo("Mark");
        then(student.getId()).isNotNull();

    }
}
