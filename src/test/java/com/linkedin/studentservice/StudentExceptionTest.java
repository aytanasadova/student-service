package com.linkedin.studentservice;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.BDDAssertions.catchThrowable;
import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.clearInvocations;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class StudentExceptionTest {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentService studentService;

    @Test
    void getStudentByIdNotFoundTest() {

        //given
        studentRepository.save(new Student(null, "Mark"));
        Long id = 123L;

        //when
        Throwable throwable = catchThrowable(() -> studentService.getStudentById(id));

        BDDAssertions.then(throwable).isInstanceOf(StudentNotFoundException.class);

//      Assertions.assertThrows(StudentNotFoundException.class,() -> studentService.getStudentById(id));
    }

}
