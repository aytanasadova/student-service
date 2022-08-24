package com.linkedin.studentservice;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StudentController {
    @Autowired
    private final StudentService studentService;

    @PostMapping("/students/{id}")
    Student updateStudent(@PathVariable Long id,
                          @Validated
                          @RequestBody Student student) {
        studentService.updateStudent(id, student);
        return studentService.getStudentById(id);

    }

    @GetMapping("/students/{id}")
    Student getStudent(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    /**
     * To write response inside the class, we can give an annotation to StudentNotFoundExceptionClass too
     * @param e
     */

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    void notFound(StudentNotFoundException e) {
    }

}
