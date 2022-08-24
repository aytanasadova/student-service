package com.linkedin.studentservice;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Cacheable("students" )
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException());
    }

    public void updateStudent(Long id, Student student) {
        Student existingStudent = getStudentById(id);
        existingStudent.setName(student.getName());
        existingStudent.setGrade(student.getGrade());
        studentRepository.save(existingStudent);
    }
}
