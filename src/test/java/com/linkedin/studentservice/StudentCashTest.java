package com.linkedin.studentservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class StudentCashTest {

    @Autowired
    StudentService studentService;

    @MockBean
    StudentRepository studentRepository;

    @Test
    public void getStudentByIdForMultipleRequest() {
        Long id = 123L;

        // given
        given(studentRepository.findById(id)).willReturn(Optional.of(new Student(id,"Mark")));

        // when
        studentService.getStudentById(id);
        studentService.getStudentById(id);
        studentService.getStudentById(id);

        // then
        then(studentRepository).should(times(1)).findById(id);


    }
}
